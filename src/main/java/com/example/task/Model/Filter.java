package com.example.task.Model;

public class Filter {
    private String filterName;

    private String additionalParameter;

    public Filter(){}

    public Filter(String filterName, String additionalParameters) {
        this.filterName = filterName;
        this.additionalParameter = additionalParameters;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public String getAdditionalParameter() {
        return additionalParameter;
    }

    public void setAdditionalParameter(String additionalParameter) {
        this.additionalParameter = additionalParameter;
    }
}
