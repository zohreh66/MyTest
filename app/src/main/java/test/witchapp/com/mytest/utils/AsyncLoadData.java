package test.witchapp.com.mytest.utils;
import android.os.AsyncTask;
import java.util.ArrayList;

import test.witchapp.com.mytest.db.model.CountryDao;

/**
 * Created by z.ahmadi on 4/21/2018.
 */
public class AsyncLoadData extends AsyncTask<Void,Void,Object> {
    public doInBackground doInBackground;

    public static AsyncLoadData newInstance(doInBackground doInBackground) {
        AsyncLoadData asyncLoadData=new AsyncLoadData();
        asyncLoadData.doInBackground=doInBackground;
        return  asyncLoadData;
    }

    public interface doInBackground {
        public Object ondoInBackground();
        public void onPreExecute();
        public void onPostExecute(Object objects);
    }

    @Override
    protected void onPreExecute() {
        doInBackground.onPreExecute();
    }

    @Override
    protected void onPostExecute(Object aVoid) {
        doInBackground.onPostExecute(aVoid);
    }

    @Override
    protected Object doInBackground(Void... voids) {
        return  doInBackground.ondoInBackground();
    }
}
