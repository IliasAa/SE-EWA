export class SessionService {
    RESOURCES_URL;              // the back-end base url for authentication resources
    BROWSER_STORAGE_ITEM_NAME;  // the key into browser storage for retaining the token and account
    _currentToken;              // the current authentication token of this session// to be injected in the authorization header of every outgoing request
    _currentAccount;            // the account instant of the currently logged on user


    constructor(resourcesUrl, browserStorageItemName) {
        console.log("Created SessionService...");
        this.BROWSER_STORAGE_ITEM_NAME = browserStorageItemName;
        this.RESOURCES_URL = resourcesUrl;
        this._currentAccount = null;
        this._currentToken = null;
        // retrieve the current user info from browser storage,
        // e.g. after a page reload or when a new tab is opened.
        this.getTokenFromBrowserStorage();
    }

    get currentToken() {
        return this._currentToken;
    }

    get currentAccount() {
        return this._currentAccount;
    }

    isAdmin() {
        return this._currentAccount?.role?.toLowerCase().includes("admin");
    }
    isAuthenticated() {
        return this._currentAccount != null;
    }

    getTokenFromBrowserStorage() {
        if (this._currentToken != null) return this._currentToken
        this._currentToken = window.sessionStorage.getItem(this.BROWSER_STORAGE_ITEM_NAME);
        let jsonAccount = window.sessionStorage.getItem(this.BROWSER_STORAGE_ITEM_NAME+"_ACC");

        if (this._currentToken == null) {
            // TODO try to find the token+account in local storage and replicate to this session if found
            const localToken = localStorage.getItem(this.BROWSER_STORAGE_ITEM_NAME);
            const localAccount = localStorage.getItem(this.BROWSER_STORAGE_ITEM_NAME+"_ACC");

            if (localToken != null && localAccount != null){
                window.sessionStorage.setItem(this.BROWSER_STORAGE_ITEM_NAME, localToken)
                window.sessionStorage.setItem(this.BROWSER_STORAGE_ITEM_NAME+"_ACC", localAccount)
            }
        }
        if (jsonAccount != null) {
            this._currentAccount = JSON.parse(jsonAccount);
        }
        //console.log("SessionService recovered token: ", this._currentToken);
        //console.log("Current Account:", this._currentAccount);
        return this._currentToken;
    }

    saveTokenIntoBrowserStorage(token, account) {
        this._currentToken = token;
        this._currentAccount = account;
        // allow for different user sessions from the same computer
        // sessionStorage keeps different items per browser tab
        // localStorage keeps a single item per browser vendor
        // both isolate the items per server domain of the page (including port number?)
        if (token == null) {
            this._currentAccount = null;
            const sessionToken = window.sessionStorage.getItem(this.BROWSER_STORAGE_ITEM_NAME);
            const sessionAccount = window.sessionStorage.getItem(this.BROWSER_STORAGE_ITEM_NAME+"_ACC");
            window.sessionStorage.removeItem(this.BROWSER_STORAGE_ITEM_NAME);
            window.sessionStorage.removeItem(this.BROWSER_STORAGE_ITEM_NAME+"_ACC");
            // TODO remove the token+account from local storage, if localStorage and session storage are equal
            const localToken = localStorage.getItem(this.BROWSER_STORAGE_ITEM_NAME);
            const localAccount = localStorage.getItem(this.BROWSER_STORAGE_ITEM_NAME+"_ACC");

            if (sessionToken === localToken && sessionAccount === localAccount) {
                localStorage.removeItem(this.BROWSER_STORAGE_ITEM_NAME);
                localStorage.removeItem(this.BROWSER_STORAGE_ITEM_NAME+"_ACC");
            }
        } else{
            if (account != null){
                console.log("New token for " + account.username + ": " + token);
                window.sessionStorage.setItem(this.BROWSER_STORAGE_ITEM_NAME+"_ACC", JSON.stringify(account));
                localStorage.setItem(this.BROWSER_STORAGE_ITEM_NAME + "_ACC", JSON.stringify(account));
            }else{
                localStorage.removeItem(this.BROWSER_STORAGE_ITEM_NAME+"_ACC")
                window.sessionStorage.removeItem(this.BROWSER_STORAGE_ITEM_NAME+"_ACC");

            }

            window.sessionStorage.setItem(this.BROWSER_STORAGE_ITEM_NAME, token);
            // TODO also save the new token+account in localStorage
            localStorage.setItem(this.BROWSER_STORAGE_ITEM_NAME, token);

        }
    }

    async asyncSignIn(username, password) {
        const body = JSON.stringify({ username: username, password: password });
        let response = await fetch(this.RESOURCES_URL + "/login",
            {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: body
            })
        if (response.ok) {
            let account = await response.json();
            this.saveTokenIntoBrowserStorage(
                response.headers.get('Authorization'),
                account);
            return account;
        } else {
            console.log(response)
            return null;
        }
    }

    signOut() {
        this.saveTokenIntoBrowserStorage(null, null);
    }
}
