package io.duru.projects.sterling.service.partner.impl.search;

import io.duru.projects.sterling.apimodel.partner.SearchResultGroup;
import io.duru.projects.sterling.model.Partner;
import io.duru.projects.sterling.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * created by dduru on 30/09/2018
 */

@Component
public class NameSearchHandler implements SearchTypeHandler {

    @Autowired
    private PartnerRepository partnerRepository;


    @Override
    public List<Partner> searchForList(String key) {
        return partnerRepository.findByNameContaining(key);
    }

    @Override
    public SearchResultGroup.Type supportedType() {
        return SearchResultGroup.Type.NAME;
    }


}