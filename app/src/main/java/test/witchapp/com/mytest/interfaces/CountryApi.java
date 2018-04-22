package test.witchapp.com.mytest.interfaces;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import test.witchapp.com.mytest.db.model.CountryDao;
import test.witchapp.com.mytest.holds.Urls;
public interface CountryApi {
    @GET(Urls.Countries)
    Call<List<CountryDao>> get();
}
