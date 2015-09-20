package com.dendiz.chesslib;

import java.io.Serializable;

/**
 * Created by dendiz on 25/07/15.
 */
public class Piece implements Serializable {
    public String ptype;
    public String color;

    public Piece(String ptype, String color) {
        this.ptype = ptype;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "ptype='" + ptype + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
