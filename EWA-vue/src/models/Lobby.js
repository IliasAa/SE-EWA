export class Lobby {
    join_code;
    selected_color;
    isPrivateLobby;
    players_size;
    max_allowed_Players;

    userid_owner;


    constructor(join_code, selected_color, isPrivateLobby, players_size, max_allowed_Players, userid_owner) {
        this.join_code = join_code;
        this.selected_color = selected_color;
        this.isPrivateLobby = isPrivateLobby;
        this.players_size = players_size;
        this.max_allowed_Players = max_allowed_Players;
        this.userid_owner = userid_owner;
    }

    static makeLobbycode(length) {
        let result = '';
        const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        const charactersLength = characters.length;
        let counter = 0;
        while (counter < length) {
            result += characters.charAt(Math.floor(Math.random() * charactersLength));
            counter += 1;
        }
        return result;
    }

    static createLobby(selected_color, isPrivateLobby, players_size, max_allowed_Players,userid_owner){
        return new Lobby(this.makeLobbycode(7),selected_color,isPrivateLobby,players_size,
            max_allowed_Players,userid_owner);
    }

}