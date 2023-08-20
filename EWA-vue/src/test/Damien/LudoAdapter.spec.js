import {InMemoryService} from "@/adaptors/InMemoryService";
import {playermove} from "@/models/playermove";

let service

beforeEach(function() {
    service = new InMemoryService(0, playermove.createSample)
});



it('findAll returns all', function() {
    let user = service.findAll();
    expect(user,
        'playermove.findAll does not return all users')
        .toStrictEqual(service.entities);
})


it('findById returns the specified playermove', function() {
    const playermove = service.entities[0];

    expect(service.findById(playermove.id),
        // eslint-disable-next-line jest/valid-expect
        `playermove.findById cannot find user-${playermove.id})`
    ).toStrictEqual(playermove)

})