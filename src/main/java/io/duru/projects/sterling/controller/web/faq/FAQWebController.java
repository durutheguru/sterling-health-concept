package io.duru.projects.sterling.controller.web.faq;

import io.duru.projects.sterling.exception.ApplicationException;
import io.duru.projects.sterling.exception.EntityPersistenceException;
import io.duru.projects.sterling.model.FAQ;
import io.duru.projects.sterling.service.faq.FAQService;
import io.duru.projects.sterling.util.AppLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * created by dduru on 08/10/2018
 */
@Controller
@RequestMapping("/faq")
public class FAQWebController {

    @Autowired
    private FAQService faqService;


    @RequestMapping(method = RequestMethod.GET)
    public String viewFAQs(Model model) {
        List<FAQ> faqs = faqService.loadFAQs();
        model.addAttribute("faqs", faqs);

        return "faq/index";
    }


    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String showAddFAQ(Model model) {
        model.addAttribute("faq", new FAQ());
        return "faq/add";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String addFAQ(FAQ faq) throws ApplicationException {
        try {
            faqService.saveFAQ(faq);
        }
        catch (EntityPersistenceException e) {
            AppLogger.error(e);
        }

        return "redirect:/faq";
    }


}