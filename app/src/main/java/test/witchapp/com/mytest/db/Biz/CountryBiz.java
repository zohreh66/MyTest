package test.witchapp.com.mytest.db.Biz;

import com.activeandroid.query.Select;
import java.util.List;
import test.witchapp.com.mytest.db.model.CountryDao;
/**
 * Created by z.ahmadi on 4/21/2018.
 */

public class CountryBiz {
    public static List<CountryDao> getAllData()
    {
        return new Select().from(CountryDao.class).execute();
    }
}
