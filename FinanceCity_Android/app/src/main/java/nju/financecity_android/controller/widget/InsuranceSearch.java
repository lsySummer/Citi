package nju.financecity_android.controller.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import nju.financecity_android.R;

/**
 * Created by Administrator on 2016/9/6.
 */
public class InsuranceSearch extends RelativeLayout{
    private Bar year;
    private Bar limit;
    private Spinner agent;
    private Bar value;

    private String[] agent_content;

    private int agent_item=0;

    public InsuranceSearch(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.insurance_search, this, true);
        onFinishInflate();
    }

    public InsuranceSearch(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.insurance_search, this, true);
        onFinishInflate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        year=(Bar)findViewById(R.id.year);
        limit=(Bar)findViewById(R.id.limit);
        agent=(Spinner)findViewById(R.id.agent_spinner);
        value=(Bar)findViewById(R.id.value);

        agent_content=new String[]{"bank1","bank2","bank3"};//TODO 从API获得
        agent.setAdapter(new ArrayAdapter<String>(getContext(),R.layout.spinner_element,agent_content));
        agent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                agent_item=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public Float getYearMin()
    {
        return year.getMin();
    }
    public Float getYearMax()
    {
        return year.getMax();
    }
    public Float getLimitMin()
    {
        return limit.getMin();
    }
    public Float getLimitMax()
    {
        return limit.getMax();
    }
    public String getAgent()
    {
        return agent_content[agent_item];
    }
    public Float getValueMin()
    {
        return year.getMin();
    }
    public Float getValueMax()
    {
        return year.getMax();
    }
}
