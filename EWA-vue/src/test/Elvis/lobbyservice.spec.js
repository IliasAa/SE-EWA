import {InMemoryService} from "@/adaptors/InMemoryService";
import {lobby} from "../../models/Lobby";



describe('LobbyServiceTest', () => {
    let service

    beforeEach(function() {
        service = new InMemoryService(0, lobby.createSample() )
    });



    it('findAll returns all', function() {
        let user = service.findAll();
        expect(user,
            'lobby.findAll does not return all users')
            .toStrictEqual(service.entities);
    })
});

