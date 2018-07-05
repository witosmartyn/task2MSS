package com.witosmartyn.app.board;

import com.witosmartyn.app.board.models.Params;
import org.springframework.stereotype.Component;

/**
 * vitali
 */
@Component
public class ParamsValidator {
    public boolean isValid(Params params) {
        boolean r = params.getSize() >= 0;
        return r;
    }

}
