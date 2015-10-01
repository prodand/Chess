package com.dprodan.pieces;

import com.dprodan.entities.Position;

import java.util.HashSet;
import java.util.Set;

public class King extends Piece {

    private Set<Position> downPositions = new HashSet<Position>();

    public King(Position position) {
        super(position);
        init();
    }

    private void init() {

    }

    @Override
    public Set<Position> hittedPositions(int xDim, int yDim) {
        Set<Position> result = new HashSet<Position>(downPositions);
        Position p = getPosition();
        for(int i = Math.max(0, p.getX() - 1); i <= Math.min(xDim, p.getX() + 1); i++) {
            for(int j = Math.max(0, p.getY() - 1); j <= Math.min(yDim, p.getY() + 1); j++) {
                result.add(new Position(i, j));
            }
        }
        result.remove(getPosition());
        return result;
    }

    @Override
    public PieceType getType() {
        return PieceType.KING;
    }

    @Override
    public String toString() {
        return "K";
    }
}
