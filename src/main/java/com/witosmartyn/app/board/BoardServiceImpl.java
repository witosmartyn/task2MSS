package com.witosmartyn.app.board;

import com.witosmartyn.app.board.models.Board;
import com.witosmartyn.app.board.models.Cell;
import com.witosmartyn.app.board.models.Params;
import com.witosmartyn.app.config.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * vitali
 */
@Service
public class BoardServiceImpl implements IBoardService {

    /**
     * Cell Size Koefficient
     */
    private static final Integer KOEF = 1000;

    private final Logger log = LoggerFactory.getLogger(IBoardService.class);

    /**
     * @return generated @Board with cellGrid
     * @throws IllegalArgumentException if params.getSize()returned negative number
     */
    @Override
    public Board generateBoard(@NotNull final Params params) throws IllegalArgumentException {
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
        log.info("end generate,Generated:" + grid.length * grid.length + "cells");

        final List<List<Cell>> cells = convertTo2Dlist(grid);
        final Board board = new Board(cells);
        board.setCelSize(makeDynamicCellSize(cells.size()));
        return board;
    }


    /**
     * Calculate cellSize for Cell in pixels depend of gridSize
     */
    private int makeDynamicCellSize(int gridSize) {
        if (gridSize > 1 & gridSize < KOEF * 100) {
            return KOEF / gridSize;
        } else {
            return KOEF;
        }
    }

    /**
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
     * @param x cordinate
     * @param y cordinate
     * @return Enum color depending on the cell's coordinates
     */
    private Color getColor(int y, int x) {
        if (x % 2 == 1) {
            y++;
        }
        if (y % 2 == 0) {
            return Color.WHITE;
        }
        return Color.BLACK;
    }

}
