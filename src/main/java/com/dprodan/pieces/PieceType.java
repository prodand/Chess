package com.dprodan.pieces;

import com.dprodan.entities.Position;

public enum PieceType {

    KING {
        @Override
        public Piece createPiece(Position p) {
            return new King(p);
        }
    },
    ROOK {
        @Override
        public Piece createPiece(Position p) {
            return new Rook(p);
        }
    };

    public abstract Piece createPiece(Position p);
}
