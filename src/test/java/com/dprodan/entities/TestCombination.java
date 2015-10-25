package com.dprodan.entities;

import com.dprodan.main.Board;
import com.dprodan.pieces.Piece;
import com.dprodan.pieces.PieceType;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.fail;

public class TestCombination {

    @Test
    public void testHashUniquness() throws IOException {
        List<PieceFactory> pieceTypes = Arrays.asList(pf(PieceType.QUEEN, "Q"), pf(PieceType.QUEEN, "U"),
                pf(PieceType.ROOK, "R"), pf(PieceType.BISHOP, "B"));
        Board board = new Board(5, 5);
        Map<Combination, List<Combination>> result = new HashMap<>();
        nextPiece(board, pieceTypes, 0, new Combination.CombinationBuilder(), result);

        result.keySet().stream().forEach(cmb -> {
            Combination prev = null;
            for (Combination b : result.get(cmb)) {
                if (prev != null && !b.getValue().equals(prev.getValue())) {
                    fail();
                }
                prev = b;
            }
        });
    }

    private void nextPiece(Board board, List<PieceFactory> pieceTypes, int index, Combination.CombinationBuilder builder, Map<Combination, List<Combination>> combs) {
        Combination cmb = builder.build();
        List<Combination> list = combs.get(cmb);
        if(list == null) {
            list = new LinkedList<>();
            combs.put(cmb, list);
        }
        list.add(cmb);
        if(index == pieceTypes.size()) {
            return ;
        }
        PieceFactory testPieceType = pieceTypes.get(index);
        PieceType pieceType = testPieceType.getType();
        for(Position p : board.availablePositions()) {
            Piece piece = testPieceType.createPiece(p);
            Combination.CombinationBuilder clonedBuilder = builder.clone();
            clonedBuilder.add(new PositionedPiece(pieceType, p));
            nextPiece(board.place(piece), pieceTypes, index + 1, clonedBuilder, combs);
        }
    }

    private PieceFactory pf(PieceType type, String name) {
        return new PieceFactory(type, name);
    }


    private static class TestPiece extends Piece {

        private final PieceType type;
        private final String name;

        public TestPiece(Position position, PieceType type, String name) {
            super(position);
            this.type = type;
            this.name = name;
        }

        @Override
        public Set<Position> hittedPositions(int xDim, int yDim) {
            return new HashSet<>();
        }

        @Override
        public PieceType getType() {
            return type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TestPiece testPiece = (TestPiece) o;
            return Objects.equals(type, testPiece.type) &&
                    Objects.equals(getPosition(), testPiece.getPosition());
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, getPosition());
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private static class PieceFactory {

        private final PieceType type;
        private final String name;

        private PieceFactory(PieceType type, String name) {
            this.type = type;
            this.name = name;
        }

        public PieceType getType() {
            return type;
        }

        public Piece createPiece(Position p) {
            return new TestPiece(p, getType(), name);
        }
    }

}
