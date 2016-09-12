package nju.financecity_android.controller.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import nju.financecity_android.R;

/**
 * Created by coral on 16-9-12.
 */
public class QuestionI extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question_i, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        initComponents();
    }

    private void initComponents() {
        txtInvestmentAmount = (EditText) findViewById(R.id.txtInvestmentAmount);
        txtExpiration = (EditText) findViewById(R.id.txtExpiration);
        txtFetchBack = (EditText) findViewById(R.id.txtFetchBack);
        rbOutcomeYes = (RadioButton) findViewById(R.id.rbOutcomeYes);
        rbOutcomeNo = (RadioButton) findViewById(R.id.rbOutcomeNo);
        rbPrepareYes = (RadioButton) findViewById(R.id.rbPrepareYes);
        rbPrepareNo = (RadioButton) findViewById(R.id.rbPrepareNo);
        chkInsurance = (CheckBox) findViewById(R.id.chkInsurance);
        chkMassFund = (CheckBox) findViewById(R.id.chkMassFund);
    }

    public View findViewById(int resId) {
        return getView().findViewById(resId);
    }

    private EditText txtInvestmentAmount, txtExpiration, txtFetchBack;
    private RadioButton rbOutcomeYes, rbOutcomeNo, rbPrepareYes, rbPrepareNo;
    private CheckBox chkInsurance, chkMassFund;

}