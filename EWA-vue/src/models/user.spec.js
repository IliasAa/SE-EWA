import {User} from '@/models/user'

const username = 1;
const voornaam = "jan";
const achternaam = "jan";
const email = "jan";
const wachtwoord = "jan";
const points = 7;
const admin = true;
const role = "player";

let user1, user2;

beforeEach( function () {
    user1 = new User(username,voornaam,achternaam,email,wachtwoord,points,admin,role);
    user2 = User.createUser(username + 1);
})

it('creates a proper sample user', function () {
    expect(user2.userName,
        'user2 username was not set properly')
        .toBe(username+1);
    expect(user2.lastName,
        'user2 lastName was not set properly')
        .toBeTruthy();
});