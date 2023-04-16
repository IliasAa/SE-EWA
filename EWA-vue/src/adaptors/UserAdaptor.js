export class UserAdaptor {
    RESOURCE_URL;

    constructor(resourceurl) {
        this.RESOURCE_URL = resourceurl;
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
        console.log('UserAdaptor.asyncFindAll()...');
    }

    async asyncFindId(id) {
        return await this.fetchJSon(this.RESOURCE_URL + "/" + id);
    }


    async asyncDeleteById(id) {
        return this.fetchJSon(this.RESOURCE_URL + "/" + id,
            {
                method: 'DELETE'
            });
    }

}
