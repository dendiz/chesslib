package com.dendiz.chesslib;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by dendiz on 26/07/15.
 */
public class LibTest {

    ChessLib chessLib;

    @Before
    public void before() {
        chessLib = new ChessLib();
    }

    @Test
    public void testStartPosition() {
        chessLib.reset();
        char[] pi = new char[]{'r', 'n', 'b', 'q', 'k','b','n','r'};
        for(char i='a';i<='h';i++) {
            assertEquals("b", chessLib.board[chessLib.SQUARES.get(i+"8")].color);
            assertEquals(pi[i-'a']+"", chessLib.board[chessLib.SQUARES.get(i+"8")].ptype);
        }

        for(char i='a';i<='h';i++) {
            assertEquals("b", chessLib.board[chessLib.SQUARES.get(i+"7")].color);
            assertEquals("p", chessLib.board[chessLib.SQUARES.get(i+"7")].ptype);
        }

        for(char i='a';i<='h';i++) {
            assertEquals("w", chessLib.board[chessLib.SQUARES.get(i+"1")].color);
            assertEquals(pi[i-'a']+"", chessLib.board[chessLib.SQUARES.get(i+"1")].ptype);
        }

        for(char i='a';i<='h';i++) {
            assertEquals("w", chessLib.board[chessLib.SQUARES.get(i+"2")].color);
            assertEquals("p", chessLib.board[chessLib.SQUARES.get(i+"2")].ptype);
        }
    }

    @Test
    public void test1() {
        chessLib.reset();
        Move e4 = chessLib.move("e4");
        assertEquals("p" ,e4.piece);
        assertEquals("e4" ,e4.san);

    }
}
