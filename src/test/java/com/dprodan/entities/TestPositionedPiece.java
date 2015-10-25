package com.dprodan.entities;

import com.dprodan.main.Board;
import com.dprodan.pieces.PieceType;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TestPositionedPiece {

    @Test
    public void testHash() {
        Board b = new Board(5, 5);
        Set<Position> pos = b.availablePositions();
        Set<PositionedPiece> pp = new HashSet<>();
        Set<Integer> ints = new HashSet<>();
        for(Position p : pos) {
            for(PieceType t : PieceType.values()) {
                PositionedPiece pi = new PositionedPiece(t, p);
                pp.add(pi);
                ints.add(pi.hashCode());
                System.out.println(pi + " - " + pi.hashCode());
            }
        }
        Assert.assertEquals(100, pp.size());
        Assert.assertEquals(100, ints.size());
    }
}
