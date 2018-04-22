package test.witchapp.com.mytest.ui.fragments;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.witchapp.com.mytest.R;
import test.witchapp.com.mytest.db.model.CountryDao;
import test.witchapp.com.mytest.holds.Urls;
import test.witchapp.com.mytest.interfaces.CountryApi;
import test.witchapp.com.mytest.serverutils.ServiceGenerator;
import test.witchapp.com.mytest.ui.adapters.AdapterCountries;
import test.witchapp.com.mytest.utils.AsyncLoadData;

/**
 * Created by z.ahmadi on 4/21/2018.
 */
@EFragment(R.layout.fragment_load_data)
public class FragmentLoadData extends Fragment {
    @ViewById(R.id.recycler)
    protected RecyclerView mRecyclerView;
    public    AdapterCountries adapterCountries;
    public    ArrayList<CountryDao> list=new ArrayList<>();
    public    Call<List<CountryDao>> call;

    public static FragmentLoadData_ newInstance() {
        FragmentLoadData_ fragmentLoadData=new FragmentLoadData_();
        return fragmentLoadData;
    }

    public void loadData() {
        CountryApi getDataApi = ServiceGenerator.getInstance().createService(CountryApi.class,Urls.MainUrl);
        call = getDataApi.get();
        Callback callback = new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call,final Response<Object> response) {
                AsyncLoadData  asyncLoadData=AsyncLoadData.newInstance(new AsyncLoadData.doInBackground() {
                    @Override
                    public Object ondoInBackground() {
                        ArrayList<CountryDao> lis= (ArrayList<CountryDao>)response.body();
                        for (CountryDao countryDao:lis) {
                            countryDao.save();
                        }
                        return  lis;
                    }
                    @Override
                    public void onPreExecute() {}
                    @Override
                    public void onPostExecute(Object o) {

                    }
                });
                asyncLoadData.execute();
            }
            @Override
            public void onFailure(Call<Object> call,Throwable t) {}
        };
        call.enqueue(callback);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (call!=null) {
            call.cancel();
        }
    }

    @AfterViews
    public void after() {
        adapterCountries=new AdapterCountries(getActivity());
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapterCountries);
        if (list.size()>0) {
            adapterCountries.addItems(list);
            adapterCountries.notifyDataSetChanged();
        } else {
            loadData();
        }
    }
}
