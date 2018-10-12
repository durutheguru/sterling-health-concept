package io.duru.projects.sterling.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by dduru on 12/10/2018
 */
@Controller
@RequestMapping(path = "/")
public class HomeWebController {

    public String home() {
        return "index";
    }

}