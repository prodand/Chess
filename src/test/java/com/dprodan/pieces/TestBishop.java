package com.dprodan.pieces;

import com.dprodan.entities.Position;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestBishop extends AbstractPieceTest {

    @Test
    public void testHittedPositions_2x3() {
        Bishop b = new Bishop(new Position(2, 3));
        Set<Position> res = b.hittedPositions(5, 5);
        Set<Position> expected = new HashSet<>(Arrays.asList(p(0, 1), p(1, 2), p(3, 4),
                p(1, 4), p(3, 2), p(4, 1)));

        assertEquals(expected, res);
    }

    @Test
    public void testHittedPositions_3x2() {
        Bishop b = new Bishop(new Position(3, 2));
        Set<Position> res = b.hittedPositions(5, 5);
        Set<Position> expected = new HashSet<>(Arrays.asList(p(1, 0), p(2, 1), p(4, 3),
                p(4, 1), p(2, 3), p(1, 4)));

        assertEquals(expected, res);
    }

    @Test
    public void testHittedPositions_0x2() {
        Bishop b = new Bishop(new Position(0, 2));
        Set<Position> res = b.hittedPositions(5, 5);
        Set<Position> expected = new HashSet<>(Arrays.asList(p(1, 3), p(2, 4),
                p(1, 1), p(2, 0)));

        assertEquals(expected, res);
    }

    @Test
    public void testHittedPositions_1x2() {
        Bishop b = new Bishop(new Position(1, 1));
        Set<Position> res = b.hittedPositions(10, 5);
        Set<Position> expected = new HashSet<>(Arrays.asList(p(0, 0), p(2, 2), p(3, 3), p(4, 4),
                p(2, 0), p(0, 2)));

        assertEquals(expected, res);
    }

    @Test
    public void testHittedPositions_1x1() {
        Bishop b = new Bishop(new Position(1, 2));
        Set<Position> res = b.hittedPositions(10, 5);
        Set<Position> expected = new HashSet<>(Arrays.asList(p(0, 1), p(2, 3), p(3, 4),
                p(2, 1), p(3, 0), p(0, 3)));
    }

}
