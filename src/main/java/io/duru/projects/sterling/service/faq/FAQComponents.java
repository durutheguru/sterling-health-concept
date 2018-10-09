package io.duru.projects.sterling.service.faq;

import io.duru.projects.sterling.repository.FAQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * created by dduru on 07/10/2018
 */
@Component
public class FAQComponents {

    @Autowired
    public FAQRepository faqRepository;


}