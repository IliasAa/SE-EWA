package RepoTests;

import com.example.ewaserver.models.User;
import com.example.ewaserver.repositories.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Repository;


import javax.swing.text.html.parser.Entity;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = { Repository.class, Entity.class }))
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Test
    public void testFindAllUsers() {
        // Arrange
        // Set up any necessary test data or dependencies

        // Act
        List<User> users = userRepository.findAll();

        // Assert
        assertEquals(2, users.size()); // Replace with your own assertions
    }


}
