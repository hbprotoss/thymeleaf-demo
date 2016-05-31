package io.hbprotoss.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hbprotoss on 5/31/16.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    private String index() {
        return "index";
    }
}
