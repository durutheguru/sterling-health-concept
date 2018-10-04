package io.duru.projects.sterling.apimodel.partner;

import io.duru.projects.sterling.apimodel.ApiContext;
import io.duru.projects.sterling.model.Image;
import io.duru.projects.sterling.model.Partner;
import io.duru.projects.sterling.model.PartnerProfile;
import org.springframework.beans.BeanUtils;

/**
 * created by dduru on 03/10/2018
 */
public class PartnerApiModel extends Partner {

    private ApiContext context;


    public PartnerApiModel(Partner partner, ApiContext context) {
        BeanUtils.copyProperties(partner, this);
        this.context = context;
    }

    public String getLogo1Url() {
        if (!hasPrimaryLogo()) {
            return context.defaultLogoUrl;
        }

        PartnerProfile profile = getPartnerProfile();
        Image logoImage = profile.getLogo1();

        return String.format("%s%s%s", context.webRootUrl, "/api/v1/img/", logoImage.getUid());
    }


    private boolean hasPrimaryLogo() {
        PartnerProfile profile = getPartnerProfile();
        return profile != null && profile.getLogo1() != null;
    }

}