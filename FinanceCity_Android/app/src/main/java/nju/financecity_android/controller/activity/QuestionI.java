package nju.financecity_android.controller.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import nju.financecity_android.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public View findViewById(int resId) {
        return getView().findViewById(resId);
    }

    public void setObserver(IQuestionObserver observer) {
        this.mObserver = observer;
    }

    private void initComponents() {
        txtInvestmentAmount = (EditText) findViewById(R.id.txtInvestmentAmount);
        txtExpiration = (EditText) findViewById(R.id.txtExpiration);
        txtFetchBack = (EditText) findViewById(R.id.txtFetchBack);
        rbOutcomeYes = (RadioButton) findViewById(R.id.rbOutcomeYes);
        rbOutcomeNo = (RadioButton) findViewById(R.id.rbOutcomeNo);
        rbPrepareYes = (RadioButton) findViewById(R.id.rbPrepareYes);
        rbPrepareNo = (RadioButton) findViewById(R.id.rbPrepareNo);
        btCancle = (Button) findViewById(R.id.btCancel);
        btContinue = (Button) findViewById(R.id.btContinue);

        rbOutcomeYes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rbOutcomeNo.setChecked(false);
                }
            }
        });
        rbOutcomeNo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rbOutcomeYes.setChecked(false);
                }
            }
        });
        rbPrepareNo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rbPrepareYes.setChecked(false);
                }
            }
        });
        rbPrepareYes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rbPrepareNo.setChecked(false);
                }
            }
        });
        btContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateResult();
                mObserver.showNextPage();
            }
        });
    }

    public void generateResult() {
        Map map = new HashMap();
        int amount = Integer.parseInt(txtInvestmentAmount.getText().toString().trim());
        String date, backDate;
        boolean ifPrepare = rbOutcomeYes.isChecked();
        boolean ifBifPre = rbPrepareYes.isChecked();
        map.put("amount", amount);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        date = txtExpiration.getText().toString();
        backDate = txtFetchBack.getText().toString();
        mObserver.putAnswer("amount", amount);
        mObserver.putAnswer("date", date);
        mObserver.putAnswer("backDate", backDate);
        mObserver.putAnswer("ifPrepare", ifPrepare);
        mObserver.putAnswer("ifBifPre", ifBifPre);
    }

    private EditText txtInvestmentAmount, txtExpiration, txtFetchBack;
    private RadioButton rbOutcomeYes, rbOutcomeNo, rbPrepareYes, rbPrepareNo;
    private IQuestionObserver mObserver;
    private Button btCancle, btContinue;
}