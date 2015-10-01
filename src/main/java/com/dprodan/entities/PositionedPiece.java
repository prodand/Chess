package com.dprodan.entities;

import com.dprodan.pieces.PieceType;

import java.util.Objects;

/**
 * Class intends for comparison of combinations.
 * Swapping location of pieces of the same type should be treated as a one combination
 */
public class PositionedPiece {

    private final PieceType type;
    private final Position position;

    public PositionedPiece(PieceType type, Position position) {
        this.type = type;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionedPiece that = (PositionedPiece) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, position);
    }
}
