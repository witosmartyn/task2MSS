package com.witosmartyn.app.board;

import com.witosmartyn.app.board.models.Params;
import org.springframework.stereotype.Component;

/**
 * vitali
 */
@Component
public class ParamsValidator {
    /**
     * @return true if  @params.size is positive number & great than 1
     */
    public boolean isValid(Params params){
            return params.getSize() > 1 & params.getSize()<40;
    }

}
