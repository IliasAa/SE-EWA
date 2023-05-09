export class UserAdaptor {
    RESOURCE_URL;

    constructor(resourceUrl) {
        this.RESOURCE_URL = resourceUrl;
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
        console.log('UserAdaptor.asyncFindAll()...');

    }

    async asyncGetInfo() {
        console.log("Info about client is being retrieved...")
        return await this.fetchJSon(this.RESOURCE_URL + "/info",
            {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                },
            })
    }

    async getNumberOfUsers() {
        return  await this.fetchJSon(this.RESOURCE_URL + "/count",
            {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                }
            })
    }

    async asyncFindId(id) {
        return await this.fetchJSon(this.RESOURCE_URL + "/get/" + id);
    }


    async asyncDeleteById(id) {
        return this.fetchJSon(this.RESOURCE_URL + "/" + id,
            {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this.asyncFindId(id))
            });
    }



    async asyncUpdate(user) {
        await this.fetchJSon(this.RESOURCE_URL + "/" + user.userId, {
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


}
