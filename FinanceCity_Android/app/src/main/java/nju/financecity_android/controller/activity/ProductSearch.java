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
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;

import org.apache.http.impl.conn.AbstractClientConnAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import nju.financecity_android.R;
import nju.financecity_android.controller.widget.Bar;
import nju.financecity_android.controller.widget.Choose;
import nju.financecity_android.controller.widget.Key;
import nju.financecity_android.controller.widget.Onoff;
import nju.financecity_android.vo.ProductInfo;

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
    private static LinearLayout product_search_filter_list_layout;
    /**产品搜索结果列表*/
    private static ListView product_search_result_listview;
    private ArrayList<HashMap<String,Object>> resultList;
    private SimpleAdapter resultAdapter;

    /**搜索按钮*/
    private static Button product_search_filter_button;

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
        initProduct_result();
    }

    public void initProduct_search() {
        this.product_search_layout=(LinearLayout)getView().findViewById(R.id.product_search_layout);
        this.product_search_filter_layout =(LinearLayout)getView().findViewById(R.id.product_search_filter_layout);
        this.product_search_filter_list_layout=(LinearLayout) getView().findViewById(R.id.product_search_filter_list_layout);

        this.product_search_filter_button=(Button)getView().findViewById(R.id.product_search_filter_button);
        this.product_search_filter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                product_search_result_listview TODO 显示搜索结果
                ArrayList<ProductInfo> list=new ArrayList<ProductInfo>();
                ProductInfo pi1=new ProductInfo();
                pi1.productName="some name";
                pi1.currPrice=100.8;
                list.add(pi1);
                setResult(list);
            }
        });

        setSearchAll();
    }

    public void initProduct_result()
    {
        this.product_search_result_layout=(LinearLayout)getView().findViewById(R.id.product_search_result_layout);
        this.product_search_result_listview =(ListView)getView().findViewById(R.id.product_search_result_listview);
        this.resultList=new ArrayList<HashMap<String,Object>>();
        /*===============================*/
        HashMap<String,Object> map1=new HashMap<String, Object>();
        map1.put("product","product1");
        map1.put("introduction","introduction1");
        this.resultList.add(map1);

        HashMap<String,Object> map2=new HashMap<String, Object>();
        map2.put("product","product2");
        map2.put("introduction","introduction2");
        this.resultList.add(map2);

        HashMap<String,Object> map3=new HashMap<String, Object>();
        map3.put("product","product3");
        map3.put("introduction","introduction3");
        this.resultList.add(map3);
        /*===============================*/
        this.resultAdapter=new SimpleAdapter(getActivity(),resultList,R.layout.product_search_result_element,new String[]{"product","introduction"},new int[]{R.id.search_result_element_product,R.id.search_result_element_introduction});
        this.product_search_result_listview.setAdapter(resultAdapter);

    }

    public void setSearch(int n)
    {

        final Choose choose=new Choose(this.getActivity());
        choose.setId(R.id.choose);
        Key key=new Key(getActivity());
        key.setId(R.id.key);

        choose.setChoose_text("筛选");
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

                            //修改spinner2的内容和其他筛选器
                            switch(pos)
                            {
                                case 0:
                                    choose.setSpinner2_content(R.array.slavery_all);
                                    setSearchAll();
                                    break;
                                case 1:
                                    choose.setSpinner2_content(R.array.slavery_bank);
                                    setSearchBank();
                                    break;
                                case 2:
                                    choose.setSpinner2_content(R.array.slavery_debt);
                                    setSearchBond();
                                    break;
                                case 3:
                                    choose.setSpinner2_content(R.array.slavery_fund);
                                    setSearchFund();
                                    break;
                                case 4:
                                    choose.setSpinner2_content(R.array.slavery_insurance);
                                    setSearchInsurance();
                                    break;
                            }
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
        key.setKey_text("关键字");


        product_search_filter_list_layout.addView(choose);
        product_search_filter_list_layout.addView(key);
    }

    public void setSearchAll()
    {
        product_search_filter_list_layout.removeAllViews();
        setSearch(0);

        Bar year=new Bar(this.getActivity());
        year.setId(R.id.year);
        Bar limit=new Bar(this.getActivity());
        limit.setId(R.id.limit);
        final Onoff close=new Onoff(this.getActivity());
        close.setId(R.id.close);

        year.setBar_text("年化收益率");
            year.setStart(0);
            year.setEnd(15);
            year.setInterval(0.0001f);
            year.setUnit("%");
        limit.setBar_text("期限");
            limit.setStart(0);
            limit.setEnd(60*30);
            limit.setInterval(1);
            limit.setUnit("天");
        close.setOnoff_text("是否封闭");
            close.setOnoff_switch(false);
            close.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    close.setOnoff_switch(b);
                }
            });

        product_search_filter_list_layout.addView(year);
        product_search_filter_list_layout.addView(limit);
        product_search_filter_list_layout.addView(close);

    }

    public void setSearchBank()
    {
        product_search_filter_list_layout.removeAllViews();
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
        final Onoff close=new Onoff(this.getActivity());
        close.setId(R.id.close1);

        year.setBar_text("预计年化利率");
            year.setStart(0);
            year.setEnd(15);
            year.setInterval(0.0001f);
            year.setUnit("%");
        start.setBar_text("起购金额");
            start.setStart(0);
            start.setEnd(1000000);
            start.setInterval(0.0001f);
            start.setUnit("元");
        limit.setBar_text("期限");
            limit.setStart(0);
            limit.setEnd(60*30);
            limit.setInterval(1);
            limit.setUnit("天");
        advisement.setChoose_text("管理机构");
            advisement.setSpinner1_content(new String[]{"1","2","3"});//TODO get agents from API
            advisement.setSpinner2Visible(View.INVISIBLE);
        incometype.setChoose_text("收益类型");
            incometype.setSpinner1_content(R.array.bank_incometype);
            incometype.setSpinner2Visible(View.INVISIBLE);
        close.setOnoff_text("是否封闭");
            close.setOnoff_switch(false);
            close.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    close.setOnoff_switch(b);
                }
            });

        product_search_filter_list_layout.addView(year);
        product_search_filter_list_layout.addView(start);
        product_search_filter_list_layout.addView(limit);
        product_search_filter_list_layout.addView(advisement);
        product_search_filter_list_layout.addView(incometype);
        product_search_filter_list_layout.addView(close);

    }

    public void setSearchBond()
    {
        product_search_filter_list_layout.removeAllViews();
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
            year.setStart(0);
            year.setEnd(10);
            year.setInterval(0.0001f);
            year.setUnit("%");
        limit.setBar_text("期限");
            limit.setStart(0);
            limit.setEnd(60*30);
            limit.setInterval(1);
            limit.setUnit("天");
        end.setChoose_text("到期日");
            Calendar cal= Calendar.getInstance();
            int cal_year=cal.get(Calendar.YEAR);
            String[] years=new String[10];
            for(int i=0;i<10;i++)
            {
                years[i]=cal_year+i+"";
            }
            end.setSpinner1_content(years);
            end.setSpinner2Visible(View.INVISIBLE);
        state.setChoose_text("状态");
            state.setSpinner1_content(R.array.bond_state);
            state.setSpinner2Visible(View.INVISIBLE);


        product_search_filter_list_layout.addView(year);
        product_search_filter_list_layout.addView(limit);
        product_search_filter_list_layout.addView(end);
        product_search_filter_list_layout.addView(state);
    }

    public void setSearchFund()
    {
        product_search_filter_list_layout.removeAllViews();
        setSearch(3);

        Choose advisement=new Choose(this.getActivity());
        advisement.setId(R.id.advisement1);
        Choose state=new Choose(this.getActivity());
        state.setId(R.id.state1);
        Bar latest=new Bar(this.getActivity());
        latest.setId(R.id.latest);
        final Onoff close=new Onoff(this.getActivity());
        close.setId(R.id.close2);
        Key sort=new Key(this.getActivity());
        sort.setId(R.id.sort);

        advisement.setChoose_text("管理机构");
            advisement.setSpinner1_content(new String[]{"1","2","3"});//TODO get agents from API
            advisement.setSpinner2Visible(View.INVISIBLE);
        state.setChoose_text("状态");
            state.setSpinner1_content(R.array.fund_state);
            state.setSpinner2Visible(View.INVISIBLE);
        latest.setBar_text("最新净值");
            latest.setStart(0);
            latest.setEnd(10);
            latest.setInterval(0.0001f);
            latest.setUnit("");
        close.setOnoff_text("是否封闭");
            close.setOnoff_switch(false);
            close.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    close.setOnoff_switch(b);
                }
            });
        sort.setKey_text("按近X年收益率排序");

        product_search_filter_list_layout.addView(advisement);
        product_search_filter_list_layout.addView(state);
        product_search_filter_list_layout.addView(latest);
        product_search_filter_list_layout.addView(close);
        product_search_filter_list_layout.addView(sort);
    }

    public void setSearchInsurance()
    {
        product_search_filter_list_layout.removeAllViews();
        setSearch(4);

        Bar year=new Bar(this.getActivity());
        year.setId(R.id.year3);
        Choose broadcast=new Choose(this.getActivity());
        broadcast.setId(R.id.broadcast);
        Choose company=new Choose(this.getActivity());
        company.setId(R.id.company);
        Bar value=new Bar(this.getActivity());
        value.setId(R.id.value);

        year.setBar_text("年化收益率");
            year.setStart(0);
            year.setEnd(10);
            year.setInterval(0.0001f);
            year.setUnit("%");
        broadcast.setChoose_text("保障年限");
            broadcast.setSpinner1_content(R.array.insurance_year);
            broadcast.setSpinner2Visible(View.INVISIBLE);
        company.setChoose_text("产品发行公司");
            company.setSpinner1_content(new String[]{"1","2","3"});//TODO get agents from API
            company.setSpinner2Visible(View.INVISIBLE);
        value.setBar_text("保险产品面额");
            value.setStart(0);
            value.setEnd(50000);
            value.setInterval(1);
            value.setUnit("元");

        product_search_filter_list_layout.addView(year);
        product_search_filter_list_layout.addView(broadcast);
        product_search_filter_list_layout.addView(company);
        product_search_filter_list_layout.addView(value);
    }

    public void setResult(ArrayList<ProductInfo> list)
    {
        this.resultList.clear();
        for(int i=0;i<list.size();i++)
        {
            ProductInfo pInfo=list.get(i);
            HashMap<String,Object> map=new HashMap<String,Object>();
            map.put("product",pInfo.productName);
            map.put("introduction",pInfo.currPrice+"");//TODO 这里可能有改动
            resultList.add(map);
        }
        this.resultAdapter=new SimpleAdapter(getActivity(),resultList,R.layout.product_search_result_element,new String[]{"product","introduction"},new int[]{R.id.search_result_element_product,R.id.search_result_element_introduction});
        this.product_search_result_listview.setAdapter(resultAdapter);
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
