package com.witosmartyn.app.board;

import com.witosmartyn.app.board.models.Params;
import com.witosmartyn.app.config.Constants;
import com.witosmartyn.app.config.Pages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;


/**
 * vitali
 */
@Controller
public class BoardController {
    private final Logger log = LoggerFactory.getLogger(BoardController.class);
    private BoardService boardService;
    private ParamsValidator paramsValidator;

    @Resource
    public void setParamsValidator(ParamsValidator paramsValidator) {
        this.paramsValidator = paramsValidator;
    }

    @Resource
    public void setService( BoardService boardService) {
        this.boardService = boardService;
    }

    @ModelAttribute(value = "params")
    public Params newParams(){
        return new Params();
    }

    @GetMapping("/")
    public String showIndex(Model model) {
        return Pages.FORM;
    }

    @PostMapping("/")
    public String postSize(/*@Valid */@ModelAttribute("params") Params params, BindingResult bindRes, Model model) {
        log.info("size:" + params.getSize());

        if(bindRes.hasErrors() || !paramsValidator.isValid(params)){
            model.addAttribute("errorMessage",true);
            return Pages.FORM;
        }

        model.addAttribute(Constants.BOARD, boardService.generateBoard(params));
        model.addAttribute("test", params);
        return Pages.BOARD;
    }
}
