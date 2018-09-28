package io.duru.projects.sterling.service.partner;

import io.duru.projects.sterling.apimodel.partner.PartnerUploadResult;
import io.duru.projects.sterling.exception.PartnerSetupException;
import io.duru.projects.sterling.model.Partner;
import io.duru.projects.sterling.service.partner.impl.PartnerSetupImpl;
import io.duru.projects.sterling.service.partner.impl.PartnerUploadImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * created by dduru on 27/09/2018
 */
@Service
public class PartnerService {

    @Autowired
    private Components components;


    public Partner savePartner(Partner partner) throws PartnerSetupException {
        return PartnerSetupImpl.init(partner, components).execute();
    }


    public List<Partner> getPartners() {
        return components.partnerRepository.findAll();
    }


    public PartnerUploadResult uploadPartners(MultipartFile multipartFile) throws PartnerSetupException {
        return PartnerUploadImpl.init(multipartFile, components).execute();
    }


}