package com.witosmartyn.app.board;

import com.witosmartyn.app.board.models.Board;
import com.witosmartyn.app.board.models.Cell;
import com.witosmartyn.app.board.models.Params;
import com.witosmartyn.app.config.Color;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * vitali
 */
@Service
public class BoardService   {
    /**
     * @return @Board object
     */
    public Board generateBoard(final Params params)  throws IllegalArgumentException {
        if (params.getSize() < 0){
            throw new IllegalArgumentException("negative.number");
        }

        int size = params.getSize();

        Cell grid[][] = new Cell[size][size];

        for (int x = 0; x < size; x++) {

            for (int y = 0; y < size; y++) {
                grid[x][y] = new Cell(getColor(y, x));
                System.out.print(grid[x][y] + " ");
            }
        }

        final Board board = new Board(convertTo2Dlist(grid));
        return board;
    }

    /**
     *
     * @param D2Array is array with nested array[]Cell
     * @return List with lists of Cell </>
     */
    private List<List<Cell>> convertTo2Dlist(Cell[][] D2Array) {
        List<List<Cell>> list = Arrays.stream(D2Array)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        return list;
    }

    /**
     * @return Enum color depending on the cell's coordinates
     * @param x cordinate
     * @param y cordinate
     */
    private Color getColor(int y, int x) {
        if (x%2==1){
            y++;}

        if (y % 2 == 0 ) {
            return Color.WHITE;
        }
        return Color.BLACK;
    }

}
