package io.duru.projects.sterling.service.partner.impl;

import io.duru.projects.sterling.apimodel.UploadStatus;
import io.duru.projects.sterling.apimodel.partner.UploadResult;
import io.duru.projects.sterling.apimodel.partner.UploadedPartner;
import io.duru.projects.sterling.exception.InvalidFileUploadException;
import io.duru.projects.sterling.exception.PartnerSetupException;
import io.duru.projects.sterling.service.partner.Components;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * created by dduru on 27/09/2018
 */
public class UploadImpl {

    private MultipartFile multipartFile;

    private Components components;


    private UploadImpl(MultipartFile multipartFile, Components components) {
        this.multipartFile = multipartFile;
        this.components = components;
    }


    public static UploadImpl init(MultipartFile multipartFile, Components components) {
        return new UploadImpl(multipartFile, components);
    }


    public UploadResult execute() throws PartnerSetupException {
        try {
            List<UploadedPartner> uploadedPartners = components.fileUploadExtractor
                    .extractPartners(multipartFile.getInputStream());

            uploadedPartners.forEach(this::uploadPartner);

            return new UploadResult(uploadedPartners);
        }
        catch (IOException e) {
            throw new PartnerSetupException("Unable to extract uploaded file", e);
        }
        catch (InvalidFileUploadException e) {
            throw new PartnerSetupException(e.getMessage(), e);
        }
    }


    private void uploadPartner(UploadedPartner uploadedPartner) {
        try {
            SetupImpl.init(uploadedPartner.getPartner(), components).execute();

            uploadedPartner.setUploadStatus(UploadStatus.SUCCESSFUL);
            uploadedPartner.setUploadMessage("Setup was successful");
        }
        catch (Exception e) {
            uploadedPartner.setUploadStatus(UploadStatus.FAILED);
            uploadedPartner.setUploadMessage(e.getMessage());
        }
    }


}