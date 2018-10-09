package io.duru.projects.sterling.service.partner.impl;

import com.google.common.base.Strings;
import io.duru.projects.sterling.apimodel.partner.SearchResult;
import io.duru.projects.sterling.apimodel.partner.SearchResultGroup;
import io.duru.projects.sterling.service.partner.PartnerComponents;

import java.util.List;
import java.util.stream.Collectors;

/**
 * created by dduru on 30/09/2018
 */
public class SearchImpl {

    private String key;

    private PartnerComponents components;


    private SearchImpl(String key, PartnerComponents components) {
        this.key = key;
        this.components = components;
    }


    public static SearchImpl init(String key, PartnerComponents components) {
        return new SearchImpl(key, components);
    }


    public SearchResult execute() {
        if (Strings.isNullOrEmpty(key)) {
            return SearchResult.empty(key);
        }

        List<SearchResultGroup> resultGroups = components.searchTypeHandlers
                .stream()
                .map(handler -> handler.search(key))
                .filter(searchResultGroup -> !searchResultGroup.isEmpty())
                .collect(Collectors.toList());

        return new SearchResult(key, resultGroups);
    }



}