package com.witosmartyn.app.board;

import com.witosmartyn.app.board.models.Board;
import com.witosmartyn.app.board.models.Cell;
import com.witosmartyn.app.board.models.Params;
import com.witosmartyn.app.config.Color;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * vitali
 */
@Service
public class BoardService   {
    public Board generateBoard(final Params params) {
        int size = params.getSize();

        Cell cells[][] = new Cell[size][size];

        for (int o = 0; o < size; o++) {

            for (int i = 0; i < size; i++) {
                cells[o][i] = new Cell(getColor(i, o));
                System.out.print(cells[o][i] + " ");
            }
        }

        final Board board = new Board(convertTo2Dlist(cells));
        return board;
    }

    private List<List<Cell>> convertTo2Dlist(Cell[][] D2Array) {
        List<List<Cell>> list = Arrays.stream(D2Array)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        return list;
    }

    private Color getColor(int i, int o) {
        if (o%2==1){
            i++;}

        if (i % 2 == 0 ) {
            return Color.WHITE;
        }
        return Color.BLACK;
    }

}
