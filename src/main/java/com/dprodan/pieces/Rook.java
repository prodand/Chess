package com.dprodan.pieces;

import com.dprodan.entities.Position;

import java.util.HashSet;
import java.util.Set;

public class Rook extends Piece {

    private final static String SIGN = "R";

    public Rook(Position position) {
        super(position);
    }

    @Override
    public Set<Position> hittedPositions(int xDim, int yDim) {
        Set<Position> res = new HashSet<Position>();
        for(int i = 0; i < xDim; i++) {
            res.add(new Position(i, getPosition().getY()));
        }
        for(int j = 0; j < yDim; j++) {
            res.add(new Position(getPosition().getX(), j));
        }
        res.remove(getPosition());
        return res;
    }

    @Override
    public PieceType getType() {
        return PieceType.ROOK;
    }

    @Override
    public String toString() {
        return SIGN;
    }
}
