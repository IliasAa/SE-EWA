import {Lobby} from '../../models/Lobby'

const joinCode = "1234567";
const collor = "red";
const prive = 0;
const player = 7;
const max = 7;
const ownerId = 2;

let lobby1, lobby2;

beforeEach( function () {
    lobby1 = new Lobby(joinCode, collor,prive,player,max,ownerId);
    lobby2 = Lobby.createLobby("red",);
})

describe('Lobby', function () {
    it('creates a proper Lobby user', function () {
        expect(lobby1.join_code, "join code was not set properly").toBe(joinCode);
        expect(lobby1.isPrivateLobby, "private lobby was not set properly").toBe(0);
        expect(lobby1.players_size, "player size was not set properly").toBe(7);
        expect(lobby1.max_allowed_Players, "max players was not set properly").toBe(7);
        expect(lobby1.userid_owner, "owner id was not set properly").toBe(2);
    });


});


