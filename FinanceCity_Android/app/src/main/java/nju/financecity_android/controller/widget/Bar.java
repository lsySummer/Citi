package nju.financecity_android.controller.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
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
        //加载视图的布局
        LayoutInflater.from(context).inflate(R.layout.bar, this, true);
        onFinishInflate();
    }

    public Bar(Context context, AttributeSet attrs) {
        super(context, attrs);
        //加载视图的布局
        LayoutInflater.from(context).inflate(R.layout.bar, this, true);
        onFinishInflate();
        //加载自定义的属性
//        TypedArray a=context.obtainStyledAttributes(attrs,R.styleable.Header);
//        titleText=a.getString(R.styleable.Header_titleText);
//        titleTextColor=a.getColor(R.styleable.Header_titleTextColor, Color.WHITE);
//        titleTextSize=a.getDimension(R.styleable.Header_titleTextSize,20f);

        //回收资源，这一句必须调用
//        a.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        //获取子控件
        bar_text = (TextView) findViewById(R.id.bar_text);
        bar_rangebar= (RangeBar) findViewById(R.id.bar_rangebar);
        start=bar_rangebar.getTickStart();
        end=bar_rangebar.getTickEnd();
        interval=bar_rangebar.getTickInterval();

        //将从资源文件中加载的属性设置给子控件
//        if (!TextUtils.isEmpty(titleText))
//            setPageTitleText(titleText);
//        setPageTitleTextColor(titleTextColor);
//        setPageTitleTextSize(titleTextSize);

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
