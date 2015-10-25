package com.dprodan.pieces;

import com.dprodan.entities.Position;

import java.util.HashSet;
import java.util.Set;

public class Queen extends Piece {

    private static final String SIGN = "Q";

    public Queen(Position position) {
        super(position);
    }

    @Override
    public Set<Position> hittedPositions(int xDim, int yDim) {
        Position p = getPosition();

        Set<Position> res = new HashSet<>();
        for(int i = 0; i < xDim; i++) {
            res.add(new Position(i, getPosition().getY()));
        }
        for(int i = 0; i < yDim; i++) {
            res.add(new Position(getPosition().getX(), i));
        }

        int min = Math.min(p.getX(), p.getY());
        int max = Math.min(xDim - p.getX(), yDim - p.getY());
        for(int i = -min; i < max; i++) {
            res.add(new Position(p.getX() + i, p.getY() + i));
        }

        min = Math.min(p.getX(), yDim - p.getY() - 1);
        max = Math.min(xDim - p.getX() - 1, p.getY());
        for(int i = -min; i <= max; i++) {
            res.add(new Position(p.getX() + i, p.getY() - i));
        }

        res.remove(p);
        return res;
    }

    @Override
    public PieceType getType() {
        return PieceType.QUEEN;
    }

    @Override
    public String toString() {
        return SIGN;
    }
}
