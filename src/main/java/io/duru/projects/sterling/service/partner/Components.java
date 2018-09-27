package io.duru.projects.sterling.service.partner;

import io.duru.projects.sterling.repository.LocationRepository;
import io.duru.projects.sterling.repository.PartnerRepository;
import io.duru.projects.sterling.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * created by dduru on 27/09/2018
 */
@Component
public class Components {

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

}