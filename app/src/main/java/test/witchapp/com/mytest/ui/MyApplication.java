package test.witchapp.com.mytest.ui;
import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.multidex.MultiDex;
import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import java.io.File;
import test.witchapp.com.mytest.db.model.CountryDao;
public class MyApplication extends Application {
    private static int DatabaseVersion = 1;
    public static String DEFAULT_PATH = Environment.getExternalStorageDirectory() + "/MyTest";
    public static String DEFAULT_DATABASE_FILE = "Test.db";
    public static Class[] dbModels = new Class[] {CountryDao.class};
    private static SQLiteDatabase activeAndroid;
    public static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        MyApplication.getActiveAndroid();
    }

    public static SQLiteDatabase getActiveAndroid() {
        if (activeAndroid == null) {
             try {
                ActiveAndroid.dispose();
             } catch (Exception e) {
                e.printStackTrace();
             }
             File file = new File(DEFAULT_PATH, DEFAULT_DATABASE_FILE);
             Configuration dbConfiguration = new Configuration.Builder(myApplication)
            .setDatabaseName(file.getAbsolutePath())
            .setDatabaseVersion(DatabaseVersion)
            .setModelClasses(dbModels)
            .setCacheSize(1).create();
            ActiveAndroid.initialize(dbConfiguration);
            activeAndroid = ActiveAndroid.getDatabase();
        }
        return activeAndroid;
    }

    public static void clearCache() {
        try {
            ActiveAndroid.clearCache();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
