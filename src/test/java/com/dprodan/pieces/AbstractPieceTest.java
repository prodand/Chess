package com.dprodan.pieces;

import com.dprodan.entities.Position;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractPieceTest {

    protected Position p(int x, int y) {
        return new Position(x, y);
    }

    protected Set<Position> set(Position... positions) {
        return new HashSet<>(Arrays.asList(positions));
    }
}
