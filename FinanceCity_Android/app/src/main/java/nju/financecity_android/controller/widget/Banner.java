package nju.financecity_android.controller.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appyvet.rangebar.RangeBar;
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
        initAttributes(context, attrs);
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
        lblText.setText(display_text);
        if (show_search_button)
            btSearch.setVisibility(VISIBLE);
        else
            btSearch.setVisibility(INVISIBLE);
    }

    private void loadComponents() {
        lblText = (TextView) findViewById(R.id.lblText);
        mainPane = (RelativeLayout) findViewById(R.id.mainPane);
        btSearch = (ImageView) findViewById(R.id.btSearch);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.banner, this, true);
    }

    protected void initAttributes(Context context, AttributeSet attrs) {
        TypedArray attrset = context.obtainStyledAttributes(attrs, R.styleable.Bar);
        display_text = attrset.getString(R.styleable.Banner_display_text);
        show_search_button = attrset.getBoolean(R.styleable.Banner_show_search_button, true);
        attrset.recycle();
    }

    private TextView lblText;

    private RelativeLayout mainPane;
    private String display_text = "";
    private ImageView btSearch;
    private boolean show_search_button;
}
