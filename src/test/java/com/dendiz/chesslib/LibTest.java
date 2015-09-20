package com.dendiz.chesslib;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

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
    public void perfTest() {
        //chessLib.load("rnbqkbnr/pppppppp/8/8/3P4/8/PPP1PPPP/RNBQKBNR b KQkq d3 0 1");
        long start = System.currentTimeMillis();
        Queue<String> queue = new ArrayDeque<String>();
        queue.add("rnbqkbnr/pppppppp/8/8/3P4/8/PPP1PPPP/RNBQKBNR b KQkq d3 0 1");
        List<String> result = new ArrayList<String>();
        int depth = 0;
        while(true) {
            int nodeCount = queue.size();
            if (nodeCount == 0) break;
            while(nodeCount > 0) {
                String fen = queue.poll();
                chessLib.load(fen);
                List<Move> moves = chessLib.moves();
                for (Move move : moves) {
                    chessLib.move(move);
                    String fen1 = chessLib.fen();
                    queue.add(fen1);
                    result.add(fen1);
                    chessLib.undo();
                }
                nodeCount--;
            }
            depth++;
            if (depth == 4) break;
        }
        long end = System.currentTimeMillis();
        System.out.println("generated " + result.size() + " positions");
        long res = end -start;
        System.out.println("time: " + res + " ms");

    }




    @Test
    public void testPos1() {
        chessLib.load("rnbqkbnr/pppppppp/8/8/3P4/8/PPP1PPPP/RNBQKBNR b KQkq d3 0 1");
        List<Move> moves = chessLib.moves();
        System.out.println(moves.size());
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
        pieces.put("d7", new Piece(ChessLib.KNIGHT, ChessLib.WHITE));
        pieces.put("e7", new Piece(ChessLib.BISHOP, ChessLib.BLACK));
        pieces.put("f7", new Piece(ChessLib.BISHOP, ChessLib.WHITE));
        pieces.put("g7", new Piece(ChessLib.ROOK, ChessLib.BLACK));
        pieces.put("h7", new Piece(ChessLib.ROOK, ChessLib.WHITE));
        pieces.put("a6", new Piece(ChessLib.QUEEN, ChessLib.BLACK));
        pieces.put("b6", new Piece(ChessLib.QUEEN, ChessLib.WHITE));
        pieces.put("a4", new Piece(ChessLib.KING, ChessLib.BLACK));
        pieces.put("h4", new Piece(ChessLib.KING, ChessLib.WHITE));


        chessLib.clear();
        for (String sq : pieces.keySet()) {
            System.out.println("sq :" + sq);
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
    public void testMakeMove() {
        chessLib.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        Move m2 = chessLib.move("e4");
        assertEquals("rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR b KQkq e3 0 1", chessLib.fen());

        assertEquals(m2.piece, "p");

        chessLib.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        assertNull(chessLib.move("e5"));

        chessLib.load("7k/3R4/3p2Q1/6Q1/2N1N3/8/8/3R3K w - - 0 1");
        chessLib.move("Rd8#");
        assertEquals("3R3k/8/3p2Q1/6Q1/2N1N3/8/8/3R3K b - - 1 1", chessLib.fen());

        chessLib.load("rnbqkbnr/pp3ppp/2pp4/4pP2/4P3/8/PPPP2PP/RNBQKBNR w KQkq e6 0 1");
        chessLib.move("fxe6");
        assertEquals("rnbqkbnr/pp3ppp/2ppP3/8/4P3/8/PPPP2PP/RNBQKBNR b KQkq - 0 1", chessLib.fen());

        chessLib.load("rnbqkbnr/pppp2pp/8/4p3/4Pp2/2PP4/PP3PPP/RNBQKBNR b KQkq e3 0 1");
        Move m = chessLib.move("fxe3");
        assertEquals("rnbqkbnr/pppp2pp/8/4p3/8/2PPp3/PP3PPP/RNBQKBNR w KQkq - 0 2", chessLib.fen());
        assertEquals("p", m.captured);

    }

    @Test
    public void validateFens() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNRw KQkq - 0 1",    1);
        map.put("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 x",   2);
        map.put("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 0",   2);
        map.put("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 -1",  2);
        map.put("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - x 1",   3);
        map.put("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - -1 1",  3);
        map.put("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq e2 0 1",  4);
        map.put("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq e7 0 1",  4);
        map.put("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq x 0 1",   4);
        map.put("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQxkq - 0 1",  5);
        map.put("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w kqKQ - 0 1",   5);
        map.put("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR ? KQkq - 0 1",   6);
        map.put("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP w KQkq - 0 1",            7);
        map.put("rnbqkbnr/pppppppp/17/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1",  8);
        map.put("rnbqk?nr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1",   9);
        map.put("rnbqkbnr/pppppppp/7/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1",   10);
        map.put("rnbqkbnr/p1p1p1p1p/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1",  10);
        map.put("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1",   0);
        map.put("rnbqkbnr/pppp1ppp/8/4p3/2P5/8/PP1PPPPP/RNBQKBNR w KQkq e6 0 2",  0);
        map.put("3r2k1/p1q2pp1/2nr1n1p/2p1p3/4P2B/P1P2Q1P/B4PP1/1R2R1K1 b - - 3 20",  0);
        map.put("r2q1rk1/3bbppp/p3pn2/1p1pB3/3P4/1QNBP3/PP3PPP/R4RK1 w - - 4 13",  0);
        map.put("rnbqk2r/ppp1bppp/4pn2/3p4/2PP4/2N2N2/PP2PPPP/R1BQKB1R w KQkq - 1 5",  0);
        map.put("1k1rr3/1p5p/p1Pp2q1/3nppp1/PB6/3P4/3Q1PPP/1R3RK1 b - - 0 28",  0);
        map.put("r3r1k1/3n1pp1/2q1p2p/2p5/p1p2P2/P3P2P/1PQ2BP1/1R2R1K1 w - - 0 27",  0);
        map.put("r3rbk1/1R3p1p/3Pq1p1/6B1/p6P/5Q2/5PP1/3R2K1 b - - 3 26",  0);
        map.put("r1bqkbnr/pppp1ppp/2n5/4p3/4P3/5N2/PPPP1PPP/RNBQKB1R w KQkq - 2 3",  0);
        map.put("r1bqkbnr/pppp1ppp/2n5/4p3/4P3/5N2/PPPP1PPP/RNBQKB1R w KQkq - 2 3",  0);
        map.put("r1bqkb1r/1ppp1ppp/p1n2n2/4p3/B3P3/5N2/PPPP1PPP/RNBQK2R w KQkq - 2 5",  0);
        map.put("r1b2rk1/4bppp/p1np4/q3p1P1/1p2P2P/4BP2/PPP1N1Q1/1K1R1B1R w - - 0 17",  0);
        map.put("r2q1rk1/ppp1bppp/2np1nb1/4p3/P1B1P1P1/3P1N1P/1PP2P2/RNBQR1K1 w - - 1 10",  0);
        map.put("r2qkb1r/pb1n1p2/4pP2/1ppP2B1/2p5/2N3P1/PP3P1P/R2QKB1R b KQkq - 0 13",  0);
        map.put("3k1b1r/p2n1p2/5P2/2pN4/P1p2B2/1p3qP1/1P2KP2/3R4 w - - 0 29",  0);
        map.put("rnbq1rk1/1pp1ppbp/p2p1np1/8/2PPP3/2N1BP2/PP2N1PP/R2QKB1R b KQ - 1 7",  0);
        map.put("rn1qkb1r/pb1p1ppp/1p2pn2/4P3/2Pp4/5NP1/PP1N1PBP/R1BQK2R b KQkq - 0 8",  0);
        map.put("rnbqkbnr/pp1p1ppp/4p3/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R w KQkq - 0 3",  0);
        map.put("r1bq1rk1/pp2ppbp/3p1np1/8/3pPP2/3B4/PPPPN1PP/R1BQ1RK1 w - - 4 10",  0);
        map.put("r1b3k1/5pbp/2N1p1p1/p6q/2p2P2/2P1B3/PPQ3PP/3R2K1 b - - 0 22",  0);
        map.put("rnbqkb1r/ppp1pppp/3p1n2/8/3PP3/8/PPP2PPP/RNBQKBNR w KQkq - 1 3",  0);
        map.put("r1bqkb1r/pppp1ppp/2n2n2/4p3/2PP4/2N2N2/PP2PPPP/R1BQKB1R b KQkq d3 0 4",  0);
        map.put("r1bqk2r/ppp1bppp/2n5/3p4/3Pn3/3B1N2/PPP2PPP/RNBQ1RK1 w kq - 4 8",  0);
        map.put("4kb1r/1p3pp1/p3p3/4P1BN/1n1p1PPP/PR6/1P4r1/1KR5 b k - 0 24",  0);
        map.put("r3kb1r/pbpp1ppp/1qp1n3/4P3/2P5/1N2Q3/PP1B1PPP/R3KB1R w KQkq - 7 13",  0);
        map.put("r1b1r1k1/p4p1p/2pb2p1/3pn3/N7/4BP2/PPP2KPP/3RRB2 b - - 3 18",  0);
        map.put("r1b2rk1/p2nqp1p/3P2p1/2p2p2/2B5/1PB3N1/P4PPP/R2Q2K1 b - - 0 18",  0);
        map.put("rnb1k2r/1p3ppp/p3Pn2/8/3N2P1/2q1B3/P1P1BP1P/R2Q1K1R b kq - 1 12",  0);
        map.put("rnb1k2r/1pq1bppp/p2ppn2/8/3NPP2/2N1B3/PPP1B1PP/R2QK2R w KQkq - 1 9",  0);
        map.put("rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR b KQkq e3 0 1",  0);
        map.put("4r3/1pr3pk/p2p2q1/3Pppbp/8/1NPQ1PP1/PP2R2P/1K1R4 w - - 8 28",  0);
        map.put("b2r3r/4kp2/p3p1p1/1p2P3/1P1n1P2/P1NB4/KP4P1/3R2R1 b - - 2 26",  0);
        map.put("rnbqk2r/ppppppbp/5np1/8/2PPP3/2N5/PP3PPP/R1BQKBNR b KQkq e3 0 4",  0);
        map.put("rnbqkbnr/pp1ppppp/8/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R b KQkq - 1 2",  0);
        map.put("rn1q1rk1/pbp2pp1/1p3b1p/3p4/3P4/2NBPN2/PP3PPP/2RQK2R b K - 1 11",  0);
        map.put("2rq1rk1/pp1bppbp/3p1np1/8/2BNP3/2N1BP2/PPPQ2PP/1K1R3R b - - 0 13",  0);
        map.put("r2qkb1r/1p1bpppp/p1np4/6B1/B3P1n1/2PQ1N2/PP3PPP/RN2R1K1 b kq - 0 10",  0);
        map.put("r1bq1rk1/1p2npb1/p6p/3p2p1/3P3B/2N5/PP2BPPP/R2QR1K1 w - - 0 15",  0);
        map.put("r3r1k1/pbq1bppp/4pnn1/2p1B1N1/2P2P2/1P1B2N1/P3Q1PP/4RRK1 b - - 4 17",  0);
        map.put("4k3/5p2/p1q1pbp1/1pr1P3/3n1P2/1B2B2Q/PP3P2/3R3K w - - 1 28",  0);
        map.put("2k4r/pp1r1p1p/8/2Pq1p2/1Pn2P2/PQ3NP1/3p1NKP/R7 b - - 0 28",  0);
        map.put("rnbqkb1r/ppp2ppp/3p1n2/4N3/4P3/8/PPPP1PPP/RNBQKB1R w KQkq - 0 4",  0);
        map.put("3r1rk1/Qpp2p1p/7q/1P2P1p1/2B1Rn2/6NP/P4P1P/5RK1 b - - 0 22",  0);
        map.put("rn2kb1r/2qp1ppp/b3pn2/2pP2B1/1pN1P3/5P2/PP4PP/R2QKBNR w KQkq - 4 11",  0);
        map.put("r3k2r/pp1nbp1p/2p2pb1/3p4/3P3N/2N1P3/PP3PPP/R3KB1R w KQkq - 4 12",  0);
        map.put("rn1qr1k1/pbppbppp/1p3n2/3P4/8/P1N1P1P1/1P2NPBP/R1BQK2R b KQ - 2 10",  0);
        map.put("r1bqk2r/pp1nbppp/2p2n2/3p2B1/3P4/2N1PN2/PP3PPP/R2QKB1R w KQkq - 1 8",  0);
        map.put("r1bqk2r/pppp1pp1/2n2n1p/8/1bPN3B/2N5/PP2PPPP/R2QKB1R b KQkq - 1 7",  0);
        map.put("r1bqk2r/1pppbppp/p1n2n2/4p3/B3P3/5N2/PPPP1PPP/RNBQ1RK1 w kq - 4 6",  0);
        map.put("r1b1kb1r/p2p1ppp/1qp1p3/3nP3/2P1NP2/8/PP4PP/R1BQKB1R b KQkq c3 0 10",  0);
        map.put("8/R7/2b5/3k2K1/P1p1r3/2B5/1P6/8 b - - 8 74",  0);
        map.put("2q5/5pk1/5p1p/4b3/1p1pP3/7P/1Pr3P1/R2Q1RK1 w - - 14 37",  0);
        map.put("r4rk1/1bqnbppp/p2p4/1p2p3/3BPP2/P1NB4/1PP3PP/3RQR1K w - - 0 16",  0);
        map.put("r1bqk2r/pp1n1ppp/2pbpn2/6N1/3P4/3B1N2/PPP2PPP/R1BQK2R w KQkq - 2 8",  0);
        map.put("r1b1kb1r/pp3ppp/1qnppn2/8/2B1PB2/1NN5/PPP2PPP/R2QK2R b KQkq - 1 8",  0);
        map.put("1r3r1k/2q1n1pb/pn5p/1p2pP2/6B1/PPNRQ2P/2P1N1P1/3R3K b - - 0 28",  0);
        map.put("rnbqk2r/ppp1bppp/4pn2/3p2B1/2PP4/2N2N2/PP2PPPP/R2QKB1R b KQkq - 3 5",  0);
        map.put("2r3k1/5pp1/p2p3p/1p1Pp2P/5b2/8/qP1K2P1/3QRB1R w - - 0 26",  0);
        map.put("6k1/1Q3p2/2p1r3/B1Pn2p1/3P1b1p/5P1P/5P2/5K2 w - - 6 47",  0);
        map.put("8/k7/Pr2R3/7p/8/4n1P1/1r2p1P1/4R1K1 w - - 0 59",  0);
        map.put("8/3k4/1nbPp2p/1pK2np1/p7/PP1R1P2/2P4P/4R3 b - - 7 34",  0);
        map.put("4rbk1/rnR2p1p/pp2pnp1/3p4/3P4/1P2PB1P/P2BNPP1/R5K1 b - - 0 20",  0);
        map.put("5r2/6pk/8/p3P1p1/1R6/7Q/1Pr2P1K/2q5 b - - 2 48",  0);
        map.put("1br2rk1/2q2pp1/p3bnp1/1p1p4/8/1PN1PBPP/PB1Q1P2/R2R2K1 b - - 0 19",  0);
        map.put("4r1k1/b4p2/p4pp1/1p6/3p1N1P/1P2P1P1/P4P2/3R2K1 w - - 0 30",  0);
        map.put("3rk3/1Q4p1/p3p3/4RPqp/4p2P/P7/KPP5/8 b - h3 0 33",  0);
        map.put("6k1/1p1r1pp1/5qp1/p1pBP3/Pb3n2/1Q1RB2P/1P3PP1/6K1 b - - 0 28",  0);
        map.put("3r2k1/pp2bp2/1q4p1/3p1b1p/4PB1P/2P2PQ1/P2R2P1/3R2K1 w - - 1 28",  0);
        map.put("3r4/p1qn1pk1/1p1R3p/2P1pQpP/8/4B3/5PP1/6K1 w - - 0 35",  0);
        map.put("rnb1k1nr/pp2q1pp/2pp4/4pp2/2PPP3/8/PP2NPPP/R1BQKB1R w KQkq f6 0 8",  0);
        map.put("rnbqkbnr/pp1ppppp/2p5/8/3PP3/8/PPP2PPP/RNBQKBNR b KQkq d3 0 2",  0);
        map.put("4q1k1/6p1/p2rnpPp/1p2p3/7P/1BP5/PP3Q2/1K3R2 w - - 0 34",  0);
        map.put("3r2k1/p1q2pp1/1n2rn1p/1B2p3/P1p1P3/2P3BP/4QPP1/1R2R1K1 b - - 1 25",  0);
        map.put("8/p7/1b2BkR1/5P2/4K3/7r/P7/8 b - - 9 52",  0);
        map.put("2rq2k1/p4p1p/1p1prp2/1Ppb4/8/P1QPP1P1/1B3P1P/R3R1K1 w - - 2 20",  0);
        map.put("8/1pQ3bk/p2p1qp1/P2Pp2p/NP6/7P/5PP1/6K1 w - - 1 36",  0);
        map.put("8/1pQ3bk/p2p2p1/P2Pp2p/1P5P/2N3P1/2q2PK1/8 b - - 0 39",  0);
        map.put("r1bq1rk1/pp2n1bp/2pp1np1/3PppN1/1PP1P3/2N2B2/P4PPP/R1BQR1K1 w - - 0 13",  0);
        map.put("1r4k1/5p2/3P2pp/p3Pp2/5q2/2Q2P1P/5P2/4R1K1 w - - 0 29",  0);
        map.put("rnbqkbnr/pp2pppp/3p4/8/3pP3/5N2/PPP2PPP/RNBQKB1R w KQkq - 0 4",  0);
        map.put("R2qk2r/2p2ppp/1bnp1n2/1p2p3/3PP1b1/1BP2N2/1P3PPP/1NBQ1RK1 b k - 0 11",  0);
        map.put("6k1/4qp2/3p2p1/3Pp2p/7P/4Q1P1/5PBK/8 b - - 20 57",  0);
        map.put("3k4/r3q3/3p1p2/2pB4/P7/7P/6P1/1Q4K1 b - - 6 43",  0);
        map.put("5k2/1n4p1/2p2p2/p2q1B1P/P4PK1/6P1/1Q6/8 b - - 4 46",  0);
        map.put("6k1/pr2pb2/5pp1/1B1p4/P7/4QP2/1PP3Pq/2KR4 w - - 1 27",  0);
        map.put("1rbqk2r/2pp1ppp/2n2n2/1pb1p3/4P3/1BP2N2/1P1P1PPP/RNBQ1RK1 b k - 0 9",  0);
        map.put("6r1/2p5/pbpp1k1r/5b2/3P1N1p/1PP2N1P/P4R2/2K1R3 w - - 4 33",  0);
        map.put("rnbqkb1r/pppppppp/5n2/8/3P4/5N2/PPP1PPPP/RNBQKB1R b KQkq - 2 2",  0);
        map.put("rnbqkb1r/pppppppp/5n2/8/2PP4/8/PP2PPPP/RNBQKBNR b KQkq c3 0 2",  0);
        map.put("4b3/5p1k/r7/p3BNQp/4P1pP/1r1n4/1P3P1N/7K b - - 2 40",  0);
        map.put("r2q1rk1/pb1p2pp/1p1bpnn1/5p2/2PP4/PPN1BP1P/2B1N1P1/1R1Q1R1K b - - 2 16",  0);
        map.put("rnbqkbnr/ppp1pppp/8/8/2pP4/5N2/PP2PPPP/RNBQKB1R b KQkq - 1 3",  0);
        map.put("4rrk1/8/p1pR4/1p6/1PPKNq2/3P1p2/PB5n/R2Q4 b - - 6 40",  0);
        map.put("r1bqk1nr/1p2bppp/p1np4/4p3/2P1P3/N1N5/PP3PPP/R1BQKB1R b KQkq - 1 8",  0);
        map.put("r1bqk2r/pp2bppp/2n1p3/3n4/3P4/2NB1N2/PP3PPP/R1BQ1RK1 b kq - 3 9",  0);
        map.put("r1bqkbnr/pppp2pp/2n5/1B2p3/3Pp3/5N2/PPP2PPP/RNBQK2R w KQkq - 0 5",  0);
        map.put("2n1r3/p1k2pp1/B1p3b1/P7/5bP1/2N1B3/1P2KP2/2R5 b - - 4 25",  0);
        map.put("r4rk1/2q3pp/4p3/p1Pn1p2/1p1P4/4PP2/1B1Q2PP/R3R1K1 w - - 0 22",  0);
        map.put("8/8/1p6/3b4/1P1k1p2/8/3KBP2/8 w - - 2 68",  0);
        map.put("2b2k2/1p5p/2p5/p1p1q3/2PbN3/1P5P/P5B1/3RR2K w - - 4 33",  0);
        map.put("1b6/5kp1/5p2/1b1p4/1P6/4PPq1/2Q2RNp/7K b - - 2 41",  0);
        map.put("r3r1k1/p2nqpp1/bpp2n1p/3p4/B2P4/P1Q1PP2/1P2NBPP/R3K2R w KQ - 6 16",  0);
        map.put("r3k2r/8/p4p2/3p2p1/4b3/2R2PP1/P6P/4R1K1 b kq - 0 27",  0);
        map.put("r1rb2k1/5ppp/pqp5/3pPb2/QB1P4/2R2N2/P4PPP/2R3K1 b - - 7 23",  0);
        map.put("3r1r2/3P2pk/1p1R3p/1Bp2p2/6q1/4Q3/PP3P1P/7K w - - 4 30",  0);

        for (String s : map.keySet()) {
            Integer error = map.get(s);
            ValidateResult result = chessLib.validate_fen(s);
            assertEquals(error, new Integer(result.error_number));
        }
    }

    @Test
    public void testHistory() {
        List<String> moves = Arrays.asList("c4", "e6", "Nf3", "d5", "d4", "Nf6", "Nc3", "Be7", "Bg5", "O-O", "e3", "h6",
                "Bh4", "b6", "cxd5", "Nxd5", "Bxe7", "Qxe7", "Nxd5", "exd5", "Rc1", "Be6",
                "Qa4", "c5", "Qa3", "Rc8", "Bb5", "a6", "dxc5", "bxc5", "O-O", "Ra7",
                "Be2", "Nd7", "Nd4", "Qf8", "Nxe6", "fxe6", "e4", "d4", "f4", "Qe7",
                "e5", "Rb8", "Bc4", "Kh8", "Qh3", "Nf8", "b3", "a5", "f5", "exf5",
                "Rxf5", "Nh7", "Rcf1", "Qd8", "Qg3", "Re7", "h4", "Rbb7", "e6", "Rbc7",
                "Qe5", "Qe8", "a4", "Qd8", "R1f2", "Qe8", "R2f3", "Qd8", "Bd3", "Qe8",
                "Qe4", "Nf6", "Rxf6", "gxf6", "Rxf6", "Kg8", "Bc4", "Kh8", "Qf4");

        chessLib.reset();
        for (String move : moves) {
            chessLib.move(move);
        }

        assertEquals("4q2k/2r1r3/4PR1p/p1p5/P1Bp1Q1P/1P6/6P1/6K1 b - - 4 41", chessLib.fen());
        List<Move> history = chessLib.history();
        assertEquals(moves.size(), history.size());
        for (int i = 0; i < moves.size(); i++) {
            assertEquals(moves.get(i), history.get(i).san);
        }
    }

    @Test
    public void testCastlingFlag(){
        chessLib.load("b3k2r/5p2/4p3/1p5p/6p1/2PR2P1/BP3qNP/6QK b k - 2 28");
        chessLib.move("a8", "g2");
        assertEquals("4k2r/5p2/4p3/1p5p/6p1/2PR2P1/BP3qbP/6QK w k - 0 29", chessLib.fen());
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
