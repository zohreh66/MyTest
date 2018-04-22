package test.witchapp.com.mytest.filter;

import com.google.gson.annotations.Expose;


public class FilterType {

    @Expose
    protected long id;
    @Expose
    protected String name;
    @Expose
    protected String type;
    @Expose
    protected String dataType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}