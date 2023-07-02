import {Lobby} from '../../models/Lobby'
// import userpage from "@/components/userpage/Userpage.vue";
import {UserLobby} from "../../models/UserLobby";

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
        expect(userLobby1.selected_color).toBe("red");
        expect(userLobby1.user_user_id).toBe(3);
        expect(userLobby1.lobby_id_lobby).toBe(1);
        expect(userLobby1.userId_owner).toBe(7);
    });
});

