package com.witosmartyn.app.board;

import com.witosmartyn.app.board.models.Params;
import com.witosmartyn.app.config.Constants;
import com.witosmartyn.app.config.Pages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * vitali
 */
@Controller
public class BoardController {
    private final Logger log = LoggerFactory.getLogger(BoardController.class);
    private IBoardService boardService;
    private ParamsValidator paramsValidator;
    private List<Character> alphabet = Constants.ALPHABET.chars().mapToObj(c-> (char)c).collect(Collectors.toList());
    private List<String> alphabetStr = Arrays.asList(new String[]{"JAVA", "PHP", "C++", "JS", "Python"});

    @Resource
    public void setParamsValidator(ParamsValidator paramsValidator) {
        this.paramsValidator = paramsValidator;
    }

    @Resource
    public void setService(IBoardService boardService) {
        this.boardService = boardService;
    }

    /**
     * @return The  instance object that wraps the parameters
     */
    @ModelAttribute(value = "params")
    public Params newParams() {
        final Params params = new Params();
        params.setSize(8);
        return params;

    }

    /**
     * @return View page
     */
    @GetMapping("/")
    public String showIndex() {
        return Pages.FORM;
    }

    /**
     * @param params The object that wraps the parameters
     *               Retrieves Query Parameters and
     *               Passes its to the BoardService
     *               and receive Board with cells
     *               Puts result to model
     * @return view page
     */
    @PostMapping("/")
    public String postSize(@ModelAttribute("params") Params params, BindingResult bindRes, Model model) {
        log.info("size:" + params.getSize());

        if (bindRes.hasErrors() || !paramsValidator.isValid(params)) {
            model.addAttribute("errorMessage", true);
            return Pages.FORM;
        }

//        model.addAttribute("alphabet", alphabetStr);
        model.addAttribute("alphabet", alphabet);

        model.addAttribute(Constants.BOARD, boardService.generateBoard(params));
        return Pages.BOARD;
    }
}
