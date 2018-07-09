package com.witosmartyn.app.board;

import com.witosmartyn.app.board.models.Board;
import com.witosmartyn.app.board.models.Params;

/**
 * vitali
 */
public interface IBoardService {
    Board generateBoard(Params params) throws IllegalArgumentException;
}
