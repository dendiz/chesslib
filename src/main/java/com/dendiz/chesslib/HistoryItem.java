package com.dendiz.chesslib;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by dendiz on 25/07/15.
 */
public class HistoryItem implements Serializable {
    public Move move;
    public Map<String, Integer> kings;
    public String turn;
    public Map<String, Integer> castling;
    public int ep_square;
    public int half_moves;
    public int move_number;

    public HistoryItem(Move move, Map<String, Integer> kings, String turn, Map<String, Integer> castling, int ep_square, int half_moves, int move_number) {
        this.move = move;
        this.kings = kings;
        this.turn = turn;
        this.castling = castling;
        this.ep_square = ep_square;
        this.half_moves = half_moves;
        this.move_number = move_number;
    }
}
