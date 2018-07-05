package com.witosmartyn.app.board;

import com.witosmartyn.app.board.models.Board;
import com.witosmartyn.app.board.models.Params;
import org.springframework.stereotype.Service;

/**
 * vitali
 */
@Service
public interface BoardService {

    Board generateBoard(Params dto);
}
