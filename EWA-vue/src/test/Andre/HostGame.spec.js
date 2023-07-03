import { shallowMount } from "@vue/test-utils";
import DashboardScreen from "../../components/lobby/HostGame.vue";

describe("DashboardScreen", () => {
    let wrapper;

    beforeEach(() => {
        wrapper = shallowMount(DashboardScreen);
    });


    it("should render the title 'Create a game'", () => {
        const title = wrapper.find(".title");
        expect(title.text()).toBe("Create a game");
    });


    it("should hide the offline game popup by default", () => {
        const offlineGamePopup = wrapper.findComponent({ name: "popup" });
        expect(offlineGamePopup.exists()).toBe(false);
    });

    it("should hide the online game popup by default", () => {
        const onlineGamePopup = wrapper.findComponent({ name: "popup" });
        expect(onlineGamePopup.exists()).toBe(false);
    });

    it("should initialize with showPopup1 and showPopup2 set to false", () => {
        expect(wrapper.vm.showPopup1).toBe(false);
        expect(wrapper.vm.showPopup2).toBe(false);
    });

    it("should toggle showPopup1 value when 'Host Offline Game' button is clicked", async () => {
        const offlineGameButton = wrapper.find(".btn:first-child");

        // Initially, showPopup1 is false
        expect(wrapper.vm.showPopup1).toBe(false);

        // Click the 'Host Offline Game' button
        await offlineGameButton.trigger("click");

        // showPopup1 should be true after clicking the button
        expect(wrapper.vm.showPopup1).toBe(true);

        // Click the 'Host Offline Game' button again
        await offlineGameButton.trigger("click");

        // showPopup1 should be false again after clicking the button again
        expect(wrapper.vm.showPopup1).toBe(false);
    });
});
