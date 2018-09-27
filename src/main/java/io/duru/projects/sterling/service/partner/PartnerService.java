package io.duru.projects.sterling.service.partner;

import io.duru.projects.sterling.exception.PartnerSetupException;
import io.duru.projects.sterling.model.Partner;
import io.duru.projects.sterling.service.partner.impl.PartnerSetupImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by dduru on 27/09/2018
 */
@Service
public class PartnerService {

    @Autowired
    private ComponentAggregator components;


    public Partner savePartner(Partner partner) throws PartnerSetupException {
        return PartnerSetupImpl.init(partner, components).execute();
    }


}