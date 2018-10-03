package io.duru.projects.sterling.service.partner;

import io.duru.projects.sterling.apimodel.partner.SearchResult;
import io.duru.projects.sterling.apimodel.partner.UploadResult;
import io.duru.projects.sterling.exception.PartnerSetupException;
import io.duru.projects.sterling.model.Partner;
import io.duru.projects.sterling.service.partner.impl.SearchImpl;
import io.duru.projects.sterling.service.partner.impl.SetupImpl;
import io.duru.projects.sterling.service.partner.impl.UploadImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
        return SetupImpl.init(partner, components).execute();
    }


    public List<Partner> getPartners() {
        return components.partnerRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
    }


    public Partner getPartner(Long id) {
        return components.partnerRepository.getOne(id);
    }


    public SearchResult search(String key) {
        return SearchImpl.init(key, components).execute();
    }


    public UploadResult uploadPartners(MultipartFile multipartFile) throws PartnerSetupException {
        return UploadImpl.init(multipartFile, components).execute();
    }


}