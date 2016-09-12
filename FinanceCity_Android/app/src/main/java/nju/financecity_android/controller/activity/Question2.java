package nju.financecity_android.controller.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import nju.financecity_android.R;

/**
 * Created by sam on 16/9/12.
 */
public class Question2 extends Fragment {
    private EditText Insurance,GetMoney;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question_ii,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        initComponent();
    }

    private void initComponent(){

    }
}
