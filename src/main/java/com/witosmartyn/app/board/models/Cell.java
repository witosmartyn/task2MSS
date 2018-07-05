package com.witosmartyn.app.board.models;

import com.witosmartyn.app.config.Color;

/**
 * vitali
 */
public class Cell {

    private final Color color;
    private static double celSize;

    public static double getCelSize() {
        return celSize;
    }

    public static void setCelSize(double celSize) {
        Cell.celSize = celSize;
    }

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
