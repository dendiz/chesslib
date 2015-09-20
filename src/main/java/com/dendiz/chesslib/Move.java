package com.dendiz.chesslib;

import java.io.Serializable;

/**
 * Created by dendiz on 25/07/15.
 */
public class Move implements Serializable {
    public String color;
    public int from;
    public int to;
    public int flags;
    public String piece;
    public String promotion;
    public String captured;
    public String san;
    public String strTo;
    public String strFrom;
    public String strFlags;

    public Move(String color, int from, int to, int flags, String piece, String promotion, String captured) {
        this.color = color;
        this.from = from;
        this.to = to;
        this.flags = flags;
        this.piece = piece;
        this.promotion = promotion;
        this.captured = captured;
    }

    public static Move copy(Move move) {
        return new Move(move.color, move.from, move.to, move.flags, move.piece, move.promotion, move.captured);
    }

    @Override
    public String toString() {
        return "Move{" +
                "from=" + from +
                ", to=" + to +
                ", san='" + san + '\'' +
                '}';
    }
}
