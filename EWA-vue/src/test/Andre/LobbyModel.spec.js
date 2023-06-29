import { mount } from "@vue/test-utils";
import JoinLobby from "@/components/lobby/JoinGame.vue";
import { Lobby } from "@/models/Lobby";

let wrapper;

const lobbys = [
    new Lobby("qwf183", "Green", 0, 3, 3, 7),
    new Lobby("qwf183", "Green", 0, 2, 5, 4),
    new Lobby("qwf183", "Green", 0, 4, 7, 4),
    new Lobby("qwf183", "Green", 0, 8, 2, 3)
]

beforeAll(() => {
    wrapper = mount(JoinLobby, {
        props: {
            lobbys: lobbys
        }
    });
});
describe("JoinLobby", function () {

    it("renders the correct number of lobby items", () => {
        const lobbyItems = wrapper.findAll(".lobby-item");
        expect(lobbyItems.length).toBe(lobbys.length);
    });

    it("displays the join code for each lobby", () => {
        const joinCodes = wrapper.findAll(".join-code");
        lobbys.forEach((lobby, index) => {
            expect(joinCodes[index].text()).toBe(lobby.join_code);
        });
    });

});

