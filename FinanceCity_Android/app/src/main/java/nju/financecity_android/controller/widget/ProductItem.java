package nju.financecity_android.controller.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import nju.financecity_android.R;
import nju.financecity_android.util.TimeString;
import nju.financecity_android.vo.ProductInfo;

import java.util.List;

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

    public void setProductName(String productName) {
        txtPdtName.setText(productName);
    }

    public void setIncreasingRate(double rate) {
        String strRate = String.valueOf(rate * 100).substring(0, 3) + "%";
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

    /**
     * Created by coral on 16-8-26.
     */
    public static class InvstPrdtAdapter extends BaseAdapter {

        public InvstPrdtAdapter(Context context, List<ProductInfo> data) {
            mInflater = LayoutInflater.from(context);
            mData = data;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = (convertView == null) ? mInflater.inflate(R.layout.investment_item, null) : convertView;

            ProductInfo info = mData.get(position);

            TextView txtPdtName = (TextView) view.findViewById(R.id.txtPdtName);
            txtPdtName.setText(info.productName);

            TextView txtAvlblTime = (TextView) view.findViewById(R.id.txtAvlblTime);
            txtAvlblTime.setText(TimeString.getTimeByDate(info.available));

            TextView txtBuyPrice = (TextView) view.findViewById(R.id.txtBuyPrice);
            txtBuyPrice.setText("￥" + info.buyPrice);

            TextView txtBuyTime = (TextView) view.findViewById(R.id.txtBuyTime);
            txtBuyTime.setText(TimeString.getTimeByDate(info.buy));

            TextView txtCurrPrice = (TextView) view.findViewById(R.id.txtCurrPrice);
            txtCurrPrice.setText("(￥" + info.currPrice + ")");

            TextView txtExpiration = (TextView) view.findViewById(R.id.txtExpiration);
            txtExpiration.setText(TimeString.getTimeByDate(info.expiration));

            TextView txtIncRate = (TextView) view.findViewById(R.id.txtIncRate);
            if (info.buyPrice == 0 || info.buyPrice == info.currPrice) {
                txtIncRate.setText("--");
                txtIncRate.setTextColor(view.getResources().getColor(R.color.abc_primary_text_material_dark));
            }
            double incRate = (info.currPrice - info.buyPrice) / info.buyPrice * 100;
            String strIncRate = String.valueOf(incRate);
            if (strIncRate.length() > 4) {
                strIncRate = strIncRate.substring(0, 4);
            }
            txtIncRate.setText(strIncRate + "%");
            if (incRate > 0)
                txtIncRate.setTextColor(view.getResources().getColor(R.color.increasingRed));
            else
                txtIncRate.setTextColor(view.getResources().getColor(R.color.decreasingGreen));
            return view;
        }

        private LayoutInflater mInflater;
        private List<ProductInfo> mData;
    }
}
