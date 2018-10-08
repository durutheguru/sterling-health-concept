package io.duru.projects.sterling.service.faq.impl;

import io.duru.projects.sterling.exception.EntityPersistenceException;
import io.duru.projects.sterling.model.FAQ;
import io.duru.projects.sterling.service.faq.Components;

import java.util.Optional;

/**
 * created by dduru on 07/10/2018
 */
public class AddImpl {

    private FAQ faq;

    private Components components;


    private AddImpl(FAQ faq, Components components) {
        this.faq = faq;
        this.components = components;
    }


    public AddImpl init(FAQ faq, Components components) {
        return new AddImpl(faq, components);
    }


    public FAQ execute() throws EntityPersistenceException {
        Optional<FAQ> existing = components.faqRepository.findByQuestion(faq.getQuestion());

        if (existing.isPresent()) {

        }
    }


}