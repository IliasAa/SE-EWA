export class diceAdaptor {
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

    async asyncFindAllInLobby(lobbyId) {
        return await this.fetchJSon(this.resourceUrl + "/" + lobbyId);
    }

    async asyncAllFindOnColorAndID(lobbyId, selectedColor) {
        return await this.fetchJSon(this.resourceUrl + "/" + lobbyId + "/" + selectedColor);
    }

    async asyncFindOnColorAndID(lobbyId, selectedColor) {
        return await this.fetchJSon(this.resourceUrl + "/number/" + lobbyId + "/" + selectedColor);
    }

    async addExtrastep(lobbyId, selectedColor,result) {
        await this.fetchJSon(this.resourceUrl + "/" + lobbyId + "/" + selectedColor + "/" + result, {
            headers: {'Content-Type': 'application/json'},
            method: 'POST',
        },)
    }

    async addStepToRecord(turn) {
        await this.fetchJSon(this.resourceUrl , {
            headers: {'Content-Type': 'application/json'},
            method: 'PUT',
            body: JSON.stringify(turn)
        },)
    }

}