package io.duru.projects.sterling.controller.web.faq;

import io.duru.projects.sterling.model.FAQ;
import io.duru.projects.sterling.service.faq.FAQService;
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


}