package com.example.ewaserver.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@NamedQueries({
        @NamedQuery(name = "Find_Turns_based_of_lobbyId",
                query = "select p from Turn p where p.lobby = ?1 "),
        @NamedQuery(name = "Find_Turn_based_of_selectedColor_And_lobby",
                query = "select p from Turn p where p.SelectedColor = ?1 and p.lobby =?2"),
})

@Entity
@Getter
@Setter
@Table(name = "Turn")
public class Turn {
    @Id
    private String SelectedColor;

    @Id
    @ManyToOne
    private Lobby lobby;

    private int lastThrow;
    private int throwCount;
}
