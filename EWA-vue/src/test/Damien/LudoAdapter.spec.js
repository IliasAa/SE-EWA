import {InMemoryService} from "@/adaptors/InMemoryService";
import {playermove} from "@/models/playermove";

describe('LudoAdapter', () => {
    let service

    beforeEach(function () {
        service = new InMemoryService(0, playermove.createSample)
    });


    it('findAll returns all', function () {
        let playermove = service.findAll();
        expect(playermove,
            'playermove.findAll does not return all playermoves')
            .toStrictEqual(service.entities);
    })


    it('findById returns the specified playermove', function () {
        const playermove = service.entities[0];

        expect(service.findById(playermove.id),
            // eslint-disable-next-line jest/valid-expect
            `playermove.findById cannot find Playermove-${playermove.id})`
        ).toStrictEqual(playermove)

    })

});