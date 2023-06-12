export class AuthenticationAdaptor {

    resourceUrl = process.env.VUE_APP_API_URL;

    constructor(resourceUrl) {
        resourceUrl = this.resourceUrl;
    }

    async fetchJSon(url, options = null) {
        let respone = await fetch(url, options)
        if (respone.ok) {
            return await respone.json();
        } else {
            // response body provides the http-error information
            console.log(respone, !respone.bodyUsed ? await respone.text() : "");
            return null;
        }
    }

    async asyncLogIn(username, password) {
        const body = JSON.stringify({username: username, password: password});
        let response = await fetch(this.resourceUrl + "/login",
            {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: body,
                credentials: 'include',
            })
        if (response.ok) {
            console.log("OK")
            return await response.json();
        } else {
            console.log("NOT OK")
            console.log(response)
            return null;
        }
    }

    async asyncSave(user) {
        await this.fetchJSon(this.resourceUrl + "/register", {
            headers: {'Content-Type': 'application/json'},
            method: 'POST',
            body: JSON.stringify(user)
        },)
    }
}