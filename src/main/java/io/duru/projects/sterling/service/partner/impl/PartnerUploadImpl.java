package io.duru.projects.sterling.service.partner.impl;

import io.duru.projects.sterling.apimodel.UploadStatus;
import io.duru.projects.sterling.apimodel.partner.PartnerUploadResult;
import io.duru.projects.sterling.apimodel.partner.UploadedPartner;
import io.duru.projects.sterling.exception.ApplicationException;
import io.duru.projects.sterling.exception.PartnerSetupException;
import io.duru.projects.sterling.service.partner.Components;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * created by dduru on 27/09/2018
 */
public class PartnerUploadImpl {

    private MultipartFile multipartFile;

    private Components components;


    private PartnerUploadImpl(MultipartFile multipartFile, Components components) {
        this.multipartFile = multipartFile;
        this.components = components;
    }


    public static PartnerUploadImpl init(MultipartFile multipartFile, Components components) {
        return new PartnerUploadImpl(multipartFile, components);
    }


    public PartnerUploadResult execute() throws PartnerSetupException {
        try {
            List<UploadedPartner> uploadedPartners = components.fileUploadExtractor
                    .extractPartners(multipartFile.getInputStream());

            uploadedPartners.forEach(this::uploadPartner);

            return new PartnerUploadResult(uploadedPartners);
        }
        catch (IOException | InvalidFormatException e) {
            throw new PartnerSetupException("Unable to extract uploaded file", e);
        }
    }


    private void uploadPartner(UploadedPartner uploadedPartner) {
        try {
            components.partnerRepository.save(uploadedPartner.getPartner());

            uploadedPartner.setUploadStatus(UploadStatus.SUCCESSFUL);
            uploadedPartner.setUploadMessage("Setup was successful");
        }
        catch (Exception e) {
            uploadedPartner.setUploadStatus(UploadStatus.FAILED);
            uploadedPartner.setUploadMessage(e.getMessage());
        }
    }


}