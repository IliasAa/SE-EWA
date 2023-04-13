export class Lobby {
    Lobbycode;

    constructor(Lobbycode) {
        this.Lobbycode = Lobbycode;
    }

    static creatSampleLobby(){
        return new Lobby(this.createCode())
    }

    static createCode(){
        let code = "";
        let tagLength = 8;
        let characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (let i = 0; i < tagLength; i++) {
            code += characterSet.charAt(Math.random() * characterSet.length);
        }

        return code;
    }

}