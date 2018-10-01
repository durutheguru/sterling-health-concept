package io.duru.projects.sterling.service.partner.impl.search;

import io.duru.projects.sterling.apimodel.partner.SearchResultGroup;
import io.duru.projects.sterling.model.Partner;
import io.duru.projects.sterling.model.Service;
import io.duru.projects.sterling.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * created by dduru on 30/09/2018
 */
@Component
public class ServiceSearchHandler implements SearchTypeHandler {

    @Autowired
    private ServiceRepository serviceRepository;


    @Override
    public List<Partner> searchForList(String key) {
        List<Service> services = serviceRepository.findByDescriptionContaining(key);
        return services.stream().map(Service::getPartner).collect(Collectors.toList());
    }


    @Override
    public SearchResultGroup.Type supportedType() {
        return SearchResultGroup.Type.SERVICE;
    }


}