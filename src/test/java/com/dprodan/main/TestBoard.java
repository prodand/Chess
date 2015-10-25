package com.dprodan.main;

import com.dprodan.entities.Position;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestBoard {

    @Test
    public void testAvailablePositions() {
        Board b = new Board(5, 5);
        Set<Position> pos = b.availablePositions();
        assertEquals(25, pos.size());
    }
}
