package io.duru.projects.sterling.apimodel.partner;

import java.util.ArrayList;
import java.util.List;

/**
 * created by dduru on 30/09/2018
 */
public class SearchResult {

    public final String key;

    public final List<SearchResultGroup> searchResultGroups;

    public int count;


    public SearchResult(String key, List<SearchResultGroup> searchResultGroups) {
        this.key = key;
        this.searchResultGroups = searchResultGroups;
        computeCount();
    }


    private void computeCount() {
        count = 0;
        for (SearchResultGroup group : searchResultGroups) {
            count += group.getCount();
        }
    }


    public boolean isEmpty() {
        return count == 0;
    }


    public static SearchResult empty(String key) {
        return new SearchResult(key, new ArrayList<>());
    }


}
