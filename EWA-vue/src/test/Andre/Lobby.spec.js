import {Lobby} from '@/models/Lobby'
import userpage from "@/components/userpage/Userpage.vue";

const id = 1;
const collor = "red";
const prive = 0;
const player = 7;
const max = 7;
const ownerId = 2;

let lobby1, lobby2;

beforeEach( function () {
    lobby1 = new Lobby(id,collor,prive,player,max,ownerId);
    lobby2 = Lobby.createLobby("red",);
})

it('creates a proper Lobby user', function () {
    expect(lobby1.selected_color,
        'lobby2 selected_color was not set properly')
        .toBe("red");
    expect(lobby1.isPrivateLobby,
        'lobby2 isPrivateLobby was not set properly')
        .toBe(0);
    expect(lobby1.players_size,
        'lobby2 players_size was not set properly')
        .toBe(7);
    expect(lobby1.max_allowed_Players,
        'lobby2 max_allowed_Players was not set properly')
        .toBe(7);
    expect(lobby1.userid_owner,
        'lobby2 userid_owner was not set properly')
        .toBe(2);

});
it('creates a proper sample user', function () {
    expect(lobby1.selected_color,
        'user2 username was not set properly')
        .toBe("2");
});
it('creates a proper sample user', function () {
    expect(lobby1.selected_color,
        'user2 username was not set properly')
        .toBe("2");
});
it('creates a proper sample user', function () {
    expect(lobby1.selected_color,
        'user2 username was not set properly')
        .toBe("2");
});
