import { mount } from "@vue/test-utils";
import friendsPage from "../../components/friendsPage.vue";
import {MemoryService} from "../../adaptors/MemoryService";
import {FakeUser} from "../../models/FakeUser";
import {reactive} from "vue";


let wrapper;

beforeEach(async function() {
    let userService = new MemoryService(10000, FakeUser.createSampleUser);

    wrapper = await mount(friendsPage, {
        global: {
            provide: {
                "chatFriend": reactive(userService),
            }
        }
    });
});

it('creates a proper main page structure', function() {
    expect(wrapper.element.children.length,
        `main page starting with ${wrapper.element.tagName} has no child elements`)
        .toBeGreaterThan(0);
})

