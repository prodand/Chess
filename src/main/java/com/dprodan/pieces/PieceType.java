package com.dprodan.pieces;

import com.dprodan.entities.Position;

public enum PieceType {

    KING(1) {
        @Override
        public Piece createPiece(Position p) {
            return new King(p);
        }
    },
    ROOK(2) {
        @Override
        public Piece createPiece(Position p) {
            return new Rook(p);
        }
    },
    BISHOP(3) {
        @Override
        public Piece createPiece(Position p) {
            return new Bishop(p);
        }
    },
    QUEEN(4) {
        @Override
        public Piece createPiece(Position p) {
            return new Queen(p);
        }
    };

    private final int index;

    PieceType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public abstract Piece createPiece(Position p);
}
