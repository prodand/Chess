package com.dprodan.pieces;

import com.dprodan.entities.Position;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

public class TestKing {

    @Test
    public void testHittedPositions() {
        King king = new King(new Position(1, 1));
        Set<Position> res = king.hittedPositions(3, 3);

        assertEquals(8, res.size());
        assertTrue(res.contains(new Position(0, 0)));
        assertTrue(res.contains(new Position(0, 1)));
        assertTrue(res.contains(new Position(0, 2)));
        assertTrue(res.contains(new Position(1, 0)));
        assertTrue(res.contains(new Position(1, 2)));
        assertTrue(res.contains(new Position(2, 0)));
        assertTrue(res.contains(new Position(2, 1)));
        assertTrue(res.contains(new Position(2, 2)));
    }

    @Test
    public void testHittedPositions_zero() {
        King king = new King(new Position(0, 0));
        Set<Position> res = king.hittedPositions(3, 3);

        assertEquals(3, res.size());
        assertTrue(res.contains(new Position(0, 1)));
        assertTrue(res.contains(new Position(1, 1)));
        assertTrue(res.contains(new Position(1, 0)));
    }

}
