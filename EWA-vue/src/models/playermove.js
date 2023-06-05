export class playermove {
    tokenId;
    tokenPos;

    constructor(tokenId, tokenPos, color) {
        this.tokenId = tokenId;
        this.tokenPos = tokenPos;
    }

    static createPlayermove (tokenId,tokenPos){
        return new playermove(tokenId,tokenPos)
    }
}
