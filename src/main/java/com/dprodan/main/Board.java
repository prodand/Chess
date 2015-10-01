package com.dprodan.main;

import com.dprodan.entities.Position;
import com.dprodan.pieces.Piece;

import java.util.*;

public class Board {

    private final int xDim;
    private final int yDim;
    private final LinkedHashSet<Position> squares;
    private final Map<Position, Piece> pieces;

    public Board(int xDim, int yDim) {
        this(xDim, yDim, new LinkedHashSet<Position>(xDim * yDim), new HashMap<Position, Piece>());
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
     * @param piece
     * @return
     */
    public Board place(Piece piece) {
        if(!squares.contains(piece.getPosition())) {
            throw new IllegalArgumentException("The piece can't be placed on the Board: Wrong location.");
        }
        if(pieces.containsKey(piece.getPosition())) {
            throw new IllegalArgumentException("The piece can't be placed on the Board: Position is not free");
        }

        // TODO: keep sorted to minimize iterations
        LinkedHashSet<Position> copy = new LinkedHashSet<Position>(squares);
        Set<Position> hitted = piece.hittedPositions(xDim, yDim);
        for(Position position : hitted) {
            copy.remove(position);
        }
        copy.remove(piece.getPosition());

        HashMap<Position, Piece> piecesCopy = new HashMap<Position, Piece>(pieces);
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < xDim; i++) {
            for(int j = 0; j < yDim; j++) {
                Piece p = pieces.get(new Position(i, j));
                if(p != null) {
                    builder.append(p);
                } else {
                    builder.append("_");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
