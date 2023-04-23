export class User {

    username;
    firstname;
    lastname;
    email;
    password;
    role;


    constructor(username, firstname, lastname, email, password, role) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    static createUser(username, firstname, lastname, email, password, role) {
        return new User(username, firstname, lastname, email, password, role)
    }


}

export default User;