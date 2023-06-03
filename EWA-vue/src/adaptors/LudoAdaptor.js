export class LudoAdaptor {
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

    async asyncFindAllWithLobbyid(lobbyId){
        return await this.fetchJSon(this.RESOURCE_URL + "/" + lobbyId);
    }


    async asyncFindOnTokedIdAndLobby(tokenId,Lobby){
        return await this.fetchJSon(this.RESOURCE_URL + "/" + tokenId + "/" + Lobby);
    }

    async asyncSaveUsermove(playermove,lobbyId, color) {
        await this.fetchJSon(this.RESOURCE_URL + "/save/" + lobbyId + "/" + color,{
            headers: {'Content-Type': 'application/json'},
            method: 'POST',
            body: JSON.stringify(playermove)
        },)
    }

    async asyncUpdatePlayerPos(move, color) {
        await this.fetchJSon(this.RESOURCE_URL + "/" + color, {
            headers: {'Content-Type': 'application/json'},
            method: 'PUT',
            body: JSON.stringify(move)
        },)
    }





}