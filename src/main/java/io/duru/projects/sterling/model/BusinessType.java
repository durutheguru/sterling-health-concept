package io.duru.projects.sterling.model;

/**
 * created by dduru on 04/10/2018
 */
public enum BusinessType {

    MEDICAL_EQUIPMENT("Medical Equipment"),

    PHARMACEUTICAL("Pharmaceutical"),

    HOSPITAL_MANAGEMENT("Hospital Management");


    BusinessType(String description) {
        this.description = description;
    }

    public String description;


}