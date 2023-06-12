export class LobbyAdaptor {
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
        return await this.fetchJSon(this.resourceUrl);
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

    async asyncUpdate(lobby) {
        await this.fetchJSon(this.resourceUrl + "/" + lobby.idLobby, {
                headers: {'Content-Type': 'application/json'},
                method: 'PUT',
                body: JSON.stringify(lobby)
            },
        );
    }

    async asyncFindByjoincode(join_code) {
        return await this.fetchJSon(this.resourceUrl + "/" + join_code);
    }

    async combineUserWithLobby(userid, LobbyId, selectedcolor) {
        await this.fetchJSon(this.resourceUrl + "/" + userid + "/" + LobbyId + "/" + selectedcolor, {
            headers: {'Content-Type': 'application/json'},
            method: 'POST',
        },)
    }


    async asyncSave(lobby) {
        await this.fetchJSon(this.resourceUrl, {
            headers: {'Content-Type': 'application/json'},
            method: 'POST',
            body: JSON.stringify(lobby)
        },)
    }

    async asyncFindId(id) {
        return await this.fetchJSon(this.resourceUrl + "/get/" + id);
    }


    async asyncFindAllConnectedToLobby(LobbyId) {
        return await this.fetchJSon(this.resourceUrl + "/lobby/" + LobbyId);
    }
    async asyncFindColorToLobby(LobbyId) {
        return await this.fetchJSon(this.resourceUrl + "/color/" + LobbyId);
    }
    async asyncFindMaxPlayerCountCompare(LobbyId) {
        return await this.fetchJSon(this.resourceUrl + "/max/" + LobbyId);
    }

    async asyncFindColorConnectedToUser(LobbyId,userId) {
        return await this.fetchJSon(this.resourceUrl + "/" + LobbyId + "/" + userId);
    }



}