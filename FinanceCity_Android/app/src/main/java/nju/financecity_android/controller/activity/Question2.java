package nju.financecity_android.controller.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import nju.financecity_android.R;

/**
 * Created by sam on 16/9/12.
 */
public class Question2 extends Fragment {
    private EditText Insurance,GetMoney;
    private TextView seektxt1,seektxt2,seektxt3,seektxt4;
    private SeekBar risk1,risk2;
    private SeekBar income1,income2;
    private Button back,next;
    private View ThisView;

    private String riskStr1,riskStr2,incomeStr1,incomeStr2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question_ii,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        initComponent();
        addListener();
    }

    private void initComponent(){
        Insurance = (EditText) findViewById(R.id.txtRedeem);
        GetMoney = (EditText) findViewById(R.id.txtInsurance);

        risk1 = (SeekBar) findViewById(R.id.seekBar);
        risk2 = (SeekBar) findViewById(R.id.seekBar1);
        income1 = (SeekBar) findViewById(R.id.seekBar2);
        income2 = (SeekBar) findViewById(R.id.seekBar3);

        back = (Button) findViewById(R.id.button3);
        next = (Button) findViewById(R.id.button2);
        ThisView = getView();
    }

    private View findViewById(int Resid){
        return getView().findViewById(Resid);
    }

    private void addListener(){
        risk1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seektxt1.setText(progress+"");
                riskStr1 = progress+"";
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int i = seekBar.getProgress();
            }
        });

        risk2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seektxt2.setText(progress+"");
                riskStr2 = progress+"";
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        income1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seektxt3.setText(progress+"");
                incomeStr1 = progress+"";
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        income2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seektxt4.setText(progress+"");
                incomeStr2 = progress+"";
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
