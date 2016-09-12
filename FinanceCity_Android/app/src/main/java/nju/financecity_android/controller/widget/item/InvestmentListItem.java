package nju.financecity_android.controller.widget.item;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import nju.financecity_android.R;
import nju.financecity_android.util.TimeString;
import nju.financecity_android.vo.ProductInfo;

/**
 * Created by coral on 16-9-10.
 */
public class InvestmentListItem implements ICommonItem {
    public InvestmentListItem(Context context, View convertView, ProductInfo data) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mView = mInflater.inflate(R.layout.investment_item, null);
        this.mData = data;
        initComponents();
    }

    @Override
    public void initComponents() {
        txtPdtName = (TextView) mView.findViewById(R.id.txtPdtName);
        txtPdtName.setText(mData.productName);

        txtBuyPrice = (TextView) mView.findViewById(R.id.txtBuyPrice);
        txtBuyPrice.setText("￥" + mData.buyPrice);

        txtBuyTime = (TextView) mView.findViewById(R.id.txtBuyTime);
        txtBuyTime.setText(TimeString.getTimeByDate(mData.buy));

        txtCurrPrice = (TextView) mView.findViewById(R.id.txtCurrPrice);
        txtCurrPrice.setText("￥" + mData.currPrice + "");

        txtIncRate = (TextView) mView.findViewById(R.id.txtIncRate);
        if (mData.buyPrice == 0 || mData.buyPrice == mData.currPrice) {
            txtIncRate.setText("--");
            txtIncRate.setTextColor(mView.getResources().getColor(R.color.abc_primary_text_material_dark));
        }
        double incRate = (mData.currPrice - mData.buyPrice) / mData.buyPrice * 100;
        String strIncRate = String.valueOf(incRate);
        if (strIncRate.length() > 4) {
            strIncRate = strIncRate.substring(0, 4);
        }
        txtIncRate.setText(strIncRate + "%");
        if (incRate > 0)
            txtIncRate.setTextColor(mView.getResources().getColor(R.color.increasingRed));
        else
            txtIncRate.setTextColor(mView.getResources().getColor(R.color.decreasingGreen));

        btSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
                dialog.setTitle("卖出");
                dialog.setMessage("确定要卖出 " + mData.productName + " 吗？");
                dialog.setPositiveButton("卖出", null);
                dialog.setNegativeButton("取消", null);
            }
        });
    }

    @Override
    public void setItemOnClickListener(View.OnClickListener listener) {

    }

    @Override
    public void setItemOnLongClickListener(View.OnLongClickListener listener) {

    }

    @Override
    public View getView() {
        return mView;
    }

    @Override
    public View findViewById(int resId) {
        return mView.findViewById(resId);
    }

    private TextView txtPdtName, txtBuyPrice, txtBuyTime, txtCurrPrice, txtIncRate, btSell;
    private LayoutInflater mInflater;
    private Context mContext;
    private View mView;
    private ProductInfo mData;

}
