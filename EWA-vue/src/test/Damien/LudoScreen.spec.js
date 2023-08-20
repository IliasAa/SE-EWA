import {mount} from "@vue/test-utils";
import ludoscreen from "@/components/Ludoscreen.vue";


// manages an App component instance in the testbed
let wrapper;

beforeEach(async function () {
    wrapper = mount(ludoscreen)
});

it('Checks if playable pawns exists.', function () {
    expect(wrapper.vm.$data.playablePawns).toBeDefined()
})

it('Check if playablepawns is part of pawns model', function () {
    const playablePawns = wrapper.vm.$data.playablePawns;
    expect(Array.isArray(playablePawns)).toBe(true);
    playablePawns.forEach((pawn) => {
        expect(typeof pawn).toBe('object')
    });
});

it('Check if throwdice exist', function () {
    expect(wrapper.exists()).toBe(true)
    expect(wrapper.find('#buttonForDice').exists()).toBe(true)
})
