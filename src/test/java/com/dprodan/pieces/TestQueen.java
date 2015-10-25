package com.dprodan.pieces;

import com.dprodan.entities.Position;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestQueen extends AbstractPieceTest {

    @Test
    public void testHittedPositions_2x2() {
        Queen queen = new Queen(new Position(2, 2));
        Set<Position> res = queen.hittedPositions(5, 5);
        Set<Position> expected = set(p(0, 0), p(1, 1), p(3, 3), p(4, 4),
                p(4, 0), p(3, 1), p(1, 3), p(0, 4),
                p(2, 0), p(2, 1), p(2, 3), p(2, 4),
                p(0, 2), p(1, 2), p(3, 2), p(4, 2));

        assertEquals(expected, res);
    }

    @Test
    public void testHittedPositions_1x2() {
        Queen q = new Queen(p(1, 2));
        Set<Position> res = q.hittedPositions(5, 5);

        Set<Position> ex = set(p(0, 1), p(2, 3), p(3, 4),
                p(2, 1), p(3, 0), p(0, 3),
                p(1, 1), p(1, 0), p(1, 3), p(1, 4),
                p(0, 2), p(2, 2), p(3, 2), p(4, 2));

        assertEquals(ex, res);
    }
}
