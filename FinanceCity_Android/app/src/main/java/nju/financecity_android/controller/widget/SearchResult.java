package nju.financecity_android.controller.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import nju.financecity_android.R;
import nju.financecity_android.vo.ProductVO;

/**
 * Created by Administrator on 2016/9/6.
 */
public class SearchResult extends ScrollView {
    private List<ProductVO> resultList=new ArrayList<ProductVO>();
    private LinearLayout listLayout;

    public SearchResult(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.product_search_result, this, true);
        onFinishInflate();
    }

    public SearchResult(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.product_search_result, this, true);
        onFinishInflate();
    }
    public SearchResult(Context context,List<ProductVO> list) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.product_search_result, this, true);
        resultList=list;
        onFinishInflate();

    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        listLayout=(LinearLayout) findViewById(R.id.product_search_result_layout);
        for(int i=0;i<resultList.size();i++) {
            View single=new SingleSearchResult(getContext(),resultList.get(i));
            listLayout.addView(single);
        }
    }
}
