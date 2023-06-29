import { mount } from "@vue/test-utils";
import JoinGame from "@/components/lobby/JoinGame.vue";

let wrapper;

const lobby = { join_code: "qwe123", selected_color: "Red", isPrivateLobby: 0, players_size: 2, max_allowed_Players: 3, userId_owne: 3};

// const lobbys = [
//     new Lobby("qwe123", "Red", 0, 2, 3, 3),
//     new Lobby("qwf183", "Green", 0, 3, 3, 7),
//     new Lobby("qse143", "Blue", 0, 4, 4, 5),
//     new Lobby("qbe103", "Red", 1, 2, 3, 1)
// ];

beforeAll(() => {
    wrapper = mount(JoinGame, {
        props: {
            lobbys: lobby
        }
    });
});

describe("JoinLobby", () => {
    it('toggles showPopup1 when "Join a lobby using a code" button is clicked', async () => {
        const wrapper = mount(JoinLobby);
        const button = wrapper.find('.btn-lg');
        await button.trigger('click');
        expect(wrapper.vm.showPopup1).toBe(true);
    });
});
