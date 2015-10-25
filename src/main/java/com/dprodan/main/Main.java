package com.dprodan.main;

import com.dprodan.entities.Combination;
import com.dprodan.pieces.PieceType;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        PieceType[] pieces = new PieceType[]{PieceType.ROOK, PieceType.QUEEN, PieceType.BISHOP, PieceType.QUEEN};
//        PieceType[] pieces = new PieceType[]{PieceType.KING, PieceType.KING, PieceType.ROOK, PieceType.BISHOP};
        Arrays.sort(pieces);
        Arrays.sort(pieces, Collections.reverseOrder());
        Board board = new Board(4, 4);
        Runner runner = new Runner(pieces);
        runner.nextPiece(board, 0, new Combination.CombinationBuilder(), board.availablePositions());
    }
}
