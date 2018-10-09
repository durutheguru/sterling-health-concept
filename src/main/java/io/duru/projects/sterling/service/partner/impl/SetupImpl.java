package io.duru.projects.sterling.service.partner.impl;

import io.duru.projects.sterling.exception.InvalidEntityException;
import io.duru.projects.sterling.exception.PartnerSetupException;
import io.duru.projects.sterling.model.Partner;
import io.duru.projects.sterling.model.State;
import io.duru.projects.sterling.service.partner.PartnerComponents;

import java.util.Optional;

/**
 * created by dduru on 27/09/2018
 */
public class SetupImpl {

    private Partner partner;

    private PartnerComponents components;


    private SetupImpl(Partner partner, PartnerComponents components) {
        this.partner = partner;
        this.components = components;
    }


    public static SetupImpl init(Partner partner, PartnerComponents components) {
        return new SetupImpl(partner, components);
    }


    public Partner execute() throws PartnerSetupException {
        validate();
        appendPartnerState();

        return savePartner();
    }


    private void validate() throws PartnerSetupException {
        try {
            components.partnerValidator.validatePartner(partner);
        }
        catch (InvalidEntityException e) {
            throw new PartnerSetupException(e.getMessage());
        }
    }


    private void appendPartnerState() throws PartnerSetupException {
        State state = partner.getPrimaryLocation().getState();
        Optional<State> existingState = components.stateRepository.findByNameContaining(state.getName());

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