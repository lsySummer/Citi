package nju.financecity_android.controller.activity;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TableRow;

import org.apache.http.impl.conn.AbstractClientConnAdapter;

import java.util.ArrayList;
import java.util.List;

import nju.financecity_android.R;
import nju.financecity_android.controller.widget.Bar;
import nju.financecity_android.controller.widget.Choose;
import nju.financecity_android.controller.widget.Key;
import nju.financecity_android.controller.widget.Onoff;

/**
 * Created by Administrator on 2016/9/3.
 */
public class ProductSearch extends Fragment implements View.OnClickListener{
    /**产品搜索主页面*/
    private static LinearLayout product_search_layout;
    /**产品搜索筛选器*/
    private static LinearLayout product_search_filter_layout;
    /**产品搜索结果*/
    private static LinearLayout product_search_result_layout;
    /**产品搜索筛选器列表*/
    private static RelativeLayout product_search_filter_list_layout;
    /**产品搜索结果列表*/
    private static ListView product_search_result_listview;

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
        this.product_search_layout=(LinearLayout)getView().findViewById(R.id.product_search_layout);
        this.product_search_filter_layout =(LinearLayout)getView().findViewById(R.id.product_search_filter_layout);
        this.product_search_result_layout=(LinearLayout)getView().findViewById(R.id.product_search_result_layout);
        this.product_search_filter_list_layout=(RelativeLayout) getView().findViewById(R.id.product_search_filter_list_layout);
        this.product_search_result_listview =(ListView)getView().findViewById(R.id.product_search_result_listview);
        setSearchAll();
    }

    public void setSearch(int n)
    {
        Key key=new Key(getActivity());
        key.setId(R.id.key);
        final Choose choose=new Choose(this.getActivity());
        choose.setId(R.id.choose);

        key.setKey_text("关键字");
        choose.setChoose_text("筛选");
        final List<Integer> spinner2_resources=new ArrayList<Integer>();
        spinner2_resources.add(R.array.slavery_all);
        spinner2_resources.add(R.array.slavery_bank);
        spinner2_resources.add(R.array.slavery_debt);
        spinner2_resources.add(R.array.slavery_fund);
        spinner2_resources.add(R.array.slavery_insurance);
//            choose.setSpinner_content(R.array.master_destination,spinner2_resources);
        choose.setSpinner1_content(R.array.master_destination);
        choose.setSpinner1_choosed(n);
        choose.setSpinner2_content(R.array.slavery_all);
        choose.setOnItemSelectedListener(
                new Spinner.OnItemSelectedListener()
                {
                    @Override
                    public void onItemSelected(AdapterView<?> av, View v, int pos, long arg3)
                    {
                        choose.setSpinner1_choosed(pos);

                        //修改spinner2的内容
                        choose.setSpinner2_content(spinner2_resources.get(pos));

                        //修改其他筛选器

                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        //nothing
                    }
                },
                new Spinner.OnItemSelectedListener()
                {
                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3)
                    {
                        //TODO
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        //nothing
                    }
                }
        );
        RelativeLayout.LayoutParams param0=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams param1=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        param1.addRule(RelativeLayout.BELOW,R.id.key);

        product_search_filter_list_layout.addView(key,param0);
        product_search_filter_list_layout.addView(choose,param1);
    }

    public void setSearchAll()
    {
        product_search_filter_list_layout.removeAllViews();
        setSearch(0);

        Bar year=new Bar(this.getActivity());
        year.setId(R.id.year);
        Bar limit=new Bar(this.getActivity());
        limit.setId(R.id.limit);
        Onoff close=new Onoff(this.getActivity());
        close.setId(R.id.close);

        year.setBar_text("年化收益率");
        limit.setBar_text("期限");
        close.setOnoff_text("是否封闭");

        RelativeLayout.LayoutParams param2=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams param3=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams param4=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        param2.addRule(RelativeLayout.BELOW,R.id.choose);
        param3.addRule(RelativeLayout.BELOW,R.id.year);
        param4.addRule(RelativeLayout.BELOW,R.id.limit);
        product_search_filter_list_layout.addView(year,param2);
        product_search_filter_list_layout.addView(limit,param3);
        product_search_filter_list_layout.addView(close,param4);

    }

    public void setSearchBank()
    {
        setSearch(1);

        Bar year=new Bar(this.getActivity());
        year.setId(R.id.year1);
        Bar start=new Bar(this.getActivity());
        start.setId(R.id.start);
        Bar limit=new Bar(this.getActivity());
        limit.setId(R.id.limit1);
        Choose advisement=new Choose(this.getActivity());
        advisement.setId(R.id.advisement);
        Choose incometype=new Choose(this.getActivity());
        incometype.setId(R.id.incometype);
        Onoff close=new Onoff(this.getActivity());
        close.setId(R.id.close1);

        year.setBar_text("预计年利率");
        start.setBar_text("起购金额");
        limit.setBar_text("期限");
        advisement.setChoose_text("管理机构");
        incometype.setChoose_text("收益类型");
        close.setOnoff_text("是否封闭");

        RelativeLayout.LayoutParams param2=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams param3=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams param4=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams param5=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams param6=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams param7=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        param2.addRule(RelativeLayout.BELOW,R.id.choose);
        param3.addRule(RelativeLayout.BELOW,R.id.year1);
        param4.addRule(RelativeLayout.BELOW,R.id.start);
        param5.addRule(RelativeLayout.BELOW,R.id.limit1);
        param6.addRule(RelativeLayout.BELOW,R.id.advisement);
        param7.addRule(RelativeLayout.BELOW,R.id.incometype);
        product_search_filter_list_layout.addView(year,param2);
        product_search_filter_list_layout.addView(start,param3);
        product_search_filter_list_layout.addView(limit,param4);
        product_search_filter_list_layout.addView(advisement,param5);
        product_search_filter_list_layout.addView(incometype,param6);
        product_search_filter_list_layout.addView(close,param7);

    }

    public void setSearchDebt()
    {
        setSearch(2);

        Bar year=new Bar(this.getActivity());
        year.setId(R.id.year2);
        Bar limit=new Bar(this.getActivity());
        limit.setId(R.id.limit2);
        Choose end=new Choose(this.getActivity());
        end.setId(R.id.end1);
        Choose state=new Choose(this.getActivity());
        state.setId(R.id.state);

        year.setBar_text("年利率");
        limit.setBar_text("期限");
        end.setChoose_text("到期日");
        state.setChoose_text("状态");

        RelativeLayout.LayoutParams param2=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams param3=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams param4=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams param5=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        param2.addRule(RelativeLayout.BELOW,R.id.choose);
        param3.addRule(RelativeLayout.BELOW,R.id.year2);
        param4.addRule(RelativeLayout.BELOW,R.id.limit2);
        param5.addRule(RelativeLayout.BELOW,R.id.end1);
        product_search_filter_list_layout.addView(year,param2);
        product_search_filter_list_layout.addView(limit,param3);
        product_search_filter_list_layout.addView(end,param4);
        product_search_filter_list_layout.addView(state,param5);
    }

    public void setSearchFund()
    {
        setSearch(3);

        Choose advisement=new Choose(this.getActivity());
        advisement.setId(R.id.advisement1);
        Choose incometype=new Choose(this.getActivity());
        incometype.setId(R.id.incometype1);
        Choose state=new Choose(this.getActivity());
        state.setId(R.id.state1);
        Bar latest=new Bar(this.getActivity());
        latest.setId(R.id.latest);
        Onoff close=new Onoff(this.getActivity());
        close.setId(R.id.close2);
        Onoff sort=new Onoff(this.getActivity());
        sort.setId(R.id.sort);
        Choose limit=new Choose(this.getActivity());
        limit.setId(R.id.limit3);

        advisement.setChoose_text("管理机构");
        incometype.setChoose_text("目标类型");
        state.setChoose_text("状态");
        latest.setBar_text("最新净值");
        close.setOnoff_text("是否封闭");
        sort.setOnoff_text("按近X年收益率排序");
        limit.setChoose_text("期限");

        RelativeLayout.LayoutParams param2=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams param3=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams param4=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams param5=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams param6=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams param7=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams param8=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        param2.addRule(RelativeLayout.BELOW,R.id.choose);
        param3.addRule(RelativeLayout.BELOW,R.id.advisement1);
        param4.addRule(RelativeLayout.BELOW,R.id.incometype1);
        param5.addRule(RelativeLayout.BELOW,R.id.state1);
        param6.addRule(RelativeLayout.BELOW,R.id.latest);
        param7.addRule(RelativeLayout.BELOW,R.id.close2);
        param8.addRule(RelativeLayout.BELOW,R.id.sort);
        product_search_filter_list_layout.addView(advisement,param2);
        product_search_filter_list_layout.addView(incometype,param3);
        product_search_filter_list_layout.addView(state,param4);
        product_search_filter_list_layout.addView(latest,param5);
        product_search_filter_list_layout.addView(close,param6);
        product_search_filter_list_layout.addView(sort,param7);
        product_search_filter_list_layout.addView(limit,param8);
    }

    public void setSearchInsurance()
    {
        setSearch(4);

        Bar year=new Bar(this.getActivity());

        Bar broadcast=new Bar(this.getActivity());
        Choose company=new Choose(this.getActivity());
        Choose value=new Choose(this.getActivity());

        year.setBar_text("年利率");
        broadcast.setBar_text("期限");
        company.setChoose_text("发行公司");
        value.setChoose_text("保险产品金额");

        product_search_filter_list_layout.addView(year);
        product_search_filter_list_layout.addView(broadcast);
        product_search_filter_list_layout.addView(company);
        product_search_filter_list_layout.addView(value);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
        case R.id.product_search_layout:
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            break;
        }

    }
}
