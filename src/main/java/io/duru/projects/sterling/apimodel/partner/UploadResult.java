package io.duru.projects.sterling.apimodel.partner;

import io.duru.projects.sterling.apimodel.UploadStatus;

import java.util.List;
import java.util.stream.Collectors;

/**
 * created by dduru on 27/09/2018
 */
public class UploadResult {

    private List<UploadedPartner> successfulUploads;

    private List<UploadedPartner> failedUploads;


    public UploadResult(List<UploadedPartner> uploadedPartners) {
        init(uploadedPartners);
    }


    private void init(List<UploadedPartner> uploadedPartners) {
        successfulUploads = uploadedPartners.stream()
                .filter(u -> u.getUploadStatus() == UploadStatus.SUCCESSFUL)
                .collect(Collectors.toList());

        failedUploads = uploadedPartners.stream()
                .filter(u -> u.getUploadStatus() == UploadStatus.FAILED)
                .collect(Collectors.toList());
    }


    public List<UploadedPartner> getSuccessfulUploads() {
        return successfulUploads;
    }


    public List<UploadedPartner> getFailedUploads() {
        return failedUploads;
    }


}