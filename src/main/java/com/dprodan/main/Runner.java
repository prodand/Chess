package com.dprodan.main;

import com.dprodan.entities.Combination;
import com.dprodan.entities.Position;
import com.dprodan.entities.PositionedPiece;
import com.dprodan.pieces.Piece;
import com.dprodan.pieces.PieceType;

import java.util.*;

public class Runner {

    private Set<Combination> visited = new HashSet<>();
    private PieceType[] pieceTypes;
    private List<Board> boards = new LinkedList<>();

    public Runner(PieceType[] pieceTypes) {
        this.pieceTypes = pieceTypes;
    }

    public void nextPiece(Board board, int pieceIndex, Combination.CombinationBuilder builder, Set<Position> positions) {
        if(pieceIndex == pieceTypes.length) {
            boards.add(board);
            return ;
        }
        PieceType pieceType = pieceTypes[pieceIndex];
        Board tmpBoard;
        for(Position p : positions) {
            Piece piece = pieceType.createPiece(p);
            if(board.isInPosition(piece)) {
                continue;
            }
            Combination.CombinationBuilder clonedBuilder = builder.clone();
            clonedBuilder.add(new PositionedPiece(pieceType, p));
            Combination cmb = clonedBuilder.build();
            if(visited.contains(cmb)) {
                continue;
            }
            visited.add(cmb);
            tmpBoard = board.place(piece);
            nextPiece(tmpBoard, pieceIndex + 1, clonedBuilder, tmpBoard.availablePositions());
        }
    }

    public List<Board> getResult() {
        return boards;
    }
}
