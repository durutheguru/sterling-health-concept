package io.duru.projects.sterling.service.partner;

import io.duru.projects.sterling.model.Location;
import io.duru.projects.sterling.model.Partner;
import io.duru.projects.sterling.model.PartnerProfile;
import io.duru.projects.sterling.model.State;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * created by dduru on 27/09/2018
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PartnerServiceTest {

    @Autowired
    private PartnerService partnerService;


    @Test
    public void test_adding_new_partner() throws Exception {
        partnerService.savePartner(buildNewPartner());
    }


    private Partner buildNewPartner() {
        Partner partner = new Partner();

        partner.setName("New Partner");
        partner.setDescription("Basic New Partner");
        partner.setPrimaryLocation(buildNewLocation());
        partner.setPartnerProfile(buildNewPartnerProfile());

        return partner;
    }


    private Location buildNewLocation() {
        Location location = new Location();

        location.setAddress("12, Middleware Street, Lagos");
        location.setEmail("partner@gmail.com");
        location.setPhoneNumber1("0813893343");
        location.setState(buildNewState());

        return location;
    }


    private State buildNewState() {
        State state = new State();

        state.setName("Lagos State");

        return state;
    }


    private PartnerProfile buildNewPartnerProfile() {
        PartnerProfile partnerProfile = new PartnerProfile();

        partnerProfile.setWebsite("http://partner.com");
        partnerProfile.setFacebookLink("http://www.facebook.com/partner1");
        partnerProfile.setTwitterLink("http://www.twitter.com/partner1");

        return partnerProfile;
    }

}