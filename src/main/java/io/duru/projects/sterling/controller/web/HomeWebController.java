package io.duru.projects.sterling.controller.web;

import io.duru.projects.sterling.apimodel.ApiContext;
import io.duru.projects.sterling.apimodel.partner.PartnerApiModel;
import io.duru.projects.sterling.model.Partner;
import io.duru.projects.sterling.service.partner.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

/**
 * created by dduru on 12/10/2018
 */
@Controller
@RequestMapping(path = "/")
public class HomeWebController {

    @Autowired
    private ApiContext context;

    @Autowired
    private PartnerService partnerService;


    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        Optional<Partner> partner = partnerService.featuredPartner();

        if (partner.isPresent()) {
            model.addAttribute("featuredPartner", new PartnerApiModel(partner.get(), context));
        }

        return "index";
    }

}