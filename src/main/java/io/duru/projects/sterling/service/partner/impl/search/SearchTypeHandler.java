package io.duru.projects.sterling.service.partner.impl.search;

import io.duru.projects.sterling.apimodel.partner.SearchResultGroup;
import io.duru.projects.sterling.model.Partner;

import java.util.List;

/**
 * created by dduru on 30/09/2018
 */
public interface SearchTypeHandler {

    default SearchResultGroup search(String key) {
        List<Partner> partners = searchForList(key);
        return new SearchResultGroup(key, supportedType(), partners);
    }

    List<Partner> searchForList(String key);

    SearchResultGroup.Type supportedType();

}



