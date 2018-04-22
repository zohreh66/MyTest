package test.witchapp.com.mytest.filter;



import java.util.List;

public class FilterTypeCheckBox extends FilterType {

    /**
     * Currently selected value
     */
    protected transient FilterValueColor selectedValue = null;

    protected List<FilterValueColor> values;

    public FilterTypeCheckBox() {
    }

    public FilterValueColor getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(FilterValueColor selectedValue) {
        this.selectedValue = selectedValue;
    }

    public List<FilterValueColor> getValues() {
        return values;
    }

    public void setValues(List<FilterValueColor> values) {
        this.values = values;
    }

}