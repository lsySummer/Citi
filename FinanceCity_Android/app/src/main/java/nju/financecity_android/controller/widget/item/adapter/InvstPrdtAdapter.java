package nju.financecity_android.controller.widget.item.adapter;

/**
 * Created by coral on 16-9-9.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import nju.financecity_android.R;
import nju.financecity_android.controller.widget.item.InvestmentListItem;
import nju.financecity_android.vo.ProductInfo;

import java.util.List;

/**
 * Created by coral on 16-8-26.
 */
public class InvstPrdtAdapter extends BaseAdapter {

    public InvstPrdtAdapter(Context context, List<ProductInfo> data) {
        this.mContext = context;
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
        InvestmentListItem item = new InvestmentListItem(mContext, convertView, mData.get(position));
        return item.getView();
    }

    private Context mContext;
    private List<ProductInfo> mData;
}