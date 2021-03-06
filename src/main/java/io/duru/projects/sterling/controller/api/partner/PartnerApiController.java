package io.duru.projects.sterling.controller.api.partner;

import io.duru.projects.sterling.apimodel.partner.SearchResult;
import io.duru.projects.sterling.apimodel.partner.UploadResult;
import io.duru.projects.sterling.exception.ApplicationException;
import io.duru.projects.sterling.model.Partner;
import io.duru.projects.sterling.service.partner.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * created by dduru on 28/09/2018
 */
@RestController
@RequestMapping(path = "/api/v1/partner")
public class PartnerApiController {

    private PartnerService partnerService;


    @Autowired
    public PartnerApiController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Partner> getPartners() {
        return partnerService.getPartners();
    }


    @RequestMapping(method = RequestMethod.POST)
    public Partner savePartner(@RequestBody Partner partner) throws ApplicationException {
        return partnerService.savePartner(partner);
    }


    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public UploadResult uploadPartners(
            @RequestParam("file") MultipartFile multipartFile) throws ApplicationException {
        return partnerService.uploadPartners(multipartFile);
    }


    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public SearchResult searchPartners(@RequestParam("key") String key) {
        return partnerService.search(key);
    }


    @RequestMapping(method = RequestMethod.PUT)
    public Partner updatePartner(@RequestBody Partner partner) throws ApplicationException {
        return partnerService.savePartner(partner);
    }


}