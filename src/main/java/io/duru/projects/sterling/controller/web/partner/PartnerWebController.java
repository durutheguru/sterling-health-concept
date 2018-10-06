package io.duru.projects.sterling.controller.web.partner;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.duru.projects.sterling.apimodel.ApiContext;
import io.duru.projects.sterling.apimodel.partner.PartnerApiModel;
import io.duru.projects.sterling.exception.PartnerSetupException;
import io.duru.projects.sterling.model.Partner;
import io.duru.projects.sterling.service.partner.PartnerService;
import io.duru.projects.sterling.util.AppLogger;
import io.duru.projects.sterling.util.JSONUtil;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * created by dduru on 28/09/2018
 */
@Controller
@RequestMapping("/partner")
public class PartnerWebController {

    @Autowired
    private ApiContext context;

    @Autowired
    private PartnerService partnerService;


    @RequestMapping(method = RequestMethod.GET)
    public String viewPartners() {
        return "partner/index";
    }


    @RequestMapping(path = "/{id}" , method = RequestMethod.GET)
    public String showDetails(@PathVariable("id") Long partnerId, Model model) throws JsonProcessingException {
        Partner partner = partnerService.getPartner(partnerId);

        if (partner != null) {
            return showPartnerDetails(partner, model);
        }

        return "partner/index";
    }


    @RequestMapping(path = "/{id}/edit", method = RequestMethod.GET)
    public String showEditPartner(@PathVariable("id") Long partnerId, Model model) throws JsonProcessingException {
        Partner partner = partnerService.getPartner(partnerId);

        if (partner == null) {
            return viewPartners();
        }

        appendPartnerDataToModel(partner, model);

        return "partner/edit_details";
    }


    public String showPartnerDetails(Partner partner, Model model) throws JsonProcessingException {
        appendPartnerDataToModel(partner, model);
        return "partner/details";
    }


    private void appendPartnerDataToModel(Partner partner, Model model) throws JsonProcessingException {
        model.addAttribute("partner", new PartnerApiModel(partner, context));
        model.addAttribute("partnerJson", JSONUtil.stringify(Hibernate.unproxy(partner)));
    }

}
