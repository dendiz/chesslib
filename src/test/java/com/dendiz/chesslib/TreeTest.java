package com.dendiz.chesslib;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertFalse;

public class TreeTest {
    ChessLib chessLib = new ChessLib();
    List<Stack<Node>> stacks = new ArrayList<>();

    @Test
    public void test2() {
        chessLib.load("6k1/p1b3p1/4p2r/1Pp4b/3pPp1q/1P1P1P2/2P1QR2/R5KN b - - 0 1");
        chessLib.move("Qg5+");
        assertFalse(chessLib.in_checkmate());
        chessLib.move("Kh2");
        assertFalse(chessLib.in_checkmate());
    }

    @Test
    public void test1() {
        chessLib.load("6k1/p1b3p1/4p2r/1Pp4b/3pPp1q/1P1P1P2/2P1QR2/R5KN b - - 0 1");
        Node root = new Node();
        root.children = new ArrayList<>();

        build(root , 0);
        int c = countNodes(root);
        System.out.println("Nodes count:" + c);
        c = countMateNodes(root);
        System.out.println("Mate Nodes count:" + c);
        Stack<Node> track = new Stack<>();
        findCheckMates(root, track,0);
        for (Stack<Node> stack : stacks) {
            while(!stack.empty()) {
                Node pop = stack.pop();
                System.out.print(pop.move);
            }
            System.out.println(" ");
        }
    }

    private int countMateNodes(Node root) {
        if (root.children.size() == 0) return 0;
        int c = 0;
        for (Node child : root.children) {
            if (child.score > 999  || child.score < -999) {
            }
            c+= (child.score > 999  || child.score < -999 ? 1 : 0) + countMateNodes(child);
        }
        return c;
    }

    public void findCheckMates(Node node, Stack<Node> track, int len) {
        if (node.score > 999 || node.score < -999) {
            int i=0;
            while(i < track.size()) {

                Node pop = track.get(i++);
                System.out.print(pop.move + " ");
            }
            System.out.println(node.move + " ");
        } else {
            track.push(node);
            for (Node child : node.children) {

                findCheckMates(child, track, len + 1);
            }
            track.pop();

        }


    }

    public int countNodes(Node node) {
        if (node.children == null || node.children.size() == 0) return 0;
        int count = 0;
        for (Node child : node.children) {
            count += node.children.size() +  countNodes(child);
        }
        return count;
    }

    public void build(Node node, int depth) {
        if(depth == 3) return;
        List<Move> moves = chessLib.moves();
        for (Move move : moves) {
            Node n = new Node();
            n.move = move;
            n.children = new ArrayList<>();
            node.children.add(n);
        }

        for (Node child : node.children) {
            chessLib.move(child.move);
            child.score = eval();
            build(child, depth + 1);
            chessLib.undo();
        }
    }

    public int eval() {
        Map<String, Integer> values = new HashMap<>();
        values.put("p", 1);
        values.put("n", 3);
        values.put("b", 3);
        values.put("r", 5);
        values.put("q", 9);
        values.put("k", 100);
        int mul = chessLib.turn.equals("WHITE") ? 1 : -1;
        if (chessLib.in_checkmate()) {
            return mul * 1000;
        }
        int bs=0,ws =0;
        for (int i = ChessLib.SQUARES.get("a8"); i <= ChessLib.SQUARES.get("h1"); i++) {
            if ((i & 0x88) > 0) {
                i += 7;
                continue;
            }
            Piece piece = chessLib.board[i];
            if (piece != null) {
                int val = values.get(piece.ptype);
                if (piece.color.equals("w")) {
                    ws += val;
                } else {
                    bs += val;
                }
            }

        }
        return ws-bs;
    }

    class Node {
        public Move move;
        public List<Node> children;
        public int score = 0;

    }
}
