package com.witosmartyn.app.board.models;

import com.witosmartyn.app.config.Color;

/**
 * vitali
 */
public class Cell {

    public Color getColor() {
        return color;
    }

    private final Color color;

    @Override
    public String toString() {
        return String.valueOf(color);
    }

    public Cell(Color color) {
        this.color = color;
    }
}
