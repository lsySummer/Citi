package nju.financecity_android.controller.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import nju.financecity_android.R;
import nju.financecity_android.controller.activity.MainActivity;
import nju.financecity_android.vo.ProductInfo;
import nju.financecity_android.vo.ProductVO;

/**
 * Created by Administrator on 2016/9/6.
 */
public class SingleSearchResult extends RelativeLayout {
    private ImageView background;
    private TextView year_rate;
    private TextView year_text;
    private TextView line;
    private TextView type;
    private TextView product;
    private TextView introduction;
    private TextView top;
    private TextView middle;
    private TextView bottom;
    private ProductVO info;

    public SingleSearchResult(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.product_search_result_element, this, true);
        onFinishInflate();
    }

    public SingleSearchResult(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.product_search_result_element, this, true);
        onFinishInflate();
    }

    public SingleSearchResult(Context context, ProductVO info) {
        super(context);
        this.info=info;
        LayoutInflater.from(context).inflate(R.layout.product_search_result_element, this, true);
        onFinishInflate();
    }

    @TargetApi(16)
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        background=(ImageView)findViewById(R.id.background);
        year_rate=(TextView)findViewById(R.id.year_rate);
        year_text=(TextView)findViewById(R.id.year_text);
        line=(TextView)findViewById(R.id.line);
        type=(TextView)findViewById(R.id.type);
        product=(TextView)findViewById(R.id.product);
        introduction=(TextView)findViewById(R.id.introduction);
        top=(TextView)findViewById(R.id.top);
        middle=(TextView)findViewById(R.id.middle);
        bottom=(TextView)findViewById(R.id.bottom);

        int[] colors={R.color.bank,R.color.bond,R.color.fund,R.color.insurance};
        int[] backgrounds={R.drawable.bank_head,R.drawable.bond_head,R.drawable.fund_head,R.drawable.insurance_head};
        int choose=1;
        switch(info.getType())
        {
            case "bank":
                choose=1;
                break;
            case "bond":
                choose=2;
                break;
            case "fund":
                choose=3;
                break;
            case "insurance":
                choose=4;
                break;
        }
        background.setBackground(getResources().getDrawable(backgrounds[choose-1]));
        year_rate.setTextColor(getResources().getColor(colors[choose-1]));
        year_text.setTextColor(getResources().getColor(colors[choose-1]));
        line.setTextColor(getResources().getColor(colors[choose-1]));
        type.setTextColor(getResources().getColor(colors[choose-1]));

        year_rate.setText(info.getYear()+"");
        type.setText(info.getType());
        product.setText(info.getName());
        introduction.setText(info.getIntroduction());
        top.setText(info.getTop());
        middle.setText(info.getMiddle());
        bottom.setText(info.getBottom());
    }
}
