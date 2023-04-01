export class User{

    userId;
    userName;
    email;
    coins;
    wins;

    constructor(userId, userName, email, coins, wins){
        this.userName = userName;
        this.email = email;
        this.coins = coins;
        this.wins = wins;
        this.userId = userId;
    }


    static createSampleUser(){
        return new User(this.createId(), this.randomUser(), this.randomMail(), this.createCoints(), this.winsCount())
    }

    static randomUser() {
        var playerName
        var name = ["Emily", 'Jacob', 'Sophia', 'Michael', 'Emma', 'Ethan', 'Olivia', 'William', 'Ava', 'Alexander'];
            playerName = name.at(Math.random() * 9)
        return playerName;
    }

    static randomMail() {
        var playerMail
        var name = ["Emily@hotmail.nl", 'Jacob@outlook.com', 'Sophia@hotmail.com'];
        playerMail = name.at(Math.random() * 3)
        return playerMail;
    }

    static createId(){
        return Math.round(Math.random() * 10000);
    }

    static createCoints(){
        return Math.round(Math.random() * 1000000);
    }

    static winsCount(){
        return Math.round(Math.random() * 1000);
    }


    get userId() {
        return this.userId;
    }
}