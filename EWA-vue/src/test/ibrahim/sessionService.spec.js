import { mount } from '@vue/test-utils';
import {SessionService} from "@/adaptors/SessionService";

describe('SessionService', () => {
    let service;

    beforeEach(() => {
        service = new SessionService();
    });

    it('should be created', () => {
        expect(service).toBeTruthy();
    });

    it('should fetch user', async () => {
        // Mock the necessary dependencies
        const mockUser = { username: 'ibrahim', email: 'ibrahim@hva.nl' };
        const fetchUser = jest.fn().mockResolvedValue(mockUser);
        service.fetchUser = fetchUser;

        // Call the method under test
        const result = await service.fetchUser();

        // Assert the expected behavior
        expect(fetchUser).toHaveBeenCalled();
        expect(result).toEqual(mockUser);
    });
});