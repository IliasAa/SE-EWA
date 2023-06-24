export class playermove {
    tokenId;
    tokenPos;
    onField;

    constructor(tokenId, tokenPos, onField) {
        this.tokenId = tokenId;
        this.tokenPos = tokenPos;
        this.onField = onField;
    }

    static createPlayermove (tokenId,tokenPos,onField){
        return new playermove(tokenId,tokenPos,onField);
    }
}
