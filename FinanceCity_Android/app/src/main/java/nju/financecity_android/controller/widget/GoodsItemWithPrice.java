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
public class GoodsItemWithPrice {

    public GoodsItemWithPrice(Context context, View view, GoodsInfo data) {
        this.mContext = context;
        this.mView = view;
        this.mData = data;
    }

    public void initComponents() {
        txtPrice = (TextView) findViewById(R.id.txtPrice);
        txtPrice.setText(mData.price + "");
        btMinus = (TextView) findViewById(R.id.btMinus);
        btAdd = (TextView) findViewById(R.id.btAdd);
        txtAmount = (EditText) findViewById(R.id.txtAmount);
        txtAmount.setText(mData.amount + "");
        txtSimpleType = (TextView) findViewById(R.id.txtSimpleType);
        txtSimpleType.setText(mData.type.charAt(0) + "");
        txtCatogeries = (TextView) findViewById(R.id.txtCategories);
        if (mData.subType != null && !mData.subType.equals("")) {
            txtCatogeries.setText(String.format("%s-%s", mData.type, mData.subType));
        } else {
            txtCatogeries.setText(mData.type);
        }
        txtGoodsName = (TextView) findViewById(R.id.txtGoodName);
        txtGoodsName.setText(mData.goodsName);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int amount = Integer.parseInt(txtAmount.getText().toString().trim());
                amount++;
                txtAmount.setText(amount + "");
            }
        });
        btMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int amount = Integer.parseInt(txtAmount.getText().toString().trim());
                amount--;
                txtAmount.setText(amount + "");
            }
        });
        txtAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                mData.amount = Integer.parseInt(txtAmount.getText().toString().trim());
            }
        });
    }

    public View findViewById(int resId) {
        return mView.findViewById(resId);
    }

    private Context mContext;
    private View mView;
    private TextView txtPrice, txtSimpleType, txtCatogeries, txtGoodsName;
    private TextView btMinus, btAdd;
    private EditText txtAmount;
    private GoodsInfo mData;
    private int position;
}
