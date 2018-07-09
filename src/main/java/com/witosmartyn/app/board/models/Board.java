package com.witosmartyn.app.board.models;


import java.util.List;

/**
 * vitali
 */

public class Board {

    private final List<List<Cell>> cells;

    private int celSize ;

    public int getCelSize() {
        return celSize;
    }

    public void setCelSize(int celSize) {
        this.celSize = celSize;
    }

    public Board(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }




}
