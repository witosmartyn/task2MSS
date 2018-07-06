package com.witosmartyn.app.board;

import com.witosmartyn.app.board.models.Board;
import com.witosmartyn.app.board.models.Cell;
import com.witosmartyn.app.board.models.Params;
import com.witosmartyn.app.config.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * vitali
 */
@Service
public class BoardService {
    private final Logger log = LoggerFactory.getLogger(BoardService.class);

    /**
     * @return @Board object
     */
    public Board generateBoard(final Params params) throws IllegalArgumentException {
        if (params.getSize() < 0) {
            throw new IllegalArgumentException("negative.number");
        }
        log.info("begin generate grid");

        int size = params.getSize();

        Cell grid[][] = new Cell[size][size];

        for (int x = 0; x < size; x++) {

            for (int y = 0; y < size; y++) {
                grid[x][y] = new Cell(getColor(y, x));
            }
        }
        log.info("end generate,Generated:"+grid.length*grid.length);
        final Board board = new Board(convertTo2Dlist(grid));
        makeDynamycCellSize(board.getCells().size());
        return board;
    }

    /**
     * Calculate cellSize for Cell in pixels
     */
    private void makeDynamycCellSize(int gridSize) {

        if (gridSize > 1 &gridSize<100000) {
            Cell.setCelSize(1000 / gridSize);
        } else {
            Cell.setCelSize(1000);

        }
    }

        /**
         * @param D2Array is array with nested array[]Cell
         * @return List with lists of Cell </>
         */
        private List<List<Cell>> convertTo2Dlist (Cell[][]D2Array){
            List<List<Cell>> list = Arrays.stream(D2Array)
                    .map(Arrays::asList)
                    .collect(Collectors.toList());
            return list;
        }

        /**
         * @param x cordinate
         * @param y cordinate
         * @return Enum color depending on the cell's coordinates
         */
        private Color getColor ( int y, int x){
            if (x % 2 == 1) {
                y++;
            }

            if (y % 2 == 0) {
                return Color.WHITE;
            }
            return Color.BLACK;
        }

    }
