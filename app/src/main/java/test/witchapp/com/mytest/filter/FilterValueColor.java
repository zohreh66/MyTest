package test.witchapp.com.mytest.filter;
/**
 * Created by Mohammad Golkar on 2017-01-04.
 */
public class FilterValueColor {
    protected long id = 0;
    protected String value;
    public FilterValueColor() {}
    public FilterValueColor(long id,String value) {
        this.id = id;
        this.value = value;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
