package com.witosmartyn.app.board.models;

import com.witosmartyn.app.config.Color;

/**
 * vitali
 */
public class Cell {

    private final Color color;

    /**
     * @return Color own color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Constructor
     */
    public Cell(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.valueOf(color);
    }
}
