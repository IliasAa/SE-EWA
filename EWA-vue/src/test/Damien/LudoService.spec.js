import {LudoAdaptor} from "@/adaptors/LudoAdaptor";


describe('LudoService', () => {
    let service;

    beforeEach(() => {
        service = new LudoAdaptor();
    });

    it('should be created', () => {
        //Only shows if the test has any of the truthy values.
        expect(service).toBeTruthy();
    });

    it('should fetch playermove', async () => {
        const mockPlayerPos = { tokenId: '101', tokenPos: '51', onField: '2' };
        const fetchPlayerPos = jest.fn().mockResolvedValue(mockPlayerPos);
        service.fetchPlayerPos = fetchPlayerPos;
        const result = await service.fetchPlayerPos();
        expect(fetchPlayerPos).toHaveBeenCalled();
        expect(result).toEqual(mockPlayerPos);
    });
});