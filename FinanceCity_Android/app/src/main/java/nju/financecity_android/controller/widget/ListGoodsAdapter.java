package nju.financecity_android.controller.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import nju.financecity_android.R;
import nju.financecity_android.controller.widget.GoodsItemWithPrice;
import nju.financecity_android.controller.widget.GoodsItemWithoutPrice;
import nju.financecity_android.vo.GoodsInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coral on 16-9-9.
 */
public class ListGoodsAdapter extends BaseAdapter {

    public ListGoodsAdapter(Context context, List<GoodsInfo> data) {
        mData = new ArrayList<>();
        mInflater = LayoutInflater.from(context);
        mContext = context;
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
        return Long.parseLong(mData.get(position).goodsId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        GoodsInfo goodsInfo = (GoodsInfo) getItem(position);
        if (goodsInfo.type.equals("基金")) {
            view = mInflater.inflate(R.layout.goods_list_item_fund, null);
            GoodsItemWithoutPrice item = new GoodsItemWithoutPrice(mContext, view, (GoodsInfo) getItem(position));
        } else if (goodsInfo.type.equals("银行") || goodsInfo.type.equals("债券")) {
            view = mInflater.inflate(R.layout.goods_list_item_bank, null);
            GoodsItemWithPrice item = new GoodsItemWithPrice(mContext, view, (GoodsInfo) getItem(position));
        }
        return view;
    }

    private Context mContext;
    private LayoutInflater mInflater;
    private List<GoodsInfo> mData;
}