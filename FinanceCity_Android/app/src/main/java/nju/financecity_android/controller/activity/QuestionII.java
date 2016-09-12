package nju.financecity_android.controller.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.widget.SeekBar;
import android.widget.TextView;
import nju.financecity_android.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by sam on 16/9/12.
 */
public class QuestionII extends Fragment {
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

    public View findViewById(int resId) {
        return getView().findViewById(resId);
    }

    public void setObserver(IQuestionObserver observer) {
        this.mObserver = observer;
    }

    private void initComponent(){
        sb1 = (SeekBar) findViewById(R.id.sb1);
        sb2 = (SeekBar) findViewById(R.id.sb2);
        sb3 = (SeekBar) findViewById(R.id.sb3);
        sb4 = (SeekBar) findViewById(R.id.sb4);
        txtValue1 = (TextView) findViewById(R.id.txtValue1);
        txtValue2 = (TextView) findViewById(R.id.txtValue2);
        txtValue3 = (TextView) findViewById(R.id.txtValue3);
        txtValue4 = (TextView) findViewById(R.id.txtValue4);
        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtValue1.setText(String.format(Locale.CHINESE, "%d%", progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtValue2.setText(String.format(Locale.CHINESE, "%d%", progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        sb3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtValue3.setText(String.format(Locale.CHINESE, "%d%", progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        sb4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtValue4.setText(String.format(Locale.CHINESE, "%d%", progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        btCancel = (Button) findViewById(R.id.btCancle);
        btContinue = (Button) findViewById(R.id.btContinue);
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mObserver.showFormerPage();
            }
        });
        btContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateData();
                mObserver.showNextPage();
            }
        });
    }

    private void generateData() {
        List<Integer> risk = new ArrayList<>();
        risk.add(sb1.getProgress());
        risk.add(sb2.getProgress());
        mObserver.putAnswer("risk", risk);
        List<Integer> income = new ArrayList<>();
        income.add(sb3.getProgress());
        income.add(sb4.getProgress());
        mObserver.putAnswer("income", income);
    }

    private IQuestionObserver mObserver;
    private SeekBar sb1, sb2, sb3, sb4;
    private TextView txtValue1, txtValue2, txtValue3, txtValue4;
    private Button btCancel, btContinue;
}
