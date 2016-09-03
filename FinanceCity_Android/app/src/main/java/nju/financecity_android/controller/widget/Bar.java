package nju.financecity_android.controller.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import nju.financecity_android.R;
import com.appyvet.rangebar.RangeBar;

public class Bar extends LinearLayout {
    private LinearLayout bar_layout;
    private TextView bar_text;
	private RangeBar bar_rangebar;
	
    public Bar(Context context) {
        super(context);
        init(context);
    }

    public Bar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bar, this, true);
    }

    private void loadComponents() {
        bar_layout = (LinearLayout) findViewById(R.id.bar_layout);
//        bar_text = (TextView) findViewById(R.id.bar_text);
//        bar_rangebar= (RangeBar) findViewById(R.id.bar_rangebar);
    }

    public String getBar_text() {
        return bar_text.getText().toString();
    }

    public void setBar_text(String text) {
        bar_text.setText(text);
    }

    public void setBar_rangebar(int start,int end,int unit) {
        this.bar_rangebar.setTickStart(start);
        this.bar_rangebar.setTickEnd(end);
        this.bar_rangebar.setTickInterval(unit);
    }

    public RangeBar getBar_rangebar() {
        return bar_rangebar;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        loadComponents();
    }

}
