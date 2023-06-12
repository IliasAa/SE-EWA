export class LudoAdaptor {
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

    async asyncFindAllWithLobbyid(lobbyId){
        return await this.fetchJSon(this.resourceUrl + "/" + lobbyId);
    }


    async asyncFindOnTokedIdAndLobby(tokenId,Lobby){
        return await this.fetchJSon(this.resourceUrl + "/" + tokenId + "/" + Lobby);
    }

    async asyncSaveUsermove(playermove,lobbyId) {
        await this.fetchJSon(this.resourceUrl + "/save/" + lobbyId,{
            headers: {'Content-Type': 'application/json'},
            method: 'POST',
            body: JSON.stringify(playermove)
        },)
    }

    async asyncUpdatePlayerPos(move) {
        await this.fetchJSon(this.resourceUrl , {
            headers: {'Content-Type': 'application/json'},
            method: 'PUT',
            body: JSON.stringify(move)
        },)
    }
}