package com.example.ewaserver.repositories;
//Damiën

import com.example.ewaserver.models.Lobby;
import com.example.ewaserver.models.Playerposition;
import org.aspectj.apache.bcel.Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

import javax.swing.text.html.parser.Entity;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = {Repository.class, Entity.class}))


public class LudoRepositoryTest {

    @Autowired
    private EntityRepository<Playerposition> repo;

    private List<Playerposition> playerpositionList;

    @Test
    public void repoSavepos() {
        Lobby lobby = new Lobby(1, "5025x", 0, 2, 4, 1, 1);
        Playerposition playerposition = new Playerposition(100, 1, 2, lobby);


        Playerposition savedPos = repo.Save(playerposition);

        assertTrue(this.playerpositionList.size() > 0);

        assertEquals(100, savedPos.getTokenId());
        assertEquals(1,savedPos.getTokenPos());
    }


}
