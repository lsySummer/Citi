package nju.financecity_android.controller.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RunnableFuture;

import nju.financecity_android.R;
import nju.financecity_android.controller.widget.AllSearch;
import nju.financecity_android.controller.widget.BankSearch;
import nju.financecity_android.controller.widget.BondSearch;
import nju.financecity_android.controller.widget.FundSearch;
import nju.financecity_android.controller.widget.InsuranceSearch;
import nju.financecity_android.controller.widget.SearchResult;
import nju.financecity_android.controller.widget.SingleSearchResult;
import nju.financecity_android.dao.SearchDao;
import nju.financecity_android.model.SearchProduct;
import nju.financecity_android.vo.ProductVO;

/**
 * Created by Administrator on 2016/9/3.
 */
public class ProductSearch extends Fragment{
    /**产品搜索体*/
    private RelativeLayout product_search__body;
    private SearchResult searchResult;

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
//        searchResult=new SearchResult(getActivity());
//        new Thread(new Runnable(){//TODO 此处应加载所有产品
//            @Override
//            public void run() {
                    List<ProductVO> list=new ArrayList<ProductVO>();
                    /*=======================================================================================*/
                    list.add(new ProductVO("sh600000","稳利80","bank",3.57,"这是平安银行的理财产品"));
                    list.add(new ProductVO("dghesct","万科债券","bond",5.67,"这是万科的企业债券"));
                    list.add(new ProductVO("100001","中国人寿","insurance",2.05,"这是中国人寿的分红险种"));
                    list.add(new ProductVO("567uu9","伊尔基金","fund",2.67,"这是平安银行的理财产品"));
                    list.add(new ProductVO("wnr300006","我瞎编的","bond",100.67,"这是一款暴利基金"));
                    /*=======================================================================================*/
                    searchResult=new SearchResult(getActivity(),list);
//            }
//        }).start();

        this.product_search__body=(RelativeLayout) getView().findViewById(R.id.body);
        product_search__body.addView(searchResult);

        //关键字搜索框
        EditText key=(EditText)getView().findViewById(R.id.key_putin);
        //主筛选框
        Spinner master=(Spinner)getView().findViewById(R.id.master_spinner);
        ArrayAdapter<String> master_adapter=new ArrayAdapter<String>(getActivity(),R.layout.spinner_element,getResources().getStringArray(R.array.master_destination));
        master.setAdapter(master_adapter);
        //副筛选框
        final Spinner slavery=(Spinner)getView().findViewById(R.id.slavery_spinner);
        ArrayAdapter<String> slavery_adapter=new ArrayAdapter<String>(getActivity(),R.layout.spinner_element,getResources().getStringArray(R.array.slavery_all));
        slavery.setAdapter(slavery_adapter);
        final ArrayAdapter<String>[] adapter=new ArrayAdapter[]{slavery_adapter};

        final int[] selector={0,0};
        final ArrayList<String[]> content=new ArrayList<String[]>();
        content.add(getResources().getStringArray(R.array.slavery_all));
        content.add(getResources().getStringArray(R.array.slavery_bank));
        content.add(getResources().getStringArray(R.array.slavery_bond));
        content.add(getResources().getStringArray(R.array.slavery_fund));
        content.add(getResources().getStringArray(R.array.slavery_insurance));
        final View[] filter=new View[]{new AllSearch(getActivity())};
        final boolean[] isPicked={false};
        master.setOnItemSelectedListener(
                new Spinner.OnItemSelectedListener()
                {
                    @Override
                    public void onItemSelected(AdapterView<?> av, View v, int pos, long arg3)
                    {
                        selector[0]=pos;
                        //修改slavery的内容
                        adapter[0]=new ArrayAdapter<String>(getActivity(),R.layout.spinner_element,content.get(pos));
                        slavery.setAdapter(adapter[0]);
                        switch (selector[0]) {
                            case 0:
                                product_search__body.removeAllViews();
                                View all = new AllSearch(getActivity());
                                filter[0]=all;
                                break;
                            case 1:
                                product_search__body.removeAllViews();
                                View bank = new BankSearch(getActivity());
                                filter[0]=bank;
                                break;
                            case 2:
                                product_search__body.removeAllViews();
                                View bond = new BondSearch(getActivity());
                                filter[0]=bond;
                                break;
                            case 3:
                                product_search__body.removeAllViews();
                                View fund = new FundSearch(getActivity());
                                filter[0]=fund;
                                break;
                            case 4:
                                product_search__body.removeAllViews();
                                View insurance = new InsuranceSearch(getActivity());
                                filter[0]=insurance;
                                break;
                        }
                        if(isPicked[0])
                        {
                            product_search__body.removeAllViews();
                            product_search__body.addView(filter[0]);
                        }
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        //nothing
                    }
                }
        );

        slavery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selector[1]=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //搜索按钮
        Button search=(Button)getView().findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 关键字和条件一起搜索得到产品信息列表
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
                    /*=======================================================================================*/
                List<ProductVO> list = new ArrayList<ProductVO>();
                list.add(new ProductVO("1hfds001", "中国人寿", "insurance", 2.05,SearchProduct.analyse().toString()
                ));//"这是中国人寿的分红险种"));
                list.add(new ProductVO("s4fd70000", "稳利80", "fund", 3.57, "这是平安银行的理财产品"));
                list.add(new ProductVO("dghesct", "万科债券", "bond", 5.67, "这是万科的企业债券"));
                list.add(new ProductVO("wnr04bhf", "我瞎编的", "bond", 100.67, "这是一款暴利基金"));
                list.add(new ProductVO("567uu9", "伊尔基金", "fund", 2.67, "这是一首简单的小~情~歌~，唱出.."));
                    /*=======================================================================================*/
//                    }
//                }).start();

                searchResult = new SearchResult(getActivity(), list);
                isPicked[0] = false;
                product_search__body.removeAllViews();
                product_search__body.addView(searchResult);

            }
        });
        //筛选按钮
        Button pick=(Button)getView().findViewById(R.id.pick);
        pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isPicked[0]=!isPicked[0];
                product_search__body.removeAllViews();
                product_search__body.addView(filter[0]);
            }
        });
        //返回按钮
        ImageButton back=(ImageButton)getView().findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_search__body.removeAllViews();
                product_search__body.addView(searchResult);
            }
        });

    }
}
