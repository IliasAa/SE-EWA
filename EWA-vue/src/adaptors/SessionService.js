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
        let jsonAccount = window.sessionStorage.getItem(this.BROWSER_STORAGE_ITEM_NAME + "_ACC");

        if (this._currentToken == null) {
            // TODO try to find the token+account in local storage and replicate to this session if found
            const localToken = localStorage.getItem(this.BROWSER_STORAGE_ITEM_NAME);
            const localAccount = localStorage.getItem(this.BROWSER_STORAGE_ITEM_NAME + "_ACC");

            if (localToken != null) {
                window.sessionStorage.setItem(this.BROWSER_STORAGE_ITEM_NAME, localToken)
                this._currentToken = localToken;
            }
            if (localAccount != null) {
                window.sessionStorage.setItem(this.BROWSER_STORAGE_ITEM_NAME + "_ACC", localAccount)
                this._currentAccount = localAccount
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
            const sessionAccount = window.sessionStorage.getItem(this.BROWSER_STORAGE_ITEM_NAME + "_ACC");
            window.sessionStorage.removeItem(this.BROWSER_STORAGE_ITEM_NAME);
            window.sessionStorage.removeItem(this.BROWSER_STORAGE_ITEM_NAME + "_ACC");
            // TODO remove the token+account from local storage, if localStorage and session storage are equal
            const localToken = localStorage.getItem(this.BROWSER_STORAGE_ITEM_NAME);
            const localAccount = localStorage.getItem(this.BROWSER_STORAGE_ITEM_NAME + "_ACC");

            if (sessionToken === localToken && sessionAccount === localAccount) {
                localStorage.removeItem(this.BROWSER_STORAGE_ITEM_NAME);
                localStorage.removeItem(this.BROWSER_STORAGE_ITEM_NAME + "_ACC");
            }
        } else {
            if (account != null) {
                console.log("New token for " + account.username + ": " + token);
                window.sessionStorage.setItem(this.BROWSER_STORAGE_ITEM_NAME + "_ACC", JSON.stringify(account));
                localStorage.setItem(this.BROWSER_STORAGE_ITEM_NAME + "_ACC", JSON.stringify(account));
            } else if (account === 0) {
                localStorage.removeItem(this.BROWSER_STORAGE_ITEM_NAME + "_ACC")
                window.sessionStorage.removeItem(this.BROWSER_STORAGE_ITEM_NAME + "_ACC");

            }

            window.sessionStorage.setItem(this.BROWSER_STORAGE_ITEM_NAME, token);
            // TODO also save the new token+account in localStorage
            localStorage.setItem(this.BROWSER_STORAGE_ITEM_NAME, token);

        }
    }

    removeSessionAndLocalStorage() {
        // remove everything from local storage
        localStorage.removeItem(this.BROWSER_STORAGE_ITEM_NAME)
        localStorage.removeItem(this.BROWSER_STORAGE_ITEM_NAME + "_ACC");

        // remove everything from session storage
        window.sessionStorage.removeItem(this.BROWSER_STORAGE_ITEM_NAME);
        window.sessionStorage.removeItem(this.BROWSER_STORAGE_ITEM_NAME + "_ACC");
    }

    async asyncSignIn(username, password) {
        const body = JSON.stringify({username: username, password: password});
        let response = await fetch(this.RESOURCES_URL + "/login",
            {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: body,
                withCredentials: true
            })
        if (response.ok) {
            let account = await response.json();
            this.saveTokenIntoBrowserStorage(
                response.headers.get('Authorization'),
                account);
            await this.getRefreshToken(account)
            return account;
        }

        return null;
    }

    setCookie(cname, cvalue, exdays) {
        const d = new Date();
        d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
        let expires = "expires=" + d.toUTCString();
        document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
    }

    async refresh(refresh_token) {
        let response = await fetch(this.RESOURCES_URL + "/refresh",
            {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: refresh_token
            })
        if (response.ok) {
            this._currentToken = response;
        }
        return response;
    }

    async getRefreshToken(account) {
        console.log(account)
        let response = await fetch(this.RESOURCES_URL + "/getRefreshToken",
            {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(account)
            })
        if (response.ok) {
            let refreshTokenJson = await response.json()
            this.setCookie("refresh_token", refreshTokenJson.refreshToken, 1)
            return refreshTokenJson;
        }
    }



    async signOut() {
        // delete all tokens from db
        await fetch(this.RESOURCES_URL + "/" + this._currentAccount.userId,
            {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
            })

        // delete storage
        document.cookie = "refresh_token=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
        this.removeSessionAndLocalStorage()
    }

}
