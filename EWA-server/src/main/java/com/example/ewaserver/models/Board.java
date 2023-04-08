package com.example.ewaserver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Board")
public class Board {
    @Id
    private int board_id;
    private int token_id;
    private int user_id;
    private int position;

    public Board(int board_id, int token_id, int user_id, int position) {
        this.board_id = board_id;
        this.token_id = token_id;
        this.user_id = user_id;
        this.position = position;
    }


    public Board() {

    }
}
