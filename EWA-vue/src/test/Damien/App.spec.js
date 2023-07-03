import {mount} from "@vue/test-utils";
import HostGame from "@/components/lobby/HostGame.vue";


let wrapper;

beforeEach(async function () {
    wrapper = mount(HostGame)
});

it('Check if content exist', async function() {
    expect(wrapper.html()).toContain("Choose to host an offline or online game:");
})
