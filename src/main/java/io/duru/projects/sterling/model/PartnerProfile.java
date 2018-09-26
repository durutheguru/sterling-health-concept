package io.duru.projects.sterling.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * created by dduru on 26/09/2018
 */
@Entity
public class PartnerProfile extends BaseEntity {

    @NotEmpty(message = "Partner Website is required")
    @Column(nullable = false, length = 250)
    @Size(max = 250, message = "Website is too long")
    private String website;

    @OneToOne(cascade = CascadeType.ALL)
    private Image logo1;

    @OneToOne(cascade = CascadeType.ALL)
    private Image logo2;

    @OneToOne(cascade = CascadeType.ALL)
    private Image banner;

    @Column(length = 200)
    @Size(max = 200, message = "Facebook Link too long")
    private String facebookLink;

    @Column(length = 200)
    @Size(max = 200, message = "Twitter Link too long")
    private String twitterLink;

    @Column(length = 200)
    @Size(max = 200, message = "LinkedIn Link too long")
    private String linkedInLink;

    @Column(nullable = false)
    private Integer viewCount = 0;

    private Integer likeCount = 0;


    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Image getLogo1() {
        return logo1;
    }

    public void setLogo1(Image logo1) {
        this.logo1 = logo1;
    }

    public Image getLogo2() {
        return logo2;
    }

    public void setLogo2(Image logo2) {
        this.logo2 = logo2;
    }

    public Image getBanner() {
        return banner;
    }

    public void setBanner(Image banner) {
        this.banner = banner;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getTwitterLink() {
        return twitterLink;
    }

    public void setTwitterLink(String twitterLink) {
        this.twitterLink = twitterLink;
    }

    public String getLinkedInLink() {
        return linkedInLink;
    }

    public void setLinkedInLink(String linkedInLink) {
        this.linkedInLink = linkedInLink;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }


}