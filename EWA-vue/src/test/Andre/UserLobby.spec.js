import {Lobby} from '@/models/Lobby'
import userpage from "@/components/userpage/Userpage.vue";
import {UserLobby} from "@/models/UserLobby";

const selected_color = "red";
const user_user_id = 3;
const lobby_id_lobby = 1;
const userId_owner = 7;


let userLobby1, userLobby2;

beforeEach( function () {
    userLobby1 = new UserLobby(selected_color,user_user_id,lobby_id_lobby,userId_owner);
    userLobby2 = UserLobby.createUserLobby("green",4,1,7);
})

describe('Lobby', function () {
    it('creates a proper userLobbby', function () {
        expect(userLobby1.selected_color,
            'userLobby1 selected_color was not set properly')
            .toBe("red");
        expect(userLobby1.user_user_id,
            'userLobby1 isPrivateLobby was not set properly')
            .toBe(0);
        expect(userLobby1.lobby_id_lobby,
            'userLobby1 players_size was not set properly')
            .toBe(7);
        expect(userLobby1.userId_owner,
            'userLobby1 max_allowed_Players was not set properly')
            .toBe(7);
    });
});

