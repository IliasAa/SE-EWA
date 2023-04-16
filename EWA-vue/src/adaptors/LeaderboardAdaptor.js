export class LeaderboardAdaptor {
    RECOURCE_URL;

    constructor(RECOURCE_URL) {
        this.RESOURCE_URL = resourceurl;
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

    async findAll() {
        return await this.fetchJSon(this.RECOURCE_URL)
    }

}
