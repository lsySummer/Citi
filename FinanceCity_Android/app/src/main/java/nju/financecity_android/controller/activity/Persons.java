package nju.financecity_android.controller.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nju.financecity_android.R;

/**
 * Created by sam on 16/9/5.
 */
public class Persons extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_user, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
