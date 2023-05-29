package com.example.ewaserver.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@NamedQueries({
        @NamedQuery(name = "Find_Playermoves_based_of_lobbyId",
                query = "select p from Playerposition p where p.lobby = ?1 "),
})
@Entity
@Getter
@Setter
@Table(name = "Playerposition")
public class Playerposition {
    @Id
    @GeneratedValue
    private int idPlayerposition;

    private int tokenId;
    private int tokenPos;


    @ManyToOne
    private Lobby lobby;

    protected Playerposition() {

    }
}
