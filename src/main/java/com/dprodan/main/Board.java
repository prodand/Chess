package com.dprodan.main;

import com.dprodan.entities.Position;
import com.dprodan.pieces.Piece;

import java.util.*;
import java.util.stream.Collectors;

public class Board {

    private final int xDim;
    private final int yDim;
    private final LinkedHashSet<Position> squares;
    private final Map<Position, Piece> pieces;

    public Board(int xDim, int yDim) {
        this(xDim, yDim, new LinkedHashSet<>(xDim * yDim), new HashMap<>());
        init();
    }

    private Board(int xDim, int yDim, LinkedHashSet<Position> squares, Map<Position, Piece> pieces) {
        this.xDim = xDim;
        this.yDim = yDim;
        this.squares = squares;
        this.pieces = pieces;

    }

    private void init() {
        for(int i = 0; i < xDim; i++) {
            for(int j = 0; j < yDim; j++) {
                squares.add(new Position(i, j));
            }
        }
    }

    /**
     * Place the Piece on the Board. It's possible to place the piece on any position which is not occupied
     * by other piece and can't be hitted by other piece.
     *
     * @param piece - piece to be placed
     * @return - copy of the board with piece placed on it
     */
    public Board place(Piece piece) {
        if(!squares.contains(piece.getPosition())) {
            throw new IllegalArgumentException("The piece can't be placed on the Board: Wrong location.");
        }
        if(pieces.containsKey(piece.getPosition())) {
            throw new IllegalArgumentException("The piece can't be placed on the Board: Position is not free");
        }

        LinkedHashSet<Position> copy = new LinkedHashSet<>(squares);
        Set<Position> hitted = piece.hittedPositions(xDim, yDim);
        hitted.forEach(copy::remove);
        copy.remove(piece.getPosition());

        HashMap<Position, Piece> piecesCopy = new HashMap<>(pieces);
        piecesCopy.put(piece.getPosition(), piece);

        return new Board(xDim, yDim, copy, piecesCopy);
    }

    public boolean isInPosition(Piece piece) {
        Set<Position> hitted = piece.hittedPositions(xDim, yDim);
        for(Position p : pieces.keySet()) {
            if(hitted.contains(p)) {
                return true;
            }
        }
        return false;
    }

    public Set<Position> availablePositions() {
        return Collections.unmodifiableSet(squares);
    }

    /**
     * Gets available positions for intersection [0..xTo]x[0..yTo]
     *
     * @param xTo - last x position to check
     * @param yTo - last y position to check
     * @return - set of positions for given range
     */
    public Set<Position> availablePositions(int xTo, int yTo) {
        return squares.stream().filter(p -> (p.getX() <= xTo && p.getY() <= yTo)).collect(Collectors.toSet());
    }

    public Collection<Piece> getPieces() {
        return new HashSet<>(pieces.values());
    }

    public int getxDim() {
        return xDim;
    }

    public int getyDim() {
        return yDim;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieces);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        if(!Objects.equals(xDim, board.xDim) || !Objects.equals(yDim, board.yDim)) {
            return false;
        }
        if(board.pieces.size() != pieces.size()) {
            return false;
        }
        for (Position p : pieces.keySet()) {
            if(!board.pieces.containsKey(p)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("\n");
        for(int j = 0; j < yDim; j++) {
            for(int i = 0; i < xDim; i++) {
                Piece p = pieces.get(new Position(i, j));
                if(p != null) {
                    builder.append(p);
                    builder.append(" ");
                } else {
                    builder.append("_ ");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
