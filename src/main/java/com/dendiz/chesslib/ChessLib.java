package com.dendiz.chesslib;

import com.google.common.collect.ImmutableMap;

import java.util.*;
import java.util.regex.Pattern;

public class ChessLib {
    String BLACK = "b";
    String WHITE = "w";
    int EMPTY = -1;
    String PAWN = "p";
    String KNIGHT = "n";
    String BISHOP = "b";
    String ROOK = "r";
    String QUEEN = "q";
    String KING = "k";

    String SYMBOLS = "pnbrqkPNBRQK";
    String DEFAULT_POSITION = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

    List<String> POSSIBLE_RESULTS = Arrays.asList("1-0", "0-1", "1/2-1/2", "*");
    Map<String, List<Integer>> PAWN_OFFSETS =
            new HashMap<String, List<Integer>>() {{
        put(BLACK, Arrays.asList(16, 32, 17, 15));
        put(WHITE, Arrays.asList(-16, -32, -17, -15));
    }};

    Map<String, List<Integer>> PIECE_OFFSETS = new HashMap<String, List<Integer>>() {{
        put(KNIGHT, Arrays.asList(-18, -33, -31, -14, 18, 33, 31, 14));
        put(BISHOP, Arrays.asList(-17, -15, 17, 15));
        put(ROOK, Arrays.asList(-16, 1, 16, -1));
        put(QUEEN, Arrays.asList(-17, -16, -15, 1, 17, 16, 15, -1));
        put(KING, Arrays.asList(-17, -16, -15, 1, 17, 16, 15, -1));
    }};

    List<Integer> ATTACKS = Arrays.asList(
            20, 0, 0, 0, 0, 0, 0, 24, 0, 0, 0, 0, 0, 0, 20, 0,
            0, 20, 0, 0, 0, 0, 0, 24, 0, 0, 0, 0, 0, 20, 0, 0,
            0, 0, 20, 0, 0, 0, 0, 24, 0, 0, 0, 0, 20, 0, 0, 0,
            0, 0, 0, 20, 0, 0, 0, 24, 0, 0, 0, 20, 0, 0, 0, 0,
            0, 0, 0, 0, 20, 0, 0, 24, 0, 0, 20, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 20, 2, 24, 2, 20, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 2, 53, 56, 53, 2, 0, 0, 0, 0, 0, 0,
            24, 24, 24, 24, 24, 24, 56, 0, 56, 24, 24, 24, 24, 24, 24, 0,
            0, 0, 0, 0, 0, 2, 53, 56, 53, 2, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 20, 2, 24, 2, 20, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 20, 0, 0, 24, 0, 0, 20, 0, 0, 0, 0, 0,
            0, 0, 0, 20, 0, 0, 0, 24, 0, 0, 0, 20, 0, 0, 0, 0,
            0, 0, 20, 0, 0, 0, 0, 24, 0, 0, 0, 0, 20, 0, 0, 0,
            0, 20, 0, 0, 0, 0, 0, 24, 0, 0, 0, 0, 0, 20, 0, 0,
            20, 0, 0, 0, 0, 0, 0, 24, 0, 0, 0, 0, 0, 0, 20
    );

    List<Integer> RAYS = Arrays.asList(
            17, 0, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 15, 0,
            0, 17, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0, 15, 0, 0,
            0, 0, 17, 0, 0, 0, 0, 16, 0, 0, 0, 0, 15, 0, 0, 0,
            0, 0, 0, 17, 0, 0, 0, 16, 0, 0, 0, 15, 0, 0, 0, 0,
            0, 0, 0, 0, 17, 0, 0, 16, 0, 0, 15, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 17, 0, 16, 0, 15, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 17, 16, 15, 0, 0, 0, 0, 0, 0, 0,
            1, 1, 1, 1, 1, 1, 1, 0, -1, -1, -1, -1, -1, -1, -1, 0,
            0, 0, 0, 0, 0, 0, -15, -16, -17, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, -15, 0, -16, 0, -17, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, -15, 0, 0, -16, 0, 0, -17, 0, 0, 0, 0, 0,
            0, 0, 0, -15, 0, 0, 0, -16, 0, 0, 0, -17, 0, 0, 0, 0,
            0, 0, -15, 0, 0, 0, 0, -16, 0, 0, 0, 0, -17, 0, 0, 0,
            0, -15, 0, 0, 0, 0, 0, -16, 0, 0, 0, 0, 0, -17, 0, 0,
            -15, 0, 0, 0, 0, 0, 0, -16, 0, 0, 0, 0, 0, 0, -17
    );

    Map<String, Integer> SHIFTS = new HashMap<String, Integer>() {{
        put(PAWN, 0);
        put(KNIGHT, 1);
        put(BISHOP, 2);
        put(ROOK, 3);
        put(QUEEN, 4);
        put(KING, 5);
    }};
    String NORMAL = "NORMAL";
    String CAPTURE = "CAPTURE";
    String BIG_PAWN = "BIG_PAWN";
    String PROMOTION = "PROMOTION";
    String KSIDE_CASTLE = "KSIDE_CASTLE";
    String QSIDE_CASTLE = "QSIDE_CASTLE";
    String EP_CAPTURE = "EP_CAPTURE";

    Map<String, String> FLAGS = new HashMap<String, String>() {{
        put(NORMAL, "n");
        put(CAPTURE, "c");
        put(BIG_PAWN, "b");
        put(EP_CAPTURE, "e");
        put(PROMOTION, "p");
        put(KSIDE_CASTLE, "k");
        put(QSIDE_CASTLE, "q");
    }};

    Map<String, Integer> BITS = new HashMap<String, Integer>() {{
        put(NORMAL, 1);
        put(CAPTURE, 2);
        put(BIG_PAWN, 4);
        put(EP_CAPTURE, 8);
        put(PROMOTION, 16);
        put(KSIDE_CASTLE, 32);
        put(QSIDE_CASTLE, 64);
    }};
    int RANK_1 = 7;
    int RANK_2 = 6;
    //    int RANK_3 = 5;
//    int RANK_4 = 4;
//    int RANK_5 = 3;
//    int RANK_6 = 2;
    int RANK_7 = 1;
    int RANK_8 = 0;

    public Map<String, Integer> SQUARES = new HashMap<String, Integer>() {{
        put("a8", 0);
        put("b8", 1);
        put("c8", 2);
        put("d8", 3);
        put("e8", 4);
        put("f8", 5);
        put("g8", 6);
        put("h8", 7);
        put("a7", 16);
        put("b7", 17);
        put("c7", 18);
        put("d7", 19);
        put("e7", 20);
        put("f7", 21);
        put("g7", 22);
        put("h7", 23);
        put("a6", 32);
        put("b6", 33);
        put("c6", 34);
        put("d6", 35);
        put("e6", 36);
        put("f6", 37);
        put("g6", 38);
        put("h6", 39);
        put("a5", 48);
        put("b5", 49);
        put("c5", 50);
        put("d5", 51);
        put("e5", 52);
        put("f5", 53);
        put("g5", 54);
        put("h5", 55);
        put("a4", 64);
        put("b4", 65);
        put("c4", 66);
        put("d4", 67);
        put("e4", 68);
        put("f4", 69);
        put("g4", 70);
        put("h4", 71);
        put("a3", 80);
        put("b3", 81);
        put("c3", 82);
        put("d3", 83);
        put("e3", 84);
        put("f3", 85);
        put("g3", 86);
        put("h3", 87);
        put("a2", 96);
        put("b2", 97);
        put("c2", 98);
        put("d2", 99);
        put("e2", 100);
        put("f2", 101);
        put("g2", 102);
        put("h2", 103);
        put("a1", 112);
        put("b1", 113);
        put("c1", 114);
        put("d1", 115);
        put("e1", 116);
        put("f1", 117);
        put("g1", 118);
        put("h1", 119);

    }};


    Map<String, List<Map<String, Integer>>> ROOKS = new HashMap<String, List<Map<String, Integer>>>() {{
        Map<String, Integer> a1 = new HashMap<String, Integer>() {{
            put("square", 112);
            put("flag", 64);
        }};

        Map<String, Integer> h1 = new HashMap<String, Integer>() {{
            put("square", 119);
            put("flag", 32);
        }};


        put("w", Arrays.asList(a1, h1));

        Map<String, Integer> a8 = new HashMap<String, Integer>() {{
            put("square", 0);
            put("flag", 64);
        }};
        Map<String, Integer> h8 = new HashMap<String, Integer>() {{
            put("square", 7);
            put("flag", 32);
        }};

        put("b", Arrays.asList(a8, h8));

    }};

    Piece[] board = new Piece[128];
    Map<String, Integer> kings = new HashMap<String, Integer>() {{
        put(WHITE, EMPTY);
        put(BLACK, EMPTY);
    }};

    String turn = WHITE;
    Map<String, Integer> castling = new HashMap<String, Integer>() {{
        put(WHITE, EMPTY);
        put(BLACK, EMPTY);
    }};

    int ep_square = EMPTY;
    int half_moves = 0;
    int move_number = 1;
    Stack<HistoryItem> history = new Stack<>();
    Map<String, String> header = new HashMap<>();

    public String turn() {
        return turn;
    }

    public Move move(String move) {
        List<Move> moves = generate_moves();
        Move move_obj = null;
        String moveReplaced = move.replaceAll("[+#?!=]", "");
        for (int i = 0; i < moves.size(); i++) {
            if (moveReplaced.equals(move_to_san(moves.get(i)).replaceAll("[+#?!=]", ""))) {
                move_obj = moves.get(i);
                break;
            }
        }
        if (move_obj == null) {
            return null;
        }
        Move pretty_move = make_pretty(move_obj);
        make_move(move_obj);
        return pretty_move;
    }

    public Move undo() {
        Move move = undo_move();
        return make_pretty(move);
    }

    public void clear() {
        board = new Piece[128];
        kings = new HashMap<String, Integer>() {{
            put(WHITE, EMPTY);
            put(BLACK, EMPTY);
        }};
        turn = WHITE;
        castling = new HashMap<String, Integer>() {{
            put(WHITE, EMPTY);
            put(BLACK, EMPTY);
        }};
        ep_square = EMPTY;
        half_moves = 0;
        move_number = 1;
        history = new Stack<>();
        header = new HashMap<>();
        update_setup(generate_fen());
    }

    private void update_setup(String fen) {
        if (history.size() == 0) return;
        if (DEFAULT_POSITION.equals(fen)) {
            header.put("SetUp", "1");
            header.put("FEN", fen);
        } else {
            header.remove("SetUp");
            header.remove("FEN");
        }
    }

    public void reset() {
        load(DEFAULT_POSITION);
    }

    private boolean is_digit(char c) {
        return "0123456789".indexOf(c) > -1;
    }

    public List<Move> moves() {
        List<Move> ugly_moves = generate_moves();
        List<Move> moves = new ArrayList<>();
        for (int i = 0; i < ugly_moves.size(); i++) {
            moves.add(make_pretty(ugly_moves.get(i)));
        }
        return moves;
    }


    private Move make_pretty(Move ugly_move) {
        Move move = new Move(ugly_move.color, ugly_move.from, ugly_move.to, ugly_move.flags, ugly_move.piece, ugly_move.promotion, ugly_move.captured);
        move.san = move_to_san(ugly_move);
        move.strTo = algebraic(move.to);
        move.strFrom = algebraic(move.from);
        String flags = "";
        for (String flag : BITS.keySet()) {
            if ((BITS.get(flag) & move.flags) > 0) {
                flags += FLAGS.get(flag);
            }
        }
        move.strFlags = flags;
        return move;
    }

    public Boolean load(String fen) {
        String[] tokens = fen.split("\\s+");
        String position = tokens[0];
        int square = 0;

        if (!validate_fen(fen).valid) {
            return false;
        }
        clear();
        for (int i = 0; i < position.length(); i++) {
            char piece = position.charAt(i);
            if (piece == '/') {
                square += 8;
            } else if (is_digit(piece)) {
                square += Integer.parseInt(String.valueOf(piece));
            } else {
                String color = (piece < 'a') ? WHITE : BLACK;
                put(new Piece(String.valueOf(piece).toLowerCase(), color), algebraic(square));
                square++;
            }
        }

        turn = tokens[1];
        if (tokens[2].indexOf("K") > -1) {
            Integer w = castling.get(WHITE);
            castling.put("w", w | BITS.get(KSIDE_CASTLE));
        }

        if (tokens[2].indexOf("Q") > -1) {
            Integer w = castling.get("w");
            castling.put(WHITE, w | BITS.get(QSIDE_CASTLE));
        }

        if (tokens[2].indexOf("k") > -1) {
            Integer w = castling.get("b");
            castling.put(BLACK, w | BITS.get(KSIDE_CASTLE));
        }
        if (tokens[2].indexOf("q") > -1) {
            Integer w = castling.get("b");
            castling.put(BLACK, w | BITS.get(QSIDE_CASTLE));
        }
        ep_square = Objects.equals(tokens[3], "-") ? EMPTY : SQUARES.get(tokens[3]);
        half_moves = Integer.parseInt(tokens[4]);
        move_number = Integer.parseInt(tokens[5]);
        update_setup(generate_fen());
        return true;
    }

    private String generate_fen() {
        int empty = 0;
        String fen = "";
        for (int i = SQUARES.get("a8"); i < SQUARES.get("h1"); i++) {
            if (board[i] == null) {
                empty++;
            } else {
                if (empty > 0) {
                    fen += empty;
                    empty = 0;
                }
                String color = board[i].color;
                String ptype = board[i].ptype;
                fen += color.equals(WHITE) ? ptype.toUpperCase() : ptype.toLowerCase();
            }
            if (((i + 1) & 0x88) > 0) {
                if (empty > 0) {
                    fen += empty;
                }
                if (i != SQUARES.get("h1")) {
                    fen += "/";
                }
                empty = 0;
                i += 8;
            }
        }
        String cflags = "";
        if ((castling.get(WHITE) & BITS.get(KSIDE_CASTLE)) > 0) {
            cflags += "K";
        }
        if ((castling.get(WHITE) & BITS.get(QSIDE_CASTLE)) > 0) {
            cflags += "Q";
        }
        if ((castling.get(BLACK) & BITS.get(KSIDE_CASTLE)) > 0) {
            cflags += "k";
        }
        if ((castling.get(BLACK) & BITS.get(QSIDE_CASTLE)) > 0) {
            cflags += "q";
        }
        if (cflags.equals("")) cflags = "-";

        String epflags = ep_square == EMPTY ? "-" : algebraic(ep_square);
        return new StringBuilder()
                .append(fen).append(" ")
                .append(turn).append(" ")
                .append(cflags).append(" ")
                .append(epflags).append(" ")
                .append(half_moves).append(" ")
                .append(move_number).append(" ").toString();
    }

    private boolean isNaN(char c) {
        return c - '0' > 9;
    }

    private boolean isNaN(String s) {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (isNaN(c)) return true;
        }
        return false;
    }

    public String fen() {
        return generate_fen();
    }


    public ValidateResult validate_fen(String fen) {
        List<String> errors = Arrays.asList(
                "No errors.",
                "FEN string must contain six space-delimited fields.",
                "6th field (move number) must be a positive integer.",
                "5th field (half move counter) must be a non-negative integer.",
                "4th field (en-passant square) is invalid.",
                "3rd field (castling availability) is invalid.",
                "2nd field (side to move) is invalid.",
                "1st field (piece positions) does not contain 8 \"/\"-delimited rows.",
                "1st field (piece positions) is invalid [consecutive numbers].",
                "1st field (piece positions) is invalid [invalid piece].",
                "1st field (piece positions) is invalid [row too large]."
        );
        String[] tokens = fen.split("\\s+");

        if (tokens.length != 6) {
            return new ValidateResult(false, 1, errors.get(1));
        }


        if (isNaN(tokens[5]) || Integer.parseInt(tokens[5]) <= 0) {
            return new ValidateResult(false, 2, errors.get(2));
        }

        if (isNaN(tokens[4]) || Integer.parseInt(tokens[4]) < 0) {
            return new ValidateResult(false, 3, errors.get(3));
        }

        if (!Pattern.matches("^(-|[abcdefgh][36])$", tokens[3])) {
            return new ValidateResult(false, 4, errors.get(4));
        }

        if (!Pattern.matches("^(KQ?k?q?|Qk?q?|kq?|q|-)$", tokens[2])) {
            return new ValidateResult(false, 5, errors.get(5));
        }

        if (!Pattern.matches("^(w|b)$", tokens[1])) {
            return new ValidateResult(false, 6, errors.get(6));
        }

        String[] rows = tokens[0].split("/");
        if (rows.length != 8) {
            return new ValidateResult(false, 7, errors.get(7));
        }

        for (int i = 0; i < rows.length; i++) {
            int sum_fields = 0;
            boolean previous_was_number = false;
            for (int k = 0; k < rows[i].length(); k++) {
                char[] rowsi = rows[i].toCharArray();
                if (!isNaN(rowsi[k])) {
                    if (previous_was_number) {
                        return new ValidateResult(false, 8, errors.get(8));
                    }
                    sum_fields += rowsi[k] - '0';
                    previous_was_number = true;
                } else {
                    if (!Pattern.matches("^[prnbqkPRNBQK]$", String.valueOf(rowsi[k]))) {
                        return new ValidateResult(false, 9, errors.get(9));
                    }
                    sum_fields++;
                    previous_was_number = false;
                }
            }
            if (sum_fields != 8) {
                return new ValidateResult(false, 10, errors.get(10));
            }
        }
        return new ValidateResult(true, 0, errors.get(0));
    }

    public Map<String, String> getHeader() {
        return header;
    }

    public void setHeader(String... s) {
        set_header(s);
    }

    private Map<String, String> set_header(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            header.put(args[i], args[i + 1]);
        }
        return header;
    }

    public Piece get(String square) {
        return board[SQUARES.get(square)];
    }

    public Piece remove(String square) {
        Piece piece = get(square);
        board[SQUARES.get(square)] = null;
        if (piece != null && piece.ptype.equals(KING)) {
            kings.put(piece.color, EMPTY);
        }
        update_setup(generate_fen());
        return piece;
    }

    private Move build_move(Piece[] board, int from, int to, int flags, String promotion) {
        Move move = new Move(turn, from, to, flags, board[from].ptype, null, null);
        if (promotion != null) {
            move.flags |= BITS.get(PROMOTION);
            move.promotion = promotion;
        }
        if (board[to] != null) {
            move.captured = board[to].ptype;
        } else if ((flags & BITS.get(EP_CAPTURE)) > 0) {
            move.captured = PAWN;
        }
        return move;
    }

    public String square_color(String square) {
        if (SQUARES.containsKey(square)) {
            Integer sq088 = SQUARES.get(square);
            return ((rank(sq088) + file(sq088)) % 2 == 0) ? "light" : "dark";
        }
        return null;
    }

    public List<Move> history() {
        Stack<Move> reverseHistory = new Stack<>();
        Stack<Move> moveHistory = new Stack<>();
        while (history.size() > 0) {
            reverseHistory.push(undo_move());

        }

        while (reverseHistory.size() > 0) {
            Move move = reverseHistory.pop();
            moveHistory.push(make_pretty(move));
            make_move(move);
        }
        List<Move> moves = new ArrayList<>();
        while (!moveHistory.empty()) {
            moves.add(moveHistory.pop());
        }
        Collections.reverse(moves);
        return moves;
    }

    private int rank(int r) {
        return r>>4;
    }

    private String swap_color(String c) {
        return c.equals(WHITE) ? BLACK : WHITE;

    }

    private void add_move(Piece[] board, List<Move> moves, int from, int to, int flags) {
        System.err.println("board[from]" + board[from] + " from: " + from + " to:" + to);
        if (board[from].ptype.equals(PAWN) && (rank(to) == RANK_8 || rank(to) == RANK_1)) {
            List<String> pieces = Arrays.asList(QUEEN, ROOK, BISHOP, KNIGHT);
            for (String piece : pieces) {
                moves.add(build_move(board, from, to, flags, piece));
            }
        } else {
            moves.add(build_move(board, from, to, flags, null));
        }
    }

    private List<Move> generate_moves(Map<String, String> options) {
        List<Move> moves = new ArrayList<>();
        String us = turn;
        String them = swap_color(us);
        Map<String, Integer> second_rank = new HashMap<>();
        second_rank.put("b", RANK_7);
        second_rank.put("w", RANK_2);

        Integer first_sq = SQUARES.get("a8");
        Integer last_sq = SQUARES.get("h1");
        boolean single_square = false;

        if (options.containsKey("square")) {
            String s = options.get("square");
            if (!SQUARES.containsKey(s)) {
                return Collections.EMPTY_LIST;
            }
            first_sq = SQUARES.get(s);
            last_sq = first_sq;
            single_square = true;
        }

        for (int i = first_sq; i <= last_sq; i++) {
            if ((i & 0x88) > 0) {
                i += 7;
                continue;
            }

            Piece piece = board[i];
            if (piece == null ||  !piece.color.equals(us)) continue;
            if (piece.ptype.equals(PAWN)) {
                //pawn single sq
                int square = i + PAWN_OFFSETS.get(us).get(0);
                if (board[square] == null) {
                    //double sq
                    add_move(board, moves, i, square, BITS.get(NORMAL));
                    int square2 = i + PAWN_OFFSETS.get(us).get(1);
                    if (second_rank.get(us) == rank(i) && board[square2] == null) {
                        add_move(board, moves, i, square2, BITS.get(BIG_PAWN));
                    }
                }
                //pawn capture
                for (int j = 2; j < 4; j++) {
                    int square3 = i + PAWN_OFFSETS.get(us).get(j);
                    if ((square3 & 0x88) > 0) continue;
                    if (board[square3] != null && board[square3].color.equals(them)) {
                        add_move(board, moves, i, square3, BITS.get(CAPTURE));
                    } else if (square3 == ep_square) {
                        add_move(board, moves, i, ep_square, BITS.get(EP_CAPTURE));
                    }
                }
            } else {
                for (int j = 0; j < PIECE_OFFSETS.get(piece.ptype).size(); j++) {
                    Integer offset = PIECE_OFFSETS.get(piece.ptype).get(j);
                    int square = i;

                    while (true) {
                        square += offset;
                        if ((square & 0x88) > 0) break;
                        if (board[square] == null) {
                            add_move(board, moves, i, square, BITS.get(NORMAL));
                        } else {
                            if (board[square].color.equals(us)) break;
                            add_move(board, moves, i, square, BITS.get(CAPTURE));
                            break;
                        }

                        if (piece.ptype.equals("n") || piece.ptype.equals("k")) break;
                    }
                }
            }
        }

        if ((!single_square) || last_sq == kings.get(us)) {
            if ((castling.get(us) & BITS.get(KSIDE_CASTLE)) > 0) {
                Integer castling_from = kings.get(us);
                int castling_to = castling_from + 2;

                if (board[castling_from + 1] == null && board[castling_to] == null &&
                        !attacked(them, kings.get(us)) && !attacked(them, castling_from + 1)
                        && !attacked(them, castling_to)

                        ) {
                    add_move(board, moves, kings.get(us), castling_to, BITS.get(KSIDE_CASTLE));
                }
            }

            if ((castling.get(us) & BITS.get(QSIDE_CASTLE)) > 0) {
                Integer castling_from = kings.get(us);
                int castling_to = castling_from - 2;
                if (board[castling_from - 1] == null && board[castling_from - 2] == null && board[castling_from - 3] == null &&
                        !attacked(them, kings.get(us)) && !attacked(them, castling_from - 1)
                        && !attacked(them, castling_to)

                        ) {
                    add_move(board, moves, kings.get(us), castling_to, BITS.get(QSIDE_CASTLE));
                }


            }
        }

        List<Move> legal_moves = new ArrayList<>();
        for (int i = 0; i < moves.size(); i++) {
            make_move(moves.get(i));
            if (!king_attacked(us)) {
                legal_moves.add(moves.get(i));
            }
            undo_move();
        }
        return legal_moves;

    }

    private String move_to_san(Move move) {
        String output = "";
        if ((move.flags & BITS.get(KSIDE_CASTLE)) > 0) {
            output = "O-O";
        } else if ((move.flags & BITS.get(QSIDE_CASTLE)) > 0) {
            output = "O-O-O";
        } else {
            String disambiguator = get_disambiguator(move);
            if (!move.piece.equals(PAWN)) {
                output += move.piece.toUpperCase() + disambiguator;
            }

            if ((move.flags & (BITS.get(CAPTURE) | BITS.get(EP_CAPTURE))) > 0) {
                if (move.piece.equals(PAWN)) {
                    output += algebraic(move.from).toCharArray()[0];
                }
                output += "x";
            }

            output += algebraic(move.to);

            if ((move.flags & BITS.get(PROMOTION)) > 0) {
                output += "=" + move.promotion.toUpperCase();
            }
        }

        make_move(move);
        if (in_check()) {
            if (in_checkmate()) {
                output += "#";
            } else {
                output += "+";
            }
        }
        undo_move();
        return output;
    }

    private List<Move> generate_moves() {
        return generate_moves(new HashMap<>());
    }

    public boolean in_checkmate() {
        return in_check() && generate_moves().size() == 0;
    }

    public boolean in_stalemate() {
        return !in_check() && generate_moves().size() == 0;
    }

    public boolean in_draw() {
        return half_moves >= 100 || in_stalemate() || insufficient_material() || in_threefold_repetition();
    }

    public boolean insufficient_material() {
        Map<String, Integer> pieces = new HashMap<>();
        List<Integer> bishops = new ArrayList<>();
        int num_pieces = 0;
        int sq_color = 0;

        for (int i = SQUARES.get("a8"); i <= SQUARES.get("h1"); i++) {
            sq_color = (sq_color + 1) % 2;
            if ((i & 0x88) > 0) {
                i += 7;
                continue;
            }
            Piece piece = board[i];
            if (piece != null) {
                pieces.put(piece.ptype, pieces.containsKey(piece.ptype) ? pieces.get(piece.ptype) + 1 : 1);
                if (piece.ptype.equals(BISHOP)) {
                    bishops.add(sq_color);
                }
                num_pieces++;
            }
        }

        if (num_pieces == 2) return true;
        else if (num_pieces == 3 && (pieces.get(BISHOP) == 1 || pieces.get(KNIGHT) == 1)) return true;
        else if (num_pieces == pieces.get(BISHOP) + 2) {
            int sum = 0;
            int len = bishops.size();
            for (int i = 0; i < len; i++) {
                sum += bishops.get(i);
            }
            if (sum == 0 || sum == len) return true;
        }

        return false;
    }

    public boolean game_over() {
        return half_moves >= 100 || in_checkmate() || in_stalemate() || insufficient_material() || in_threefold_repetition();
    }

    public boolean in_threefold_repetition() {
        Stack<Move> moves = new Stack<>();
        Map<String, Integer> positions = new HashMap<>();
        boolean repetition = false;
        while (true) {
            Move move = undo_move();
            if (move == null) break;
            moves.push(move);
        }

        while (true) {
            String fen = join(Arrays.asList(generate_fen().split(" ")).subList(0, 4), " ");
            positions.put(fen, positions.containsKey(fen) ? positions.get(fen) + 1 : 1);
            if (positions.get(fen) >= 3) {
                repetition = true;
            }
            if (moves.size() == 0) {
                break;
            }
            Move last = moves.pop();
            make_move(last);
        }
        return repetition;
    }

    private <T> String join(List<T> list, String del) {
        StringBuffer output = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) output.append(del);
            output.append(list.get(i));
        }
        return output.toString();
    }

    public boolean in_check() {
        return king_attacked(turn);
    }

    private String get_disambiguator(Move move) {
        List<Move> moves = generate_moves();
        int from = move.from;
        int to = move.to;
        String piece = move.piece;
        int ambiguities = 0;
        int same_rank = 0;
        int same_file = 0;

        for (int i = 0; i < moves.size(); i++) {
            int ambig_from = moves.get(i).from;
            int ambig_to = moves.get(i).to;
            String ambig_piece = moves.get(i).piece;
            if (piece.equals(ambig_piece) && from != ambig_from && to == ambig_to) {
                ambiguities++;
                if (rank(from) == rank(ambig_from)) {
                    same_rank++;
                }

                if (file(from) == file(ambig_from)) {
                    same_file++;
                }
            }

        }

        if (ambiguities > 0) {
            if (same_rank > 0 && same_file > 0) {
                return algebraic(from);
            } else if (same_file > 0) {
                return algebraic(from).charAt(1) + "";
            } else {
                return algebraic(from).charAt(0) + "";
            }
        }
        return "";

    }

    private int file(int r) {
        return r & 15;
    }

    private Move undo_move() {
        HistoryItem old = history.pop();
        if (old == null) return null;
        Move move = old.move;
        kings = old.kings;
        turn = old.turn;
        castling = old.castling;
        ep_square = old.ep_square;
        half_moves = old.half_moves;
        move_number = old.move_number;
        String us = turn;
        String them = swap_color(turn);

        board[move.from] = board[move.to];
        board[move.from].ptype = move.piece;
        board[move.to] = null;

        if ((move.flags & BITS.get(CAPTURE)) > 0) {
            board[move.to] = new Piece(move.captured, them);
        } else if ((move.flags & BITS.get(EP_CAPTURE)) > 0) {
            int index = 0;
            if (us.equals(BLACK)) {
                index = move.to - 16;
            } else {
                index = move.to + 16;
            }
            board[index] = new Piece(PAWN, them);
        }

        if ((move.flags & (BITS.get(KSIDE_CASTLE) | BITS.get(QSIDE_CASTLE))) > 0) {
            int castling_to = 0, castling_from = 0;
            if ((move.flags & BITS.get(KSIDE_CASTLE)) > 0) {
                castling_to = move.to + 1;
                castling_from = move.to - 1;
            } else if ((move.flags & BITS.get(QSIDE_CASTLE)) > 0) {
                castling_to = move.to - 2;
                castling_from = move.to + 1;
            }
            board[castling_to] = board[castling_from];
            board[castling_from] = null;
        }

        return move;
    }

    private boolean king_attacked(String color) {
        return attacked(swap_color(color), kings.get(color));
    }

    private void make_move(Move move) {
        String us = turn;
        String them = swap_color(us);
        push(move);
        board[move.to] = board[move.from];
        board[move.from] = null;
        if ((move.flags & BITS.get(EP_CAPTURE)) > 0) {
            if (turn.equals(BLACK)) {
                board[move.to - 16] = null;
            } else {
                board[move.to + 16] = null;
            }

        }

        if ((move.flags & BITS.get(PROMOTION)) > 0) {
            board[move.to] = new Piece(move.promotion, us);
        }

        if (board[move.to].ptype.equals(KING)) {
            kings.put(board[move.to].color, move.to);

            if ((move.flags & BITS.get(KSIDE_CASTLE)) > 0) {
                int castling_to = move.to - 1;
                int castling_from = move.to + 1;
                board[castling_to] = board[castling_from];
                board[castling_from] = null;
            } else if ((move.flags & BITS.get(QSIDE_CASTLE)) > 0) {
                int castling_to = move.to + 1;
                int castling_from = move.to - 2;
                board[castling_to] = board[castling_from];
                board[castling_from] = null;
            }

            castling.put(us, -1);

        }

        if (castling.get(us) > -1) {
            for (int i = 0; i < ROOKS.get(us).size(); i++) {
                if (move.from == ROOKS.get(us).get(i).get("square") &&
                        (castling.get(us) & ROOKS.get(us).get(i).get("flag")) > 0) {
                    Integer flag = ROOKS.get(us).get(i).get("flag");
                    castling.put(us, castling.get(us) ^ flag);
                    break;
                }
            }
        }

        if (castling.get(them) > -1) {
            for (int i = 0; i < ROOKS.get(them).size(); i++) {
                if (move.to == ROOKS.get(them).get(i).get("square") &&
                        (castling.get(them) & ROOKS.get(them).get(i).get("flag")) > 0) {
                    Integer flag = ROOKS.get(them).get(i).get("flag");
                    castling.put(us, castling.get(them) ^ flag);
                    break;
                }
            }
        }

        if ((move.flags & BITS.get(BIG_PAWN)) > 0) {
            if (turn.equals("b")) {
                ep_square = move.to - 16;
            } else {
                ep_square = move.to + 16;
            }
        } else {
            ep_square = EMPTY;
        }

        if (move.piece.equals(PAWN)) {
            half_moves = 0;
        } else if ((move.flags & (BITS.get(CAPTURE) | BITS.get(EP_CAPTURE))) > 0) {
            half_moves = 0;
        } else {
            half_moves++;
        }

        if (turn.equals(BLACK)) {
            move_number++;
        }
        turn = swap_color(turn);
    }


    private boolean attacked(String color, int square) {
        for (int i = SQUARES.get("a8"); i < SQUARES.get("h1"); i++) {

            if ((i & 0x88) > 0) {
                i += 7;
                continue;
            }

            if (board[i] == null || !board[i].color.equals(color)) continue;
            Piece piece = board[i];
            int difference = i - square;
            int index = difference + 119;

            if ((ATTACKS.get(index) & (1 << SHIFTS.get(piece.ptype))) > 0) {
                if (piece.ptype.equals(PAWN)) {
                    if (difference > 0) {
                        if (piece.color.equals(WHITE)) return true;
                    } else {
                        if (piece.color.equals(BLACK)) return true;
                    }
                    continue;
                }

                if (piece.ptype.equals("n") || piece.ptype.equals("k")) return true;

                int offset = RAYS.get(index);
                int j = i + offset;
                boolean blocked = false;
                while (j != square) {
                    if (board[j] != null) {
                        blocked = true;
                        break;
                    }
                    j += offset;
                }
                if (!blocked) return true;

            }

        }
        return false;
    }

    private void push(Move move) {
        HistoryItem item = new HistoryItem(move, kings, turn, castling, ep_square, half_moves, move_number);
        history.push(item);

    }

    public boolean put(Piece piece, String square) {
        if (SYMBOLS.indexOf(piece.ptype.toLowerCase()) == -1) {
            return false;
        }
        if (! (SQUARES.containsKey(square))) {
            return false;
        }
        int sq = SQUARES.get(square);
        if (piece.ptype.equals(KING) &&
                !(kings.get(piece.color) == EMPTY || kings.get(piece.color) == sq)
                ) {
            return false;
        }

        board[sq] = new Piece(piece.ptype, piece.color);
        if (piece.ptype.equals(KING)) {
            kings.put(piece.color, sq);
        }

        update_setup(generate_fen());
        return true;

    }

    private String algebraic(int i) {
        int f = file(i);
        int r = rank(i);
        return "abcdefgh".substring(f, f + 1) + "87654321".substring(r, r + 1);

    }

}
