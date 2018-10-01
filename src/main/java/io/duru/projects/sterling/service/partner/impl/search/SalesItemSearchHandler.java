package io.duru.projects.sterling.service.partner.impl.search;

import io.duru.projects.sterling.apimodel.partner.SearchResultGroup;
import io.duru.projects.sterling.model.Partner;
import io.duru.projects.sterling.model.SalesItem;
import io.duru.projects.sterling.repository.SalesItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * created by dduru on 30/09/2018
 */
@Component
public class SalesItemSearchHandler implements SearchTypeHandler {

    @Autowired
    private SalesItemRepository salesItemRepository;


    @Override
    public List<Partner> searchForList(String key) {
        List<SalesItem> salesItemList = salesItemRepository.findByDescriptionContaining(key);
        return salesItemList.stream().map(SalesItem::getPartner).collect(Collectors.toList());
    }


    @Override
    public SearchResultGroup.Type supportedType() {
        return SearchResultGroup.Type.SALES_ITEM;
    }


}