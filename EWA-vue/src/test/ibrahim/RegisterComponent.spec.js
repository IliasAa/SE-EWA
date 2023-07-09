import { mount } from '@vue/test-utils';
import RegisterScreen from "@/components/RegisterScreen.vue";


describe('Register', () => {


    it('should render the register form', () => {
        const wrapper = mount(RegisterScreen);

        // Assert that the register form elements are present
        expect(wrapper.find('.login-form').exists()).toBe(true);
        expect(wrapper.find('form').exists()).toBe(true);
        expect(wrapper.find('v-text-field[label="Username"]').exists()).toBe(true);
        expect(wrapper.find('v-text-field[label="Email address"]').exists()).toBe(true);
        expect(wrapper.find('v-text-field[label="firstname"]').exists()).toBe(true);
        expect(wrapper.find('v-text-field[label="lastname"]').exists()).toBe(true);
        expect(wrapper.find('v-text-field[label="Password"]').exists()).toBe(true);
        expect(wrapper.find('v-btn[type="submit"]').exists()).toBe(true);
        expect(wrapper.find('.register').exists()).toBe(true);
        expect(wrapper.find('router-link[to="/Loginpage"]').exists()).toBe(true);


    });
});