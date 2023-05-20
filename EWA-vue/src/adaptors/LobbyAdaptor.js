export class LobbyAdaptor {
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
        return await this.fetchJSon(this.RESOURCE_URL);
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

    async asyncUpdate(lobby) {
        await this.fetchJSon(this.RESOURCE_URL + "/" + lobby.idLobby, {
                headers: {'Content-Type': 'application/json'},
                method: 'PUT',
                body: JSON.stringify({lobby})
            },
        );
    }

    async asyncFindByjoincode(join_code) {
        return await this.fetchJSon(this.RESOURCE_URL + "/" + join_code);
    }

    async combineUserWithLobby(userid, LobbyId, selectedcolor) {
        await this.fetchJSon(this.RESOURCE_URL + "/" + userid + "/" + LobbyId + "/" + selectedcolor, {
            headers: {'Content-Type': 'application/json'},
            method: 'POST',
        },)
    }

    async asyncSave(lobby) {
        await this.fetchJSon(this.RESOURCE_URL, {
            headers: {'Content-Type': 'application/json'},
            method: 'POST',
            body: JSON.stringify(lobby)
        },)
    }

    async asyncFindId(id) {
        return await this.fetchJSon(this.RESOURCE_URL + "/get/" + id);
    }

    async asyncFindAllConnectedToLobby(LobbyId) {
        return await this.fetchJSon(this.RESOURCE_URL + "/lobby/" + LobbyId);
    }
    async asyncFindColorConnectedToUser(LobbyId,userId) {
        return await this.fetchJSon(this.RESOURCE_URL + "/lobby/" + LobbyId + "/" + userId);
    }

}