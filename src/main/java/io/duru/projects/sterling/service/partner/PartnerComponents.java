package io.duru.projects.sterling.service.partner;

import io.duru.projects.sterling.repository.LocationRepository;
import io.duru.projects.sterling.repository.PartnerRepository;
import io.duru.projects.sterling.repository.StateRepository;
import io.duru.projects.sterling.service.partner.impl.search.SearchTypeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * created by dduru on 27/09/2018
 */
@Component
public class PartnerComponents {

    @Autowired
    public PartnerRepository partnerRepository;

    @Autowired
    public PartnerValidator partnerValidator;

    @Autowired
    public StateRepository stateRepository;

    @Autowired
    public LocationRepository locationRepository;

    @Autowired
    public PartnerFileUploadExtractor fileUploadExtractor;

    @Autowired
    public List<SearchTypeHandler> searchTypeHandlers;

    public Random random = new Random(System.currentTimeMillis());

}