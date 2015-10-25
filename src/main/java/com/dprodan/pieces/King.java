package com.dprodan.pieces;

import com.dprodan.entities.Position;

import java.util.HashSet;
import java.util.Set;

public class King extends Piece {


    private static final String SIGN = "K";

    public King(Position position) {
        super(position);
    }

    @Override
    public Set<Position> hittedPositions(int xDim, int yDim) {
        Set<Position> result = new HashSet<Position>();
        Position p = getPosition();

        // if x at the edge take min or max position on the board
        int fromX = Math.max(0, p.getX() - 1);
        int toX = Math.min(xDim, p.getX() + 1);

        int fromY = Math.max(0, p.getY() - 1);
        int toY = Math.min(yDim, p.getY() + 1);

        for(int i = fromX; i <= toX; i++) {
            for(int j = fromY; j <= toY; j++) {
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
        return SIGN;
    }
}
