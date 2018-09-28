package io.duru.projects.sterling.controller.web.partner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * created by dduru on 28/09/2018
 */
@Controller
@RequestMapping("/partner")
public class PartnerWebController {


    @RequestMapping(method = RequestMethod.GET)
    public String viewPartners() {
        return "partner/index";
    }


}
