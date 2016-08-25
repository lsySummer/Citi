package nju.financecity_android.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import nju.financecity_android.R;

/**
 * Created by Administrator on 2016/8/25.
 */
public class MainActivity extends Activity {
    public Fragment assets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
