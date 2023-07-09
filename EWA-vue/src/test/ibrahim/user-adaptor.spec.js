import {InMemoryService} from "@/adaptors/InMemoryService";
import {User} from "@/models/User";


let service

beforeEach(function() {
    service = new InMemoryService(0, User.createSample)
});



it('findAll returns all', function() {
    let user = service.findAll();
    expect(user,
        'usersService.findAll does not return all users')
        .toStrictEqual(service.entities);
})



it('findById returns the specified user', function() {
    const user1 = service.entities[0];

    expect(service.findById(user1.id),
        // eslint-disable-next-line jest/valid-expect
        `userService.findById cannot find user-${user1.id})`
    ).toStrictEqual(user1)

})