package nju.financecity_android.controller.widget.item.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import nju.financecity_android.controller.widget.item.RecommendItem;
import nju.financecity_android.vo.GoodsInfo;

import java.util.List;

/**
 * Created by coral on 16-9-15.
 */
public class RecommendListAdapter extends BaseAdapter {

    public RecommendListAdapter(Context context, List<GoodsInfo> data) {
        this.mContext = context;
        this.mData = data;
        sum = 0;
        for (GoodsInfo info: mData) {
            sum += info.amount;
        }
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
        return 0L;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RecommendItem item = new RecommendItem(mContext, convertView, (GoodsInfo) getItem(position));
        item.setChartInfo(mData.get(position).amount, sum);
        return item.getView();
    }

    private float sum;
    private Context mContext;
    private List<GoodsInfo> mData;
}
