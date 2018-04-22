package test.witchapp.com.mytest.serverutils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.witchapp.com.mytest.filter.DeserializerFilters;
import test.witchapp.com.mytest.filter.Filters;

/**
 * Created by z.ahmadi on 4/21/2018.
 */
public class ServiceGenerator
{
    private static ServiceGenerator _instance = null;
    public static ServiceGenerator getInstance() {
        if (_instance == null) _instance = new ServiceGenerator();
        return _instance;
    }
    public <S> S
    createService(Class<S> serviceClass,String SERVER_ADDRESS) {
        try {
            OkHttpClient.Builder ok = new OkHttpClient.Builder()
            .connectTimeout(90, TimeUnit.SECONDS)
            .readTimeout(90, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS);
            OkHttpClient httpClient  = ok.build();
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Filters.class, new DeserializerFilters());
            gsonBuilder.excludeFieldsWithoutExposeAnnotation();
            Gson gson = gsonBuilder.create();
            Retrofit.Builder builder = new Retrofit.Builder().baseUrl(SERVER_ADDRESS);
            Retrofit retrofit = builder
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            return retrofit.create(serviceClass);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
