package com.dendiz.chesslib;

/**
 * Created by dendiz on 25/07/15.
 */
public class Move {
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
}
