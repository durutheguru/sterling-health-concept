package io.duru.projects.sterling.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * created by dduru on 26/09/2018
 */
@Entity
public class Image extends BaseEntity {

    @NotEmpty
    @Column(nullable = false, unique = true)
    private String uid;

    @NotEmpty
    @Column(columnDefinition = "TEXT NOT NULL")
    private String path;

    @NotNull
    @Column(nullable = false)
    private Double aspectRatio;

    @Transient
    private String base64;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Double getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(Double aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }


}