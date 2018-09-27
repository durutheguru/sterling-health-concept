package io.duru.projects.sterling.service.partner.impl;

import io.duru.projects.sterling.exception.InvalidEntityException;
import io.duru.projects.sterling.exception.PartnerSetupException;
import io.duru.projects.sterling.model.Partner;
import io.duru.projects.sterling.model.State;
import io.duru.projects.sterling.service.partner.ComponentAggregator;

import java.util.Optional;

/**
 * created by dduru on 27/09/2018
 */
public class PartnerSetupImpl {

    private Partner partner;

    private ComponentAggregator components;


    private PartnerSetupImpl(Partner partner, ComponentAggregator components) {
        this.partner = partner;
        this.components = components;
    }


    public static PartnerSetupImpl init(Partner partner, ComponentAggregator components) {
        return new PartnerSetupImpl(partner, components);
    }


    public Partner execute() throws PartnerSetupException {
        validate();
        appendPartnerState();

        return savePartner();
    }


    private void validate() throws PartnerSetupException {
        try {
            components.partnerValidator.validateNewPartner(partner);
        }
        catch (InvalidEntityException e) {
            throw new PartnerSetupException(e.getMessage());
        }
    }


    private void appendPartnerState() throws PartnerSetupException {
        State state = partner.getPrimaryLocation().getState();
        Optional<State> existingState = components.stateRepository.findByName(state.getName());

        if (existingState.isPresent()) {
            partner.getPrimaryLocation().setState(existingState.get());
        }
        else {
            throw new PartnerSetupException(String.format("State of Location '%s' not found", state.getName()));
        }
    }


    private Partner savePartner() {
        return components.partnerRepository.save(partner);
    }


}