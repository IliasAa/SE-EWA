class User{

    userId;
    Username;
    firstname;
    lastname;
    email;
    password;
    role;


    constructor(userId, Username, firstname, lastname, email, password, role) {
        this.userId = userId;
        this.Username = Username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}

export default User;