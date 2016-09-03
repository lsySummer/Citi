package nju.financecity_android.controller.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nju.financecity_android.R;

/**
 * Created by st0001 on 2016/9/3.
 */
public class Choose extends LinearLayout{
    private String[] spinner1_content;
    private String[] spinner2_content;
    private String spinner1_choosed;
    private String spinner2_choosed;
    private TextView choose_text;
    private Spinner choose_spinner1;
    private ArrayAdapter spinner1_adapter;
    private Spinner choose_spinner2;
    private ArrayAdapter spinner2_adapter;

    public Choose(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.choose, this, true);
    }

    public Choose(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.choose, this, true);
        choose_text = (TextView) findViewById(R.id.choose_text);
        choose_spinner1= (Spinner) findViewById(R.id.choose_spinner1);
        choose_spinner2= (Spinner) findViewById(R.id.choose_spinner2);
        spinner1_adapter=new ArrayAdapter<String>(getContext(),R.layout.spinner_element,spinner1_content);
        spinner2_adapter=new ArrayAdapter<String>(getContext(),R.layout.spinner_element,spinner2_content);
        choose_spinner1.setAdapter(spinner1_adapter);
        choose_spinner2.setAdapter(spinner2_adapter);
        choose_spinner1.setOnItemSelectedListener(new Spinner.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3)
            {
                spinner1_choosed = spinner1_content[arg2];
                //设置显示当前选择的项
                arg0.setVisibility(View.VISIBLE);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                //nothing
            }
        });
        choose_spinner2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3)
            {
                spinner2_choosed = spinner2_content[arg2];
                //设置显示当前选择的项
                arg0.setVisibility(View.VISIBLE);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                //nothing
            }
        });
    }

    public void setChoose_text(String text) {
        choose_text.setText(text);
    }

    public void setSpinner1_content(String[] spinner1)
    {
        this.spinner1_content=spinner1;
    }

    public void setSpinner2_content(String[] spinner2)
    {
        this.spinner2_content=spinner2;
    }

    public String getSpinner1_choosed()
    {
        return spinner1_choosed;
    }

    public String getSpinner2_choosed()
    {
        return spinner2_choosed;
    }
}
