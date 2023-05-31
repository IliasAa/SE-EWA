export class playermove {
    tokenId;
    tokenPos;

    constructor(tokenId, tokenPos) {
        this.tokenId = tokenId;
        this.tokenPos = tokenPos;
    }

    static createPlayermove (tokenId,tokenPos){
        return new playermove(tokenId,tokenPos)
    }
}
