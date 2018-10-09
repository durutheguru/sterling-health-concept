package io.duru.projects.sterling.service.faq.impl;

import io.duru.projects.sterling.exception.EntityPersistenceException;
import io.duru.projects.sterling.model.FAQ;
import io.duru.projects.sterling.service.faq.FAQComponents;

import java.util.Optional;

/**
 * created by dduru on 07/10/2018
 */
public class AddImpl {

    private FAQ faq;

    private FAQComponents components;


    private AddImpl(FAQ faq, FAQComponents components) {
        this.faq = faq;
        this.components = components;
    }


    public static AddImpl init(FAQ faq, FAQComponents components) {
        return new AddImpl(faq, components);
    }


    public FAQ execute() throws EntityPersistenceException {
        Optional<FAQ> existing = components.faqRepository.findByQuestion(faq.getQuestion());

        if (existing.isPresent()) {
            throw new EntityPersistenceException("Question has already been saved");
        }

        return components.faqRepository.save(faq);
    }


}