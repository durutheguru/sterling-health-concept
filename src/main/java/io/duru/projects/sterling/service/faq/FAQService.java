package io.duru.projects.sterling.service.faq;

import io.duru.projects.sterling.exception.EntityPersistenceException;
import io.duru.projects.sterling.model.FAQ;
import io.duru.projects.sterling.service.faq.impl.AddImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by dduru on 07/10/2018
 */
@Service
public class FAQService {

    @Autowired
    private FAQComponents components;


    public FAQ saveFAQ(FAQ faq) throws EntityPersistenceException {
        return AddImpl.init(faq, components).execute();
    }


    public List<FAQ> loadFAQs() {
        return components.faqRepository.findAll();
    }


}

