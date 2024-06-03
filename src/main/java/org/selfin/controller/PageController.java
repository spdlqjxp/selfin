package org.selfin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping(value = "/{path:[^\\.]*}", method = GET)
    public String forward(HttpServletRequest request) {
        return "forward:/index.html";
    }
}
