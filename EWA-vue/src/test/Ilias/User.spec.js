import { FakeUser } from "../../models/FakeUser";

const USER_ID = 10;
const USER_USERNAME = "Bob";
const USER_EMAIL = "Bob@mail.com";
const USER_COINS = 200;
const USER_WINS = 0;

let User1, User2

beforeEach(function (){
    User1 = new FakeUser(USER_ID,USER_USERNAME,USER_EMAIL,USER_COINS,USER_WINS);
    User2 = FakeUser.createSampleUser(USER_ID + 1)
})
describe ('Fake User', function (){
    it ('creates user sample correctly', function (){
        expect(User1.userId).toBe(USER_ID)
    })
})


