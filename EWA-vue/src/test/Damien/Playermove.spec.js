import {Playermove} from "@/models/playermove";

const tokenid = 10;
const tokepos = 1;
const onfield = 2;

let pmove

beforeEach(function (){
    pmove = Playermove.createPlayermove(tokenid,tokepos,onfield)
})
describe ('Create playermove', function (){
    it ('Check if the playermove is made correctly', function (){
        expect(pmove.tokenId).toBe(tokenid)
        expect(pmove.tokenPos).toBe(tokepos)
        expect(pmove.onField).toBe(onfield)
    })
})