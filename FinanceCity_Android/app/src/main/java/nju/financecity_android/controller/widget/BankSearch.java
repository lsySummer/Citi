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

import nju.financecity_android.R;

/**
 * Created by Administrator on 2016/9/6.
 */
public class BankSearch extends RelativeLayout {
    private Bar year;
    private Bar start;
    private Bar limit;
    private Spinner agent;
    private Spinner incometype;
    private Switch close;

    private String[] agent_content;
    private String[] incometype_content;

    private int agent_item=0;
    private int incometype_item=0;
    private boolean close_checked=false;

    public BankSearch(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.bank_search, this, true);
        onFinishInflate();
    }

    public BankSearch(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.bank_search, this, true);
        onFinishInflate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        year=(Bar)findViewById(R.id.year);
        start=(Bar)findViewById(R.id.start);
        limit=(Bar)findViewById(R.id.limit);
        agent=(Spinner)findViewById(R.id.agent_spinner);
        incometype=(Spinner)findViewById(R.id.incometype_spinner);
        close=(Switch)findViewById(R.id.close_switch);
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
        incometype_content=new String[]{"type1","type2","type3"};//TODO 从API获得
        incometype.setAdapter(new ArrayAdapter<String>(getContext(),R.layout.spinner_element,incometype_content));
        incometype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                incometype_item=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        close.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                close_checked=!close_checked;
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
    public Float getStartMin()
    {
        return start.getMin();
    }
    public Float getStartMax()
    {
        return start.getMax();
    }
    public Float getLimitMin()
    {
        return limit.getMin();
    }
    public Float getLimitMax()
    {
        return limit.getMax();
    }
    public boolean getCloseChecked()
    {
        return close_checked;
    }
    public String getAgent()
    {
        return agent_content[agent_item];
    }
    public String getIncometype()
    {
        return incometype_content[incometype_item];
    }
}
