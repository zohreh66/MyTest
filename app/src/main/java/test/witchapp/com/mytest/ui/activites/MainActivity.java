package test.witchapp.com.mytest.ui.activites;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import test.witchapp.com.mytest.R;
import test.witchapp.com.mytest.ui.fragments.FragmentLoadData;
import test.witchapp.com.mytest.ui.fragments.FragmentLoadData_;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportFragmentManager().findFragmentByTag(FragmentLoadData.class.getName())==null)
        {
            FragmentLoadData_ fragmentLoadData=FragmentLoadData.newInstance();
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame_container,fragmentLoadData,FragmentLoadData.class.getName());
            ft.addToBackStack(FragmentLoadData.class.getName());
            ft.commit();
        }
    }
}
