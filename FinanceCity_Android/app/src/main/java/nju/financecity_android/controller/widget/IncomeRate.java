package nju.financecity_android.controller.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import nju.financecity_android.R;

/**
 * Created by coral on 16-8-22.
 */
public class IncomeRate extends LinearLayout {

    private LinearLayout search_filter_incomeRate;
    private TextView incomeRate_text;
	private RangeBar incomeRate_rangebar;
	
    public IncomeRate(Context context) {
        super(context);
        init(context);
    }

    public IncomeRate(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    //----------------------Interfaces------------------------

    public String getDisplayString() {
        return incomeRate_text.getText().toString();
    }

    public void setDisplayText(String displayText) {
        incomeRate_text.setText(displayText);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        loadComponents();
    }

    private void loadComponents() {
        incomeRate_text = (TextView) findViewById(R.id.incomeRate_text);
        search_filter_incomeRate = (LinearLayout) findViewById(R.id.search_filter_incomeRate);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.product_search_filter_incomeRate, this, true);
    }
}
