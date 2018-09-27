package io.duru.projects.sterling.apimodel.partner;

import io.duru.projects.sterling.apimodel.UploadStatus;
import io.duru.projects.sterling.model.Partner;

/**
 * created by dduru on 27/09/2018
 */
public class UploadedPartner {

    private Partner partner;

    private Integer lineNumber;

    private UploadStatus uploadStatus;

    private String uploadMessage;


    public UploadedPartner(Partner partner, Integer lineNumber) {
        this.partner = partner;
        this.lineNumber = lineNumber;
    }

    public Partner getPartner() {
        return partner;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public UploadStatus getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(UploadStatus uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    public String getUploadMessage() {
        return uploadMessage;
    }

    public void setUploadMessage(String uploadMessage) {
        this.uploadMessage = uploadMessage;
    }


}