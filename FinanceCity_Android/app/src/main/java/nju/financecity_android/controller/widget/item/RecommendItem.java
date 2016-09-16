package nju.financecity_android.controller.widget.item;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;
import nju.financecity_android.R;
import nju.financecity_android.util.ColorBoard;
import nju.financecity_android.vo.GoodsInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coral on 16-9-15.
 */
public class RecommendItem {

    public RecommendItem(Context context, View convertView, GoodsInfo data) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mView = (convertView == null) ? mInflater.inflate(R.layout.recommend_item, null) : convertView;
        this.mData = data;
        initComponents();
    }

    public View getView() {
        return mView;
    }

    public View findViewById(int resId) {
        return mView.findViewById(resId);
    }

    private void initComponents() {
        txtSimpleType = (TextView) findViewById(R.id.txtSimpleType);
        if (mData.type != null && mData.type.contains("银行")) {
            txtSimpleType.setText("理");
            txtSimpleType.setBackgroundResource(R.drawable.bank_background);
        } else if (mData.type != null && mData.type.contains("基金")) {
            txtSimpleType.setText("基");
            txtSimpleType.setBackgroundResource(R.drawable.fund_background);
        } else if (mData.type != null && mData.type.contains("债券")) {
            txtSimpleType.setText("债");
            txtSimpleType.setBackgroundResource(R.drawable.bond_background);
        } else if (mData.type != null && mData.type.contains("保险")) {
            txtSimpleType.setText("保");
            txtSimpleType.setBackgroundResource(R.drawable.insurance_background);
        }

        txtProductName = (TextView) findViewById(R.id.txtProductName);
        txtProductName.setText(mData.goodsName + "");

        txtAmount = (TextView) findViewById(R.id.txtAmount);
        txtAmount.setText("￥" + mData.amount);

        piechart = (PieChartView) findViewById(R.id.piechart);
    }

    /**
     * 显示饼图数据
     * @param amount 当前产品的购买总额
     * @param sum 当前投资组合总额
     */
    public void setChartInfo(float amount, float sum) {
        List<SliceValue> values = new ArrayList<>();
        values.add(new SliceValue(amount).setColor(getView().getResources().getColor(R.color.lightBlue)));
        values.add(new SliceValue(sum - amount).setColor(getView().getResources().getColor(R.color.lightGrey)));
        PieChartData data = new PieChartData(values);
        data.setHasLabels(false);
        data.setHasLabelsOutside(true);
        data.setHasLabelsOnlyForSelected(false);
        data.setHasCenterCircle(true);
        data.setCenterCircleScale(0.8f);
        String strPercent = amount / sum * 100 + "";
        if (strPercent.length() > 3) strPercent = strPercent.substring(0, 3) + "%";
        data.setCenterText1(strPercent);
        data.setCenterText1FontSize(14);
        data.setCenterText1Color(Color.parseColor("#7a7a7a"));
        data.setValueLabelBackgroundColor(Color.TRANSPARENT);
        data.setValueLabelBackgroundEnabled(false);
        data.setValueLabelsTextColor(Color.GRAY);
        data.setSlicesSpacing(1);
        piechart.setPieChartData(data);
    }

    private LayoutInflater mInflater;
    private Context mContext;
    private View mView;
    private GoodsInfo mData;
    private TextView txtSimpleType, txtProductName, txtAmount;
    private PieChartView piechart;

}
