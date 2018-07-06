package com.witosmartyn.app.board;

import com.witosmartyn.app.board.models.Params;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * vitali
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ParamsValidatorTest {

    @Resource
    private ParamsValidator paramsValidator;

    @Test
    public void mustReturnTrue() {
        Params params = new Params();
        params.setSize(2);
        assertTrue(paramsValidator.isValid(params));
    }
    @Test
    public void mustReturnFalse() {
        Params params = new Params();
        params.setSize(1);
        assertFalse(paramsValidator.isValid(params));
       
    }
}
