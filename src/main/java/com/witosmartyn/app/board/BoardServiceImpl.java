package com.witosmartyn.app.board;

import com.witosmartyn.app.board.models.Board;
import com.witosmartyn.app.board.models.Cell;
import com.witosmartyn.app.board.models.Params;
import com.witosmartyn.app.config.Color;
import org.springframework.stereotype.Service;


/**
 * vitali
 */
@Service
public class BoardServiceImpl implements BoardService {
    @Override
    public Board generateBoard(final Params params) {
        int size = params.getSize();

        Cell cells[][] = new Cell[size][size];

        for (int o = 0; o < size; o++) {

            for (int i = 0; i < size; i++) {
                cells[o][i] = new Cell(getColor(i, o));
                System.out.print(cells[o][i] + " ");
            }
        }

        final Board board = new Board(cells);
        return board;
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
