package com.dprodan.main;

import com.dprodan.entities.Position;
import com.dprodan.entities.PositionedPiece;
import com.dprodan.pieces.Piece;
import com.dprodan.pieces.PieceType;

import java.util.*;

public class Runner {

    public static void main(String[] args) {
        PieceType[] pieces = new PieceType[]{PieceType.KING, PieceType.KING, PieceType.ROOK};
        Board board = new Board(3, 3);
        Runner runner = new Runner();
        runner.nextPiece(board, pieces, 0, new HashSet<PositionedPiece>());
    }

    private Set<Set<PositionedPiece>> combinations = new HashSet<Set<PositionedPiece>>();

    private void nextPiece(Board board, PieceType[] pieceTypes, int pieceIndex, Set<PositionedPiece> combination) {
        if(board == null) {
            return;
        }
        if(pieceIndex == pieceTypes.length) {
            if(!combinations.contains(combination))
                System.out.println(board);
            combinations.add(combination);
            return ;
        }
        PieceType pieceType = pieceTypes[pieceIndex];
        Board tmpBoard;
        for(Position p : board.availablePositions()) {
            Piece piece = pieceType.createPiece(p);
            if(board.isInPosition(piece)) {
                continue;
            }
            tmpBoard = board.place(piece);
            Set<PositionedPiece> cmb = new HashSet<PositionedPiece>(combination);
            cmb.add(new PositionedPiece(pieceType, p));
            nextPiece(tmpBoard, pieceTypes, pieceIndex + 1, cmb);
        }
    }
}
