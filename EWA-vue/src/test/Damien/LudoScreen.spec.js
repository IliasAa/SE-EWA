import {mount} from "@vue/test-utils";
import Ludoscreen from "../../components/Ludoscreen.vue";
import {pawn} from "@/models/pawn";

// manages an App component instance in the testbed
let wrapper;

beforeEach(function() {
    wrapper = mount(Ludoscreen);
});

it('Checks if playable pawns exists.', function() {
    expect(wrapper.vm.$data.playablePawns).toBeDefined()
})

it('Check if playablepawns is part of pawns model', function () {
    const playablePawns = wrapper.vm.$data.playablePawns;
    expect(Array.isArray(playablePawns)).toBe(true);
    playablePawns.forEach((pawn) => {
        expect(typeof pawn).toBe('object')
    });
});
