package io.duru.projects.sterling.controller.web.partner;

import io.duru.projects.sterling.model.Partner;
import io.duru.projects.sterling.service.partner.PartnerService;
import io.duru.projects.sterling.util.AppLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * created by dduru on 28/09/2018
 */
@Controller
@RequestMapping("/partner")
public class PartnerWebController {

    @Autowired
    private PartnerService partnerService;


    @RequestMapping(method = RequestMethod.GET)
    public String viewPartners() {
        return "partner/index";
    }


    @RequestMapping(path = "/{id}" , method = RequestMethod.GET)
    public String showDetails(@PathVariable("id") Long partnerId, Model model) {
        Partner partner = partnerService.getPartner(partnerId);

        if (partner != null) {
            model.addAttribute("partner", partner);
            return "partner/details";
        }

        return "partner/index";
    }


}
