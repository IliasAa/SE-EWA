export class playermove {
    tokenId;
    tokenPos;
    color;

    constructor(tokenId, tokenPos, color) {
        this.tokenId = tokenId;
        this.tokenPos = tokenPos;
        this.color = color;
    }

    static createPlayermove (tokenId,tokenPos, color){
        return new playermove(tokenId,tokenPos,color)
    }
}
