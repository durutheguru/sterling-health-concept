package io.duru.projects.sterling.service.partner.impl.search;

import io.duru.projects.sterling.apimodel.partner.SearchResultGroup;
import io.duru.projects.sterling.model.Location;
import io.duru.projects.sterling.model.Partner;
import io.duru.projects.sterling.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * created by dduru on 30/09/2018
 */
@Component
public class LocationSearchHandler implements SearchTypeHandler {

    @Autowired
    private LocationRepository locationRepository;


    @Override
    public List<Partner> searchForList(String key) {
        List<Location> locations = new ArrayList<>();

        locations.addAll(locationRepository.findByAddressContaining(key));
        locations.addAll(locationRepository.findByState_NameContaining(key));

        return locations.stream().map(Location::getPartner).collect(Collectors.toList());
    }

    @Override
    public SearchResultGroup.Type supportedType() {
        return SearchResultGroup.Type.LOCATION;
    }


}