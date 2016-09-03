package nju.financecity_android.controller.activity;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.apache.http.impl.conn.AbstractClientConnAdapter;

import nju.financecity_android.R;

/**
 * Created by Administrator on 2016/9/3.
 */
public class ProductSearch extends Fragment{
    /**产品搜索主页面*/
    private LinearLayout product_search_layout;
    /**产品搜索筛选器*/
    private LinearLayout product_search_filter_layout;
    /**产品搜索结果*/
    private LinearLayout product_search_result_layout;
    /**产品搜索筛选器列表*/
    private ListView product_search_filter_listview;
    /**产品搜索结果列表*/
    private ListView product_search_result_listview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product_search, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        setProduct_search_filter_layout();
        setProduct_search_result_layout();
        setProduct_search_filter_listview();
        setProduct_search_result_listview();
    }

    public void setProduct_search_filter_layout() {
        this.product_search_filter_layout =(LinearLayout)getView().findViewById(R.id.product_search_filter_layout);
    }

    public void setProduct_search_result_layout() {
        this.product_search_result_layout=(LinearLayout)getView().findViewById(R.id.product_search_result_layout);
    }

    public void setProduct_search_filter_listview() {
        this.product_search_filter_listview=(ListView)getView().findViewById(R.id.product_search_filter_listview);
    }

    public void setProduct_search_result_listview() {
        this.product_search_result_listview =(ListView)getView().findViewById(R.id.product_search_result_listview);
    }

    public void addSearch()
    {

//        SimpleAdapter adapter=new SimpleAdapter(this.getActivity(),list,R.layout.product_search_filter_element);
//        product_search_filter_listview.setAdapter(adapter);
    }
}
