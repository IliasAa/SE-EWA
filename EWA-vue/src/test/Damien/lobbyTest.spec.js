import {Lobby} from '../../models/Lobby'

let lobby
const code = "XH2030";
const color = "green";
const isPrivate = 2;
const pSize = 3;
const maxAllowed = 4;
const userIdOwner = 1;

beforeEach(function () {

    lobby = new Lobby(code,color,isPrivate,pSize,maxAllowed,userIdOwner);

})

it('Creates a lobby and check results.', function () {
    expect(lobby.join_code).toBe(code);
    expect(lobby.selected_color).toBe(color);
    expect(lobby.isPrivateLobby).toBe(isPrivate);
    expect(lobby.players_size).toBe(pSize);
    expect(lobby.max_allowed_Players).toBe(maxAllowed);
    expect(lobby.userid_owner).toBe(userIdOwner);
});

