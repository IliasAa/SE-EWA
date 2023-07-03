// import {mount} from "@vue/test-utils";
// import Ludoscreen from "../../components/Ludoscreen.vue";
// import {pawn} from "@/models/pawn";
// import {MemoryService} from "@/adaptors/MemoryService";
// import {FakeUser} from "@/models/FakeUser";
// import friendsPage from "@/components/friendsPage.vue";
// import {reactive} from "vue";
// import ludoscreen from "@/components/Ludoscreen.vue";
// import {Lobby} from "@/models/Lobby";
//
// // manages an App component instance in the testbed
// let wrapper;
//
// beforeEach(async function () {
//     const code = "XH2030";
//     const color = "green";
//     const isPrivate = 2;
//     const pSize = 3;
//     const maxAllowed = 4;
//     const userIdOwner = 1;
//     let newlobby;
//     newlobby = new Lobby(code,color,isPrivate,pSize,maxAllowed,userIdOwner);
//
//     let userService = new MemoryService(10000, FakeUser.createSampleUser);
//     let lobbyService = new MemoryService(10000, newlobby.createSampleUser);
//
//
//
//     wrapper = await mount(ludoscreen,{
//         global: {
//             provide: {
//                 "SessionService": reactive(userService),
//                 "lobbyService": reactive(lobbyService),
//             }
//         }
//     });
// });
//
// it('Checks if playable pawns exists.', function () {
//     expect(wrapper.vm.$data.playablePawns).toBeDefined()
// })
//
// it('Check if playablepawns is part of pawns model', function () {
//     const playablePawns = wrapper.vm.$data.playablePawns;
//     expect(Array.isArray(playablePawns)).toBe(true);
//     playablePawns.forEach((pawn) => {
//         expect(typeof pawn).toBe('object')
//     });
// });
//
// it('Check if throwdice exist', function () {
//     expect(wrapper.exists()).toBe(true)
//     expect(wrapper.find('#buttonForDice').exists()).toBe(true)
// })
