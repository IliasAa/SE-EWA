// manages an App component instance in the testbed
import {mount} from "@vue/test-utils";
import Dashboard from "@/components/Dashboard.vue";

let wrapper;

beforeEach(async function () {
    wrapper = mount(Dashboard)
});

it("Check if page has div with name buttons", function () {
    expect(wrapper.exists()).toBe(true)
    expect(wrapper.find('.card-buttons').exists()).toBe(true)
})