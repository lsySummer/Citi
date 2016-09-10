package nju.financecity_android.controller.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import nju.financecity_android.R;
import nju.financecity_android.vo.GoodsInfo;

import java.util.List;

/**
 * Created by coral on 16-9-9.
 */
public class GoodsItemWithoutPrice {

    public GoodsItemWithoutPrice(Context context, View view, GoodsInfo data) {
        this.mContext = context;
        this.mView = view;
        this.mData = data;
        initComponents();
    }

    public void initComponents() {
        txtAmount = (EditText) findViewById(R.id.txtAmount);
        txtAmount.setText(mData.amount);
        txtSimpleType = (TextView) findViewById(R.id.txtSimpleType);
        if (mData.type.equals(""))
        txtCatogeries = (TextView) findViewById(R.id.txtCategories);
        txtCatogeries.setText(String.format("%s-%s", mData.type, mData.subType));
        txtGoodsName = (TextView) findViewById(R.id.txtGoodName);
        txtGoodsName.setText(mData.goodsName);

        txtAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                mData.amount = Integer.parseInt(txtAmount.getText().toString());
            }
        });
    }

    public View findViewById(int resId) {
        return mView.findViewById(resId);
    }

    private Context mContext;
    private View mView;
    private TextView txtSimpleType, txtCatogeries, txtGoodsName;
    private GoodsInfo mData;
    private EditText txtAmount;
    private int position;
}
