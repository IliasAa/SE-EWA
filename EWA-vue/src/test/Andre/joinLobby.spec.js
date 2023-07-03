import { mount } from "@vue/test-utils";
import JoinGame from "../../components/lobby/JoinGame.vue";




describe('JoinGame', () => {
    let wrapper;

    let lobby = {
        join_code: "qwe123",
        selected_color: "Red",
        isPrivateLobby: 0,
        players_size: 2,
        max_allowed_Players: 3,
        userId_owne: 3
    };

    beforeAll(() => {
        wrapper = mount(JoinGame, {
            props: {
                lobby: lobby,
            }
        });
    });

    it("renders the component", () => {
        expect(wrapper.exists()).toBe(true);
    });


    it("displays the games in the table", () => {
        const gameRows = wrapper.findAll("tbody tr");
        expect(gameRows.length).toBe(wrapper.vm.games.length);

        wrapper.vm.games.forEach((game, index) => {
            const row = gameRows[index];
            expect(row.text()).toContain(game.idLobby);
            expect(row.text()).toContain(game.creatorNames);
            expect(row.text()).toContain(`${game.player_size}/${game.max_allowed_Players}`);
        });
    });


    it("should set the selectedColor when colorChoosing method is called", () => {
        wrapper.vm.colorChoosing("red");
        expect(wrapper.vm.selectedColor).toBe("red");
    });


});
