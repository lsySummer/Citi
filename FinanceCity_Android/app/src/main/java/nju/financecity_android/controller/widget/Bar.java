package nju.financecity_android.controller.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import nju.financecity_android.R;
import com.appyvet.rangebar.RangeBar;

public class Bar extends LinearLayout {
    private TextView bar_text;
	private RangeBar bar_rangebar;
    private float start;
    private float end;
    private double interval;
    private String unit;
	
    public Bar(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.bar, this, true);
    }

    public Bar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.bar, this, true);
        bar_text = (TextView) findViewById(R.id.bar_text);
        bar_rangebar= (RangeBar) findViewById(R.id.bar_rangebar);
        start=bar_rangebar.getTickStart();
        end=bar_rangebar.getTickEnd();
        interval=bar_rangebar.getTickInterval();
    }

    public String getBar_text() {
        return bar_text.getText().toString();
    }

    public void setBar_text(String text) {
        bar_text.setText(text);
    }

    public void setBar_rangebar_start(float start)
    {
        this.bar_rangebar.setTickStart(start);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.start=bar_rangebar.getTickStart();
        this.end=bar_rangebar.getTickEnd();
        return super.onTouchEvent(event);
    }

    public void setBar_rangebar_start( )
    {
        this.bar_rangebar.setTickStart(start);
    }

    public void setBar_rangebar_end(float end)
    {
        this.bar_rangebar.setTickEnd(end);
    }

    public void setBar_rangebar_interval(float interval)
    {
        this.bar_rangebar.setTickInterval(interval);
    }

    public float getStart()
    {
        return start;
    }
    public float getEnd()
    {
        return end;
    }
}
