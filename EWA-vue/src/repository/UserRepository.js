import config from "@/scripts/config";


export default class UserRepository {
    url; //URL of the endpoint

    constructor() {
        this.url = process.env.VUE_APP_API_URL + '/users';
    }

    async registerUser(username, firstname, lastname, email, password, role){
        return await config.post(
            this.url + "/register",
            {
                username, firstname, lastname, email, password, role
            }
        );
    }
}