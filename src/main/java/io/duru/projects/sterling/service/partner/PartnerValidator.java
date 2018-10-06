package io.duru.projects.sterling.service.partner;

import io.duru.projects.sterling.exception.InvalidEntityException;
import io.duru.projects.sterling.model.Partner;
import io.duru.projects.sterling.repository.PartnerRepository;
import io.duru.projects.sterling.util.jpa.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * created by dduru on 27/09/2018
 */
@Service
public class PartnerValidator {

    @Autowired
    private PartnerRepository partnerRepository;


    public void validatePartner(Partner partner) throws InvalidEntityException {
        ValidatorUtil.validate(partner);
        validateNameAvailable(partner);
    }


    private void validateNameAvailable(Partner partner) throws InvalidEntityException {
        Optional<Partner> existingPartner = partnerRepository.findByName(partner.getName());

        if (existingPartner.isPresent() && !Objects.equals(existingPartner.get().getId(), partner.getId())) {
            throw new InvalidEntityException(String.format("Partner Name '%s' already in use", partner.getName()));
        }
    }



}