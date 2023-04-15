export class LoginAdaptor {

    RESOURCE_URL;

    constructor(resourceurl) {
        this.RESOURCE_URL = resourceurl;
        //for jwt

    }

    async fetchJson(url, options = null) {
        let response = await fetch(url, options)
        if (response.ok) {
            return await response.json();
        } else {
            return null;
        }
    }

    async asyncLogIn(username, password) {
        const body = JSON.stringify({username: username, password: password});
        let response = await fetch(this.RESOURCE_URL + "/login",
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
}