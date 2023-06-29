import { mount } from "@vue/test-utils";
import JoinGame from "@/components/lobby/JoinGame.vue";




describe("JoinGame", () => {
    let wrapper;

    // const lobby = new Lobby{ join_code: "qwe123", selected_color: "Red", isPrivateLobby: 0, players_size: 2, max_allowed_Players: 3, userId_owne: 3};

    beforeAll(() => {
        wrapper = mount(JoinGame, {
            data() {
                return {
                    games: [
                        {
                            idLobby: 1,
                            creatorNames: "John",
                            player_size: 2,
                            max_allowed_Players: 4,
                            join_code: "qwe123",
                            showPopup2: false
                        },
                        // Add more game objects as needed
                    ],
                    join_code: "",
                    selectedColor: null,
                    redColorSelectionDisabled: false,
                    blueColorSelectionDisabled: false,
                    greenColorSelectionDisabled: false,
                    yellowColorSelectionDisabled: false,
                    showPopup1: false
                };
            }
        });
    });

    it("renders the component", () => {
        expect(wrapper.exists()).toBe(true);
    });

    it("shows the join code input field", () => {
        const joinCodeInput = wrapper.find('input[label="Lobby code"]');
        expect(joinCodeInput.exists()).toBe(true);
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

    it("toggles the color selection popup on button click", async () => {
        const joinButton = wrapper.find("button.btn-lg");
        joinButton.trigger("click");
        await wrapper.vm.$nextTick();
        expect(wrapper.vm.showPopup1).toBe(true);

        joinButton.trigger("click");
        await wrapper.vm.$nextTick();
        expect(wrapper.vm.showPopup1).toBe(false);
    });

    it("disables color buttons based on selected colors in the lobby", async () => {
        const game = wrapper.vm.games[0];

        // Simulate lobby with selected colors
        wrapper.setData({
            selectedColorsinLobby: ["red", "blue"],
            redColorSelectionDisabled: false,
            blueColorSelectionDisabled: false,
            greenColorSelectionDisabled: false,
            yellowColorSelectionDisabled: false,
            showPopup2: true
        });

        const redButton = wrapper.find("#red");
        const blueButton = wrapper.find("#blue");
        const greenButton = wrapper.find("#green");
        const yellowButton = wrapper.find("#yellow");

        expect(redButton.attributes("disabled")).toBeUndefined();
        expect(blueButton.attributes("disabled")).toBeUndefined();
        expect(greenButton.attributes("disabled")).toBeUndefined();
        expect(yellowButton.attributes("disabled")).toBeUndefined();

        await redButton.trigger("click");
        await wrapper.vm.$nextTick();

        expect(redButton.attributes("disabled")).toBe("disabled");
        expect(blueButton.attributes("disabled")).toBeUndefined();
        expect(greenButton.attributes("disabled")).toBeUndefined();
        expect(yellowButton.attributes("disabled")).toBeUndefined();

        await blueButton.trigger("click");
        await wrapper.vm.$nextTick();

        expect(redButton.attributes("disabled")).toBe("disabled");
        expect(blueButton.attributes("disabled")).toBe("disabled");
        expect(greenButton.attributes("disabled")).toBeUndefined();
        expect(yellowButton.attributes("disabled")).toBeUndefined();
    });

    // it("should set the selectedColor when colorChoosing method is called", () => {
    //     wrapper.vm.colorChoosing("red");
    //     expect(wrapper.vm.selectedColor).toBe("red");
    // });

    // it("should disable the selected color buttons when disableColors method is called", () => {
    //     // Set up initial data
    //     wrapper.setData({
    //         selectedColorsinLobby: ["red", "blue"],
    //         redColorSelectionDisabled: false,
    //         blueColorSelectionDisabled: false,
    //     });
    //
    //     // Call the disableColors method
    //     wrapper.vm.disableColors({ join_code: "qwe123" });
    //
    //     // Check if the corresponding color selection buttons are disabled
    //     expect(wrapper.vm.redColorSelectionDisabled).toBe(true);
    //     expect(wrapper.vm.blueColorSelectionDisabled).toBe(true);
    //     expect(wrapper.vm.yellowColorSelectionDisabled).toBe(false);
    //     expect(wrapper.vm.greenColorSelectionDisabled).toBe(false);
    // });

    // it("displays the join code", () => {
    //     const joinCodeElement = wrapper.find(".join-code");
    //     expect(joinCodeElement.text()).toBe("qwe123");
    // });


});
