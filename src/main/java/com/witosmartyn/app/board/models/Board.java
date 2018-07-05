package com.witosmartyn.app.board.models;


/**
 * vitali
 */

public class Board {

    public Cell[][] getCells() {
        return cells;
    }

    private final Cell[][] cells;

    public Board(Cell[][] cells) {
        this.cells = cells;
    }
}
