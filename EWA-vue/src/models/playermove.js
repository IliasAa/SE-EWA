export class playermove {
   pawnId;
   pawnPos;

   lobbyId;

    constructor(pawnId, pawnPos, lobbyId) {
        this.pawnId = pawnId;
        this.pawnPos = pawnPos;
        this.lobbyId = lobbyId;
    }

    static createPlayermove (pawnId,pawnPos,lobbyId){
        return new playermove(pawnId,pawnPos,lobbyId)
    }
}
