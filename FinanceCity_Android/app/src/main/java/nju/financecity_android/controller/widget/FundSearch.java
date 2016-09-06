package nju.financecity_android.controller.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;

import nju.financecity_android.R;

/**
 * Created by Administrator on 2016/9/6.
 */
public class FundSearch extends RelativeLayout {
    private Spinner agent;
    private Spinner state;
    private Bar latest;
    private EditText sort;
    private Switch close;

    private String[] agent_content;
    private String[] state_content;

    private int agent_item;
    private int state_item;
    private boolean close_checked=false;


    public FundSearch(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.fund_search, this, true);
        onFinishInflate();
    }

    public FundSearch(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.fund_search, this, true);
        onFinishInflate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        agent=(Spinner)findViewById(R.id.agent_spinner);
        state=(Spinner)findViewById(R.id.state_spinner);
        latest=(Bar)findViewById(R.id.latest);
        sort=(EditText)findViewById(R.id.sort_text);
        close=(Switch)findViewById(R.id.close_switch);

        agent_content=new String[]{"agent1","agent2","agnet3"};//TODO 从API获取
        agent.setAdapter(new ArrayAdapter<String>(getContext(),R.layout.spinner_element,agent_content));
        state_content=getResources().getStringArray(R.array.fund_state);
        state.setAdapter(new ArrayAdapter<String>(getContext(),R.layout.spinner_element,state_content));

        agent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                agent_item=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                state_item=i;
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

    public String getAgent()
    {
        return agent_content[agent_item];
    }
    public String getState()
    {
        return state_content[state_item];
    }
    public Float getLatestMin()
    {
        return latest.getMin();
    }
    public Float getLatestMax()
    {
        return latest.getMax();
    }
    public int getSortYear()
    {
        return Integer.parseInt(sort.getText().toString());
    }
    public boolean getCloseChecked()
    {
        return close_checked;
    }
}
