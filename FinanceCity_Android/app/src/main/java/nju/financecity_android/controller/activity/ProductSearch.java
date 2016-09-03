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
import android.widget.TableRow;

import org.apache.http.impl.conn.AbstractClientConnAdapter;

import nju.financecity_android.R;
import nju.financecity_android.controller.widget.Bar;
import nju.financecity_android.controller.widget.Choose;
import nju.financecity_android.controller.widget.Key;
import nju.financecity_android.controller.widget.Onoff;

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
    private LinearLayout product_search_filter_list_layout;
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
        initProduct_search();
    }

    public void initProduct_search() {
        this.product_search_filter_layout =(LinearLayout)getView().findViewById(R.id.product_search_filter_layout);
        this.product_search_result_layout=(LinearLayout)getView().findViewById(R.id.product_search_result_layout);
        this.product_search_filter_list_layout=(LinearLayout) getView().findViewById(R.id.product_search_filter_list_layout);
        this.product_search_result_listview =(ListView)getView().findViewById(R.id.product_search_result_listview);
        setSearchAll();
    }

    public void setSearchAll()//TODO
    {
        Key key=new Key(this.getActivity());
        Choose choose=new Choose(this.getActivity());
        Bar year=new Bar(this.getActivity());
        Bar limit=new Bar(this.getActivity());
        Onoff close=new Onoff(this.getActivity());

        key.setKey_text("关键字");
        choose.setChoose_text("筛选");
        year.setBar_text("年化收益率");
        limit.setBar_text("期限");
        close.setOnoff_text("是否封闭");

        product_search_filter_list_layout.addView(key);
        product_search_filter_list_layout.addView(choose);
        product_search_filter_list_layout.addView(year);
        product_search_filter_list_layout.addView(limit);
        product_search_filter_list_layout.addView(close);

    }

    public void setSearchBank()
    {
        Key key=new Key(this.getActivity());
        Choose choose=new Choose(this.getActivity());
        Bar year=new Bar(this.getActivity());
        Bar start=new Bar(this.getActivity());
        Bar limit=new Bar(this.getActivity());
        Choose advisement=new Choose(this.getActivity());
        Choose incometype=new Choose(this.getActivity());
        Onoff close=new Onoff(this.getActivity());

        key.setKey_text("关键字");
        choose.setChoose_text("筛选");
        year.setBar_text("预计年利率");
        start.setBar_text("起购金额");
        limit.setBar_text("期限");
        advisement.setChoose_text("管理机构");
        incometype.setChoose_text("收益类型");
        close.setOnoff_text("是否封闭");


        product_search_filter_list_layout.addView(key);
        product_search_filter_list_layout.addView(choose);
        product_search_filter_list_layout.addView(year);
        product_search_filter_list_layout.addView(start);
        product_search_filter_list_layout.addView(limit);
        product_search_filter_list_layout.addView(advisement);
        product_search_filter_list_layout.addView(incometype);
        product_search_filter_list_layout.addView(close);

    }

    public void setSearchDebt()
    {
        Key key=new Key(this.getActivity());
        Choose choose=new Choose(this.getActivity());
        Bar year=new Bar(this.getActivity());
        Bar limit=new Bar(this.getActivity());
        Choose end=new Choose(this.getActivity());
        Choose state=new Choose(this.getActivity());

        key.setKey_text("关键字");
        choose.setChoose_text("筛选");
        year.setBar_text("年利率");
        limit.setBar_text("期限");
        end.setChoose_text("到期日");
        state.setChoose_text("状态");


        product_search_filter_list_layout.addView(key);
        product_search_filter_list_layout.addView(choose);
        product_search_filter_list_layout.addView(year);
        product_search_filter_list_layout.addView(limit);
        product_search_filter_list_layout.addView(end);
        product_search_filter_list_layout.addView(state);
    }

    public void setSearchFund()
    {
        Key key=new Key(this.getActivity());
        Choose choose=new Choose(this.getActivity());
        Choose advisement=new Choose(this.getActivity());
        Choose incometype=new Choose(this.getActivity());
        Choose state=new Choose(this.getActivity());
        Bar latest=new Bar(this.getActivity());
        Onoff close=new Onoff(this.getActivity());
        Onoff sort=new Onoff(this.getActivity());
        Choose limit=new Choose(this.getActivity());

        key.setKey_text("关键字");
        choose.setChoose_text("筛选");
        advisement.setChoose_text("管理机构");
        incometype.setChoose_text("目标类型");
        state.setChoose_text("状态");
        latest.setBar_text("最新净值");
        close.setOnoff_text("是否封闭");
        sort.setOnoff_text("按收益率排序");
        limit.setChoose_text("期限");


        product_search_filter_list_layout.addView(key);
        product_search_filter_list_layout.addView(choose);
        product_search_filter_list_layout.addView(advisement);
        product_search_filter_list_layout.addView(incometype);
        product_search_filter_list_layout.addView(state);
        product_search_filter_list_layout.addView(latest);
        product_search_filter_list_layout.addView(close);
        product_search_filter_list_layout.addView(sort);
        product_search_filter_list_layout.addView(limit);
    }

    public void setSearchInsurance()
    {
        Key key=new Key(this.getActivity());
        Choose choose=new Choose(this.getActivity());
        Bar year=new Bar(this.getActivity());
        Bar broadcast=new Bar(this.getActivity());
        Choose company=new Choose(this.getActivity());
        Choose value=new Choose(this.getActivity());

        key.setKey_text("关键字");
        choose.setChoose_text("筛选");
        year.setBar_text("年利率");
        broadcast.setBar_text("期限");
        company.setChoose_text("发行公司");
        value.setChoose_text("保险产品金额");

        product_search_filter_list_layout.addView(key);
        product_search_filter_list_layout.addView(choose);
        product_search_filter_list_layout.addView(year);
        product_search_filter_list_layout.addView(broadcast);
        product_search_filter_list_layout.addView(company);
        product_search_filter_list_layout.addView(value);
    }
}
