package com.dprodan.pieces;

import com.dprodan.entities.Position;

import java.util.HashSet;
import java.util.Set;

public class Bishop extends Piece {

    private final static String SIGN = "B";

    public Bishop(Position position) {
        super(position);
    }

    @Override
    public Set<Position> hittedPositions(int xDim, int yDim) {
        Set<Position> res = new HashSet<Position>();
        Position p = getPosition();
        int from = Math.min(p.getX(), p.getY());
        int to = Math.min(xDim - p.getX(), yDim - p.getY());
        for(int i = -from; i < to; i++) {
            res.add(new Position(p.getX() + i, p.getY() + i));
        }

        from = Math.min(p.getX(), yDim - p.getY() - 1);
        to = Math.min(xDim - p.getX() - 1, p.getY());
        for(int i = -from; i <= to; i++) {
            res.add(new Position(p.getX() + i, p.getY() - i));
        }

        res.remove(p);
        return res;
    }

    @Override
    public PieceType getType() {
        return PieceType.BISHOP;
    }

    @Override
    public String toString() {
        return SIGN;
    }
}
