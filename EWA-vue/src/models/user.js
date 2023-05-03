export class User {

    username;
    firstname;
    lastname;
    email;
    password;
    points;
    isAdmin;
    role;


    constructor(username, firstname, lastname, email, password, points, isAdmin, role) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.points = points;
        this.isAdmin = isAdmin;
        this.role = role;
    }

    static createUser(username, firstname, lastname, email, password, role) {
        return new User(username, firstname, lastname, email, password, role)
    }

    get isAdmin() {
        return this.isAdmin;
    }




}



export default User;
