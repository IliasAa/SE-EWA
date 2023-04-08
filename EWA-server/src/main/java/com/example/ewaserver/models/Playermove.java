package com.example.ewaserver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Playermove")
public class Playermove {
    @Id
    private int token_id;
    @Id
    private int board_id;

    private int from_position;
    private int to_position;
    private int move_made;

    public Playermove(int token_id, int board_id, int from_position, int to_position, int move_made) {
        this.token_id = token_id;
        this.board_id = board_id;
        this.from_position = from_position;
        this.to_position = to_position;
        this.move_made = move_made;
    }

    public Playermove() {

    }
}
