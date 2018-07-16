package com.witosmartyn.app.board;

import static org.junit.Assert.*;
import com.witosmartyn.app.board.models.Board;
import com.witosmartyn.app.board.models.Cell;
import com.witosmartyn.app.board.models.Params;
import com.witosmartyn.app.config.Color;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.util.List;


/**
 * vitali
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardServiceImplTest {
    @Resource
    @Qualifier("boardServiceImpl")
    private IBoardService boardService;

    @Test(expected = IllegalArgumentException.class)
    public void mustThrowIllegalArgumentException() {
        final Params params = new Params();
        params.setSize(-1);
        boardService.generateBoard(params);
    }
    @Test
    public void testGenerateBoard() {
        final Params params = new Params();
        params.setSize(2);
        final Board board = boardService.generateBoard(params);
        final List<List<Cell>> cells = board.getCells();
        assertNotNull(board);
        assertNotNull(board.getCells());
        assertTrue(cells.size()==2);
        assertTrue(cells.get(0).size()==2);
        assertNotNull(cells.get(0).get(0).getColor());
        assertNotNull(cells.get(0).get(1).getColor());
        assertTrue(cells.get(0).get(0).getColor().equals(Color.BLACK));
        assertTrue(cells.get(0).get(1).getColor().equals(Color.WHITE));
    }
}
