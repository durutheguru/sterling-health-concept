package io.duru.projects.sterling.apimodel.partner;

import io.duru.projects.sterling.model.Partner;

import java.util.List;

/**
 * created by dduru on 30/09/2018
 */
public class SearchResultGroup {

    public final String key;

    public final Type type;

    public final List<Partner> partners;

    private int count;


    public SearchResultGroup(String key, Type type, List<Partner> partners) {
        this.key = key;
        this.type = type;
        this.partners = partners;
        this.count = partners.size();
    }


    public int getCount() {
        return count;
    }


    public boolean isEmpty() {
        return count == 0;
    }


    public String getDescription() {
        return String.format("Partners %s '%s'", type.sentenceValue, key);
    }


    public enum Type {

        NAME("with Name matching"),

        DESCRIPTION("with Description matching"),

        LOCATION("with a Location matching"),

        SALES_ITEM("Selling Items matching"),

        SERVICE("Providing a Service matching");

        public String sentenceValue;

        Type(String sentenceValue) {
            this.sentenceValue = sentenceValue;
        }

    }

}