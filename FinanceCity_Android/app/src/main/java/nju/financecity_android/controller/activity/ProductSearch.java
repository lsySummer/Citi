package nju.financecity_android.controller.activity;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import nju.financecity_android.R;

/**
 * Created by Administrator on 2016/9/3.
 */
public class ProductSearch extends LinearLayout{
    public ProductSearch(Context context) {
        super(context);
        init(context);
    }

    public ProductSearch(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.product_search, this, true);
    }
}
