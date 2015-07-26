package com.dendiz.chesslib;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
    public void testFen1() {
        chessLib.load("2r2rk1/p5pp/1p2pp2/b2p4/2qPn3/PRPNP3/2Q2PPP/2R1B1K1 b - - 5 6");
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("a8")]);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("b8")]);
        assertEquals("b", chessLib.board[chessLib.SQUARES.get("c8")].color);
        assertEquals("r", chessLib.board[chessLib.SQUARES.get("c8")].ptype);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("d8")]);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("e8")]);
        assertEquals("b", chessLib.board[chessLib.SQUARES.get("f8")].color);
        assertEquals("r", chessLib.board[chessLib.SQUARES.get("f8")].ptype);
        assertEquals("b", chessLib.board[chessLib.SQUARES.get("g8")].color);
        assertEquals("k", chessLib.board[chessLib.SQUARES.get("g8")].ptype);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("h8")]);

        assertEquals("b", chessLib.board[chessLib.SQUARES.get("a7")].color);
        assertEquals("p", chessLib.board[chessLib.SQUARES.get("a7")].ptype);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("b7")]);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("c7")]);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("d7")]);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("e7")]);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("f7")]);
        assertEquals("b", chessLib.board[chessLib.SQUARES.get("g7")].color);
        assertEquals("p", chessLib.board[chessLib.SQUARES.get("g7")].ptype);
        assertEquals("b", chessLib.board[chessLib.SQUARES.get("h7")].color);
        assertEquals("p", chessLib.board[chessLib.SQUARES.get("h7")].ptype);

        assertEquals(null, chessLib.board[chessLib.SQUARES.get("a6")]);
        assertEquals("b", chessLib.board[chessLib.SQUARES.get("b6")].color);
        assertEquals("p", chessLib.board[chessLib.SQUARES.get("b6")].ptype);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("c6")]);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("d6")]);
        assertEquals("b", chessLib.board[chessLib.SQUARES.get("e6")].color);
        assertEquals("p", chessLib.board[chessLib.SQUARES.get("e6")].ptype);
        assertEquals("b", chessLib.board[chessLib.SQUARES.get("f6")].color);
        assertEquals("p", chessLib.board[chessLib.SQUARES.get("f6")].ptype);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("g6")]);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("h6")]);

        assertEquals("b", chessLib.board[chessLib.SQUARES.get("a5")].color);
        assertEquals("b", chessLib.board[chessLib.SQUARES.get("a5")].ptype);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("b5")]);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("c5")]);
        assertEquals("b", chessLib.board[chessLib.SQUARES.get("d5")].color);
        assertEquals("p", chessLib.board[chessLib.SQUARES.get("d5")].ptype);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("e5")]);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("f5")]);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("g5")]);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("h5")]);

        assertEquals(null, chessLib.board[chessLib.SQUARES.get("a4")]);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("b4")]);
        assertEquals("b", chessLib.board[chessLib.SQUARES.get("c4")].color);
        assertEquals("q", chessLib.board[chessLib.SQUARES.get("c4")].ptype);
        assertEquals("w", chessLib.board[chessLib.SQUARES.get("d4")].color);
        assertEquals("p", chessLib.board[chessLib.SQUARES.get("d4")].ptype);
        assertEquals("b", chessLib.board[chessLib.SQUARES.get("e4")].color);
        assertEquals("n", chessLib.board[chessLib.SQUARES.get("e4")].ptype);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("f4")]);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("g4")]);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("h4")]);


        assertEquals("w", chessLib.board[chessLib.SQUARES.get("a3")].color);
        assertEquals("p", chessLib.board[chessLib.SQUARES.get("a3")].ptype);
        assertEquals("w", chessLib.board[chessLib.SQUARES.get("b3")].color);
        assertEquals("r", chessLib.board[chessLib.SQUARES.get("b3")].ptype);
        assertEquals("w", chessLib.board[chessLib.SQUARES.get("c3")].color);
        assertEquals("p", chessLib.board[chessLib.SQUARES.get("c3")].ptype);
        assertEquals("w", chessLib.board[chessLib.SQUARES.get("d3")].color);
        assertEquals("n", chessLib.board[chessLib.SQUARES.get("d3")].ptype);
        assertEquals("w", chessLib.board[chessLib.SQUARES.get("e3")].color);
        assertEquals("p", chessLib.board[chessLib.SQUARES.get("e3")].ptype);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("f3")]);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("g3")]);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("h3")]);

        assertEquals(null, chessLib.board[chessLib.SQUARES.get("a2")]);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("b2")]);
        assertEquals("w", chessLib.board[chessLib.SQUARES.get("c2")].color);
        assertEquals("q", chessLib.board[chessLib.SQUARES.get("c2")].ptype);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("d2")]);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("e2")]);
        assertEquals("w", chessLib.board[chessLib.SQUARES.get("f2")].color);
        assertEquals("p", chessLib.board[chessLib.SQUARES.get("f2")].ptype);
        assertEquals("w", chessLib.board[chessLib.SQUARES.get("g2")].color);
        assertEquals("p", chessLib.board[chessLib.SQUARES.get("g2")].ptype);
        assertEquals("w", chessLib.board[chessLib.SQUARES.get("h2")].color);
        assertEquals("p", chessLib.board[chessLib.SQUARES.get("h2")].ptype);

        assertEquals(null, chessLib.board[chessLib.SQUARES.get("a1")]);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("b1")]);
        assertEquals("w", chessLib.board[chessLib.SQUARES.get("c1")].color);
        assertEquals("r", chessLib.board[chessLib.SQUARES.get("c1")].ptype);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("d1")]);
        assertEquals("w", chessLib.board[chessLib.SQUARES.get("e1")].color);
        assertEquals("b", chessLib.board[chessLib.SQUARES.get("e1")].ptype);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("f1")]);
        assertEquals("w", chessLib.board[chessLib.SQUARES.get("g1")].color);
        assertEquals("k", chessLib.board[chessLib.SQUARES.get("g1")].ptype);
        assertEquals(null, chessLib.board[chessLib.SQUARES.get("h1")]);
    }

    @Test
    public void testFirstTurn() {
        chessLib.reset();
        assertEquals("w", chessLib.turn());
    }

    @Test
    public void testBeginningMoveGeneration() {
        chessLib.reset();
        List<Move> moves = chessLib.moves();
        assertEquals(20, moves.size());
    }

    @Test
    public void testCheckMate() {
        chessLib.load("2rq1rk1/pp3ppQ/4p3/b2p2N1/3P4/P1P1P3/3B1PPP/R4RK1 b - - 1 1");
        assertTrue(chessLib.in_checkmate());
        assertTrue(chessLib.in_check());
    }

    @Test
    public void testStaleMate() {
        chessLib.load("7k/5K2/6Q1/8/8/8/8/8 b - - 0 1");
        assertTrue(chessLib.in_stalemate());
        assertTrue(chessLib.in_draw());
    }
    @Test
    public void test1() {
        chessLib.reset();
        Move e4 = chessLib.move("e4");
        assertEquals("p" ,e4.piece);
        assertEquals("e4" ,e4.san);
        assertEquals("w" ,e4.color);

    }
}
