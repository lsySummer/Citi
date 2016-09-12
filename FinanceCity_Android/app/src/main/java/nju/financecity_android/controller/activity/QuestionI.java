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
 * Created by coral on 16-9-12.
 */
public class QuestionI extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question_i, container, false);
    }

    private EditText txtInvestmentAmount, txtExpiration, txtFetchBack;

}
