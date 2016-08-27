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
public class Banner extends LinearLayout {

    public Banner(Context context) {
        super(context);
        init(context);
    }

    public Banner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    //----------------------Interfaces------------------------

    public String getDisplayString() {
        return lblText.getText().toString();
    }

    public void setDisplayText(String displayText) {
        lblText.setText(displayText);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        loadComponents();
    }

    private void loadComponents() {
        lblText = (TextView) findViewById(R.id.lblText);
        mainPane = (LinearLayout) findViewById(R.id.mainPane);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.banner, this, true);
    }
    private TextView lblText;
    private LinearLayout mainPane;
}
