package com.dendiz.chesslib;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

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
        char[] pi = new char[]{'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'};
        for (char i = 'a'; i <= 'h'; i++) {
            assertEquals("b", chessLib.board[chessLib.SQUARES.get(i + "8")].color);
            assertEquals(pi[i - 'a'] + "", chessLib.board[chessLib.SQUARES.get(i + "8")].ptype);
        }

        for (char i = 'a'; i <= 'h'; i++) {
            assertEquals("b", chessLib.board[chessLib.SQUARES.get(i + "7")].color);
            assertEquals("p", chessLib.board[chessLib.SQUARES.get(i + "7")].ptype);
        }

        for (char i = 'a'; i <= 'h'; i++) {
            assertEquals("w", chessLib.board[chessLib.SQUARES.get(i + "1")].color);
            assertEquals(pi[i - 'a'] + "", chessLib.board[chessLib.SQUARES.get(i + "1")].ptype);
        }

        for (char i = 'a'; i <= 'h'; i++) {
            assertEquals("w", chessLib.board[chessLib.SQUARES.get(i + "2")].color);
            assertEquals("p", chessLib.board[chessLib.SQUARES.get(i + "2")].ptype);
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
    public void testfen2() {
        chessLib.load("7k/5K2/6Q1/8/8/8/8/8 b - - 0 1");
        assertEquals("w", chessLib.board[chessLib.SQUARES.get("f7")].color);
        assertEquals("k", chessLib.board[chessLib.SQUARES.get("f7")].ptype);

        assertEquals("b", chessLib.board[chessLib.SQUARES.get("h8")].color);
        assertEquals("k", chessLib.board[chessLib.SQUARES.get("h8")].ptype);

        assertEquals("w", chessLib.board[chessLib.SQUARES.get("g6")].color);
        assertEquals("q", chessLib.board[chessLib.SQUARES.get("g6")].ptype);

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
        chessLib.load("8/5r2/4K1q1/4p3/3k4/8/8/8 w - - 0 7");
        assertTrue(chessLib.in_checkmate());
        assertTrue(chessLib.in_check());
        chessLib.load("4r2r/p6p/1pnN2p1/kQp5/3pPq2/3P4/PPP3PP/R5K1 b - - 0 2");
        assertTrue(chessLib.in_checkmate());
        assertTrue(chessLib.in_check());
        chessLib.load("r3k2r/ppp2p1p/2n1p1p1/8/2B2P1q/2NPb1n1/PP4PP/R2Q3K w kq - 0 8");
        assertTrue(chessLib.in_checkmate());
        assertTrue(chessLib.in_check());
        chessLib.load("8/6R1/pp1r3p/6p1/P3R1Pk/1P4P1/7K/8 b - - 0 4");
        assertTrue(chessLib.in_checkmate());
        assertTrue(chessLib.in_check());


    }


    @Test
    public void testStaleMate() {
        chessLib.load("7k/5K2/6Q1/8/8/8/8/8 b - - 0 1");
        assertTrue(chessLib.in_stalemate());
        assertTrue(chessLib.in_draw());
        chessLib.load("1R6/8/8/8/8/8/7R/k6K b - - 0 1");
        assertTrue(chessLib.in_stalemate());
        assertTrue(chessLib.in_draw());
        chessLib.load("8/8/5k2/p4p1p/P4K1P/1r6/8/8 w - - 0 2");
        assertTrue(chessLib.in_stalemate());
        assertTrue(chessLib.in_draw());
    }

    @Test
    public void testInsuffMaterial() {

        List<String> posDraw = Arrays.asList(
                "8/8/8/8/8/8/8/k6K w - - 0 1",
                "8/2N5/8/8/8/8/8/k6K w - - 0 1",
                "8/2b5/8/8/8/8/8/k6K w - - 0 1",
                "8/b7/3B4/8/8/8/8/k6K w - - 0 1",
                "8/b1B1b1B1/1b1B1b1B/8/8/8/8/1k5K w - - 0 1"
        );

        posDraw.forEach((p) -> {
            System.out.print("position: " + p);
            chessLib.load(p);
            assertTrue(chessLib.insufficient_material());
            assertTrue(chessLib.in_draw());
        });

        List<String> posNotDraw = Arrays.asList(
                "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1",
                "8/2p5/8/8/8/8/8/k6K w - - 0 1",
                "8/bB2b1B1/1b1B1b1B/8/8/8/8/1k5K w - - 0 1",
                "8/b7/B7/8/8/8/8/k6K w - - 0 1"
        );
        posNotDraw.forEach((p) -> {
            System.out.print("position: " + p);
            chessLib.load(p);
            assertFalse(chessLib.insufficient_material());
            assertFalse(chessLib.in_draw());
        });


    }

    @Test
    public void test3FoldRep() {
        HashMap<String, List<String>> positions = new HashMap<>();
        positions.put("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1", Arrays.asList("Nf3", "Nf6", "Ng1", "Ng8", "Nf3", "Nf6", "Ng1", "Ng8"));
        positions.put("8/pp3p1k/2p2q1p/3r1P2/5R2/7P/P1P1QP2/7K b - - 2 30", Arrays.asList("Qe5", "Qh5", "Qf6", "Qe2", "Re5", "Qd3", "Rd5", "Qe2"));

        for (String position : positions.keySet()) {
            chessLib.load(position);
            boolean passed = true;
            List<String> moves = positions.get(position);
            for (String move : moves) {
                if (chessLib.in_threefold_repetition()) {
                    passed = false;
                    break;
                }
                chessLib.move(move);
            }
            assertTrue(passed && chessLib.in_threefold_repetition() && chessLib.in_draw());
        }
    }

    @Test
    public void testMoves() {
        HashMap<String, List<String>> positions = new HashMap<>();
        positions.put("7k/3R4/3p2Q1/6Q1/2N1N3/8/8/3R3K w - - 0 1", Arrays.asList("Rd8#", "Re7", "Rf7", "Rg7", "Rh7#", "R7xd6", "Rc7", "Rb7", "Ra7",
                "Qf7", "Qe8#", "Qg7#", "Qg8#", "Qh7#", "Q6h6#", "Q6h5#", "Q6f5",
                "Q6f6#", "Qe6", "Qxd6", "Q5f6#", "Qe7", "Qd8#", "Q5h6#", "Q5h5#",
                "Qh4#", "Qg4", "Qg3", "Qg2", "Qg1", "Qf4", "Qe3", "Qd2", "Qc1",
                "Q5f5", "Qe5+", "Qd5", "Qc5", "Qb5", "Qa5", "Na5", "Nb6", "Ncxd6",
                "Ne5", "Ne3", "Ncd2", "Nb2", "Na3", "Nc5", "Nexd6", "Nf6", "Ng3",
                "Nf2", "Ned2", "Nc3", "Rd2", "Rd3", "Rd4", "Rd5", "R1xd6", "Re1",
                "Rf1", "Rg1", "Rc1", "Rb1", "Ra1", "Kg2", "Kh2", "Kg1"));

        positions.put("1r3k2/P1P5/8/8/8/8/8/R3K2R w KQ - 0 1",Arrays.asList("a8=Q", "a8=R", "a8=B", "a8=N", "axb8=Q+", "axb8=R+", "axb8=B",
                "axb8=N", "c8=Q+", "c8=R+", "c8=B", "c8=N", "cxb8=Q+", "cxb8=R+",
                "cxb8=B", "cxb8=N", "Ra2", "Ra3", "Ra4", "Ra5", "Ra6", "Rb1",
                "Rc1", "Rd1", "Kd2", "Ke2", "Kf2", "Kf1", "Kd1", "Rh2", "Rh3",
                "Rh4", "Rh5", "Rh6", "Rh7", "Rh8+", "Rg1", "Rf1+", "O-O+",
                "O-O-O"));

        positions.put("5rk1/8/8/8/8/8/2p5/R3K2R w KQ - 0 1",Arrays.asList("Ra2", "Ra3", "Ra4", "Ra5", "Ra6", "Ra7", "Ra8", "Rb1", "Rc1",
                "Rd1", "Kd2", "Ke2", "Rh2", "Rh3", "Rh4", "Rh5", "Rh6", "Rh7",
                "Rh8+", "Rg1+", "Rf1"));



        positions.put("r3k2r/p2pqpb1/1n2pnp1/2pPN3/1p2P3/2N2Q1p/PPPB1PPP/R3K2R w KQkq c6 0 2",Arrays.asList("gxh3", "Qxf6", "Qxh3", "Nxd7", "Nxf7", "Nxg6", "dxc6", "dxe6",
                "Rg1", "Rf1", "Ke2", "Kf1", "Kd1", "Rb1", "Rc1", "Rd1", "g3",
                "g4", "Be3", "Bf4", "Bg5", "Bh6", "Bc1", "b3", "a3", "a4", "Qf4",
                "Qf5", "Qg4", "Qh5", "Qg3", "Qe2", "Qd1", "Qe3", "Qd3", "Na4",
                "Nb5", "Ne2", "Nd1", "Nb1", "Nc6", "Ng4", "Nd3", "Nc4", "d6",
                "O-O", "O-O-O"));

        positions.put("k7/8/K7/8/3n3n/5R2/3n4/8 b - - 0 1",Arrays.asList("N2xf3", "Nhxf3", "Nd4xf3", "N2b3", "Nc4", "Ne4", "Nf1", "Nb1",
                "Nhf5", "Ng6", "Ng2", "Nb5", "Nc6", "Ne6", "Ndf5", "Ne2", "Nc2",
                "N4b3", "Kb8"));

        positions.put("5rk1/8/8/8/8/8/2p5/R3K2R b KQ - 0 1", Arrays.asList("Rf7", "Rf6", "Rf5", "Rf4", "Rf3", "Rf2", "Rf1+", "Re8+", "Rd8",
                "Rc8", "Rb8", "Ra8", "Kg7", "Kf7", "c1=Q+", "c1=R+", "c1=B",
                "c1=N"));

        for (String position : positions.keySet()) {
            chessLib.load(position);

            List<Move> moves = chessLib.moves();
            assertEquals(positions.get(position).size(), positions.get(position).size());
            for (Move move : moves) {
                assertTrue(positions.get(position).contains(move.san));
            }

        }
    }

    @Test
    public void testGetPut() {
        HashMap<String, Piece> pieces = new HashMap<>();
        pieces.put("a7", new Piece(ChessLib.PAWN, ChessLib.WHITE));
        pieces.put("b7", new Piece(ChessLib.PAWN, ChessLib.BLACK));
        pieces.put("c7", new Piece(ChessLib.KNIGHT, ChessLib.BLACK));
        pieces.put("d7", new Piece(ChessLib.KNIGHT, ChessLib.BLACK));
        pieces.put("e7", new Piece(ChessLib.BISHOP, ChessLib.BLACK));
        pieces.put("f7", new Piece(ChessLib.BISHOP, ChessLib.BLACK));
        pieces.put("g7", new Piece(ChessLib.ROOK, ChessLib.BLACK));
        pieces.put("h7", new Piece(ChessLib.ROOK, ChessLib.BLACK));
        pieces.put("a6", new Piece(ChessLib.QUEEN, ChessLib.BLACK));
        pieces.put("b6", new Piece(ChessLib.QUEEN, ChessLib.BLACK));
        pieces.put("a4", new Piece(ChessLib.KING, ChessLib.BLACK));
        pieces.put("h4", new Piece(ChessLib.KING, ChessLib.BLACK));


        chessLib.clear();
        for (String sq : pieces.keySet()) {
            assertTrue(chessLib.put(pieces.get(sq), sq));
        }

        for (String sq : ChessLib.SQUARES.keySet()) {
            if (pieces.containsKey(sq)) {
                Piece piece = chessLib.get(sq);
                assertEquals(pieces.get(sq).color, piece.color);
                assertEquals(pieces.get(sq).ptype, piece.ptype);
            }
        }

        for (String sq : ChessLib.SQUARES.keySet()) {
            if (pieces.containsKey(sq)) {
                Piece piece = chessLib.remove(sq);
                assertEquals(pieces.get(sq).color, piece.color);
                assertEquals(pieces.get(sq).ptype, piece.ptype);
                assertNull(chessLib.get(sq));
            }
        }

        assertEquals("8/8/8/8/8/8/8/8 w - - 0 1", chessLib.fen());

    }

    @Test
    public void testPutBadPiece() {
        chessLib.clear();
        assertFalse(chessLib.put(new Piece("z", ChessLib.WHITE), "a7"));

        assertFalse(chessLib.put(new Piece("p", ChessLib.WHITE), "x7"));
    }

    @Test
    public void testPutTwoBlackKings() {
        chessLib.clear();
        assertTrue(chessLib.put(new Piece(ChessLib.KING, ChessLib.BLACK), "a7"));
        assertFalse(chessLib.put(new Piece(ChessLib.KING, ChessLib.BLACK), "a8"));
    }
    @Test
    public void testPutTwoWhiteKings() {
        chessLib.clear();
        assertTrue(chessLib.put(new Piece(ChessLib.KING, ChessLib.WHITE), "a7"));
        assertFalse(chessLib.put(new Piece(ChessLib.KING, ChessLib.WHITE), "a8"));
    }

    @Test
    public void allowTwoKingsIfSameSq() {
        chessLib.clear();
        assertTrue(chessLib.put(new Piece(ChessLib.KING, ChessLib.BLACK), "a8"));
        assertTrue(chessLib.put(new Piece(ChessLib.KING, ChessLib.BLACK), "a8"));

        assertTrue(chessLib.put(new Piece(ChessLib.KING, ChessLib.WHITE), "a7"));
        assertTrue(chessLib.put(new Piece(ChessLib.KING, ChessLib.WHITE), "a7"));

    }

    @Test
    public void testFens() {
        List<String> pos = Arrays.asList("8/8/8/8/8/8/8/8 w - - 0 1",
                "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1",
                "rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR b KQkq e3 0 1",
                "1nbqkbn1/pppp1ppp/8/4p3/4P3/8/PPPP1PPP/1NBQKBN1 b - - 1 2"
        );
        for (String po : pos) {
            chessLib.load(po);
            assertEquals(po, chessLib.fen());
        }
    }

    @Test
    public void testfensBad() {
        List<String> pos = Arrays.asList("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBN w KQkq - 0 1",
                "rnbqkbnr/pppppppp/9/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1",
                "1nbqkbn1/pppp1ppX/8/4p3/4P3/8/PPPP1PPP/1NBQKBN1 b - - 1 2"
        );
        for (String po : pos) {
            chessLib.load(po);
            assertEquals("8/8/8/8/8/8/8/8 w - - 0 1", chessLib.fen());
        }
    }


    @Test
    public void test1() {
        chessLib.reset();
        Move e4 = chessLib.move("e4");
        assertEquals("p", e4.piece);
        assertEquals("e4", e4.san);
        assertEquals("w", e4.color);

    }
}
