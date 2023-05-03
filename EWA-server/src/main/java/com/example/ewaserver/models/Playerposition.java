package com.example.ewaserver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Playerposition")
public class Playerposition {
    @Id
    @GeneratedValue
    private int idPlayerposition;
    private int pawnId;
    private int current_pos;
    private int last_pos;
    private int home_pos;

    private int game_idgame;

    public Playerposition(int idPlayerposition, int pawnId, int current_pos, int last_pos, int home_pos, int game_idgame) {
        this.idPlayerposition = idPlayerposition;
        this.pawnId = pawnId;
        this.current_pos = current_pos;
        this.last_pos = last_pos;
        this.home_pos = home_pos;
        this.game_idgame = game_idgame;
    }

    protected Playerposition() {

    }
}
