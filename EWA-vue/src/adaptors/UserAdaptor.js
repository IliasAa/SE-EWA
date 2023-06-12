export class UserAdaptor {
    resourceUrl = process.env.VUE_APP_API_URL;

    constructor(resourceUrl) {
        resourceUrl = this.resourceUrl;
    }

    async fetchJSon(url, options = null) {
        let response = await fetch(url, options)
        if (response.ok) {
            return await response.json();
        } else {
            // response body provides the http-error information
            console.log(response, !response.bodyUsed ? await response.text() : "");
            return null;
        }
    }

    async asyncFindAll() {
        return  await this.fetchJSon(this.resourceUrl,
            {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                }
            })
    }

    async asyncGetInfo() {
        console.log("Info about client is being retrieved...")
        return await this.fetchJSon(this.resourceUrl + "/info",
            {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                },
            })
    }

    async getNumberOfUsers() {
        return  await this.fetchJSon(this.resourceUrl + "/count",
            {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                }
            })
    }

    async asyncFindLobbyOwner(id) {
        return await this.fetchJSon(this.resourceUrl + "/owner/" + id)
    }

    async asyncFindId(id) {
        return this.fetchJSon(this.resourceUrl + "/get/" + id,
            {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                },
            });
    }


    async asyncDeleteById(id) {
        return this.fetchJSon(this.resourceUrl + "/" + id,
            {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this.asyncFindId(id))
            });
    }


    async asyncUpdate(user) {
        await this.fetchJSon(this.resourceUrl + "/" + user.userId, {
                headers: {'Content-Type': 'application/json'},
                method: 'PUT',
                body: JSON.stringify({
                    "userId": user.id,
                    "email": user.email,
                    "password": user.password,
                    "role": user.role,
                    "username": user.username,
                    "firstname": user.firstname,
                    "lastname": user.lastname
                })
            },
        );
    }

    async asyncAdminUpdate(user) {
        await this.fetchJSon(this.resourceUrl + "/" + user.userId, {
                headers: {'Content-Type': 'application/json'},
                method: 'PUT',
                body: JSON.stringify(user)
            },
        );
    }


}
