package nju.financecity_android.controller.activity;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import nju.financecity_android.R;
import nju.financecity_android.controller.widget.Banner;
import nju.financecity_android.controller.widget.item.adapter.RecommendListAdapter;
import nju.financecity_android.vo.GoodsInfo;

import java.util.ArrayList;
import java.util.List;

public class RecommendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);
        initComponents();

    }

    private void initComponents() {

        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("推荐组合1").setContent(R.id.recPane));
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("推荐组合2").setContent(R.id.recPane));
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("推荐组合3").setContent(R.id.recPane));
        txtSum = (TextView) findViewById(R.id.txtSum);
        reclist = (ListView) findViewById(R.id.reclist);
        banner = (Banner) findViewById(R.id.banner);
        banner.setDisplayText("推荐购买");
        banner.setBtBackOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecommendActivity.this.finish();
            }
        });

        List<GoodsInfo> data = new ArrayList<>();
        GoodsInfo info = new GoodsInfo();
        info.amount = 1000;
        info.type = "银行";
        info.goodsName = "这是一个银行理财产品";
        data.add(info);
        info = new GoodsInfo();
        info.amount = 100;
        info.type = "基金";
        info.goodsName = "这是一个位置产品";
        data.add(info);
        info = new GoodsInfo();
        info.amount = 2000;
        info.type = "债券";
        info.goodsName = "这是一个66666的产品";
        data.add(info);
        info = new GoodsInfo();
        info.amount = 3000;
        info.type = "保险";
        info.goodsName = "这是一个23333产品";
        data.add(info);
        setRecommendData(data);
    }

    public void setCurrPage(int id) {
        tabHost.setCurrentTab(id);
    }

    private void setRecommendData(List<GoodsInfo> data) {
        RecommendListAdapter adapter = new RecommendListAdapter(this, data);
        reclist.setAdapter(adapter);
    }

    private ListView reclist;
    private TextView txtSum;
    private TabHost tabHost;
    private Banner banner;
}
