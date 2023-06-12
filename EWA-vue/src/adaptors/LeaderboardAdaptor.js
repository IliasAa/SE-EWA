export class LeaderboardAdaptor {
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

    async asyncFindAll() {
        return await this.fetchJSon(this.resourceUrl);
    }

}