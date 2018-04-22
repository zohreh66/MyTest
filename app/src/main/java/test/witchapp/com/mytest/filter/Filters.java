package test.witchapp.com.mytest.filter;



import com.google.gson.annotations.Expose;

import java.util.List;


public class Filters {

    // Values parsed from API
    @Expose
    protected List<FilterType> filters;

    public Filters() {
    }

    public Filters(List<FilterType> filters) {
        this.filters = filters;
    }

    public List<FilterType> getFilters() {
        return filters;
    }

    public void setFilters(List<FilterType> filters) {
        this.filters = filters;
    }
}