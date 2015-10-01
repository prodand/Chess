package com.dprodan.pieces;

import com.dprodan.entities.Position;

import java.util.Set;

public abstract class Piece {

    private Position position;

    public Piece(int x, int y) {
        this(new Position(x, y));
    }

    public Piece(Position position) {
        this.position = position;
    }

    public abstract Set<Position> hittedPositions(int xDim, int yDim);

    public abstract PieceType getType();

    public Position getPosition() {
        return position;
    }

}
