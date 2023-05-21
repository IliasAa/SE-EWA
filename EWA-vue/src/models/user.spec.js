import {Lobby} from '@/models/lobby'
import userpage from "@/components/userpage/Userpage.vue";

const id = 1;
const collor = "2";
const prive = 7;
const player = 7;
const max = 7;

let lobby1, lobby2;

beforeEach( function () {
    lobby1 = new Lobby(id,collor,prive,player,max);
    lobby2 = Lobby.createLobby("2");
})

it('creates a proper sample user', function () {
    expect(lobby1.userName,
        'user2 username was not set properly')
        .toBe("2");
});