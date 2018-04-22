package test.witchapp.com.mytest.db.model;
import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
/**
 * Created by z.ahmadi on 4/21/2018.
 */
@Table(name = CountryDao.Country_Table)
public class CountryDao extends Model implements Cloneable
{
    public static final String Country_Table = "Country";
    public static final String iso_Column = "iso";
    public static final String name_Column = "name";
    public static final String phone_Column = "phone";
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Expose
    @Column(name = iso_Column)
    public String iso;
    @Expose
    @Column(name = name_Column)
    public String name;
    @Expose
    @Column(name = phone_Column)
    public String phone;
}
