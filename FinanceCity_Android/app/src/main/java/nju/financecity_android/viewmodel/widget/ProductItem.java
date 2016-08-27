package nju.financecity_android.viewmodel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import nju.financecity_android.R;

/**
 * Created by coral on 16-8-26.
 */
public class ProductItem extends RelativeLayout {

    public ProductItem(Context context) {
        super(context);
        init(context);
    }

    public ProductItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        loadComponents();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.investment_item, this);
    }

    private void loadComponents() {
        txtPdtName = (TextView) findViewById(R.id.txtPdtName);
        txtIncRate = (TextView) findViewById(R.id.txtIncRate);
        txtBuyTime = (TextView) findViewById(R.id.txtBuyTime);
        txtCurrPrice = (TextView) findViewById(R.id.txtCurrPrice);
        txtExpiration = (TextView) findViewById(R.id.txtExpiration);
        txtBuyPrice = (TextView) findViewById(R.id.txtBuyPrice);
        txtAvlblTime = (TextView) findViewById(R.id.txtAvlblTime);
    }

    private TextView txtPdtName, txtIncRate, txtBuyTime, txtCurrPrice,
                     txtExpiration, txtBuyPrice, txtAvlblTime;
}
