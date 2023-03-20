export class User{

    userId;
    userName;
    email;
    coins;
    wins;

    constructor(userId, userName, email, coins, wins){
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.coins = coins;
        this.wins = wins;
    }

    userName = ['Emily', 'Jacob', 'Sophia', 'Michael', 'Emma', 'Ethan', 'Olivia', 'William', 'Ava', 'Alexander'];

    static createSampleUser(){
        function randomInt(min, max) {
            return Math.floor(Math.random() * (max - min + 1)) + min;
        }


    }
}