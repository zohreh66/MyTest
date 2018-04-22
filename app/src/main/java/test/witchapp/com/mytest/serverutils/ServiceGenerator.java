package test.witchapp.com.mytest.serverutils;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
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
            Retrofit.Builder builder = new Retrofit.Builder().baseUrl(SERVER_ADDRESS);
            Retrofit retrofit = builder
                    .client(httpClient)
                    .build();
            return retrofit.create(serviceClass);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
