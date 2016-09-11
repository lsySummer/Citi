package nju.financecity_android.controller.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import nju.financecity_android.R;
import nju.financecity_android.controller.widget.item.adapter.PropertyListAdapter;
import nju.financecity_android.model.ProductFund;
import nju.financecity_android.vo.PropertyVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FundDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund_detail);
        initComponents();

        Intent intent = getIntent();
        String productId = intent.getStringExtra("productId");
        Map data = (new ProductFund(productId)).getProperties();
        processData(data);
    }

    protected void setHeaderInfo(String productName, String interestRate, String netValue, String state) {
        txtInterestRate.setText(interestRate);
        txtPrdtName.setText(productName);
        txtNewestNetValue.setText(netValue);
        txtState.setText(state);
    }

    private void processData(Map data) {
        String productName = data.get("法定名称").toString();
        String interestRate = data.get("近一年收益率").toString();
        String netValue = data.get("最新净值").toString();
        String state = data.get("状态").toString();
        setHeaderInfo(productName, interestRate, netValue, state);

        List<PropertyVO> properties = new ArrayList<>();
        Collections.addAll(properties,
                new PropertyVO("基本信息", "", R.color.validBlue, 0),
                new PropertyVO("法定名称", productName),
                new PropertyVO("基金编号", data.get("基金编号")),
                new PropertyVO("管理机构", data.get("管理机构")),
                new PropertyVO("托管机构", data.get("托管机构")),
                new PropertyVO("", data.get("")),

                new PropertyVO("风险收益", "", R.color.validBlue, 0),
                new PropertyVO("近一年收益率", data.get("近一年收益率")),
                new PropertyVO("最新净值", data.get("最新净值")),
                new PropertyVO("基金投资目标类型", data.get("基金投资目标类型")),
                new PropertyVO("业绩比较基准", data.get("业绩比较基准")),
                new PropertyVO("跟踪标的", data.get("跟踪标的")),
                new PropertyVO("风险等级", data.get("风险等级")),
                new PropertyVO("", data.get("")),

                new PropertyVO("申购赎回", "", R.color.validBlue, 0),
                new PropertyVO("状态", data.get("状态")),
                new PropertyVO("是否封闭", data.get("是否封闭")),
                new PropertyVO("申购费率", data.get("申购费率")),
                new PropertyVO("认购费率", data.get("认购费率")),
                new PropertyVO("赎回费率", data.get("赎回费率")),
                new PropertyVO("广义管理费率", data.get("广义管理费率")),
                new PropertyVO("递增购买最小单位", data.get("递增购买最小单位")),
                new PropertyVO("募集开始日", data.get("募集开始日")),
                new PropertyVO("募集截止日", data.get("募集截止日")),
                new PropertyVO("起息日", data.get("起息日")),
                new PropertyVO("开发日", data.get("开发日")),
                new PropertyVO("期限", data.get("期限")),
                new PropertyVO("认购速度", data.get("认购速度")),
                new PropertyVO("赎回速度", data.get("赎回速度")),
                new PropertyVO("", data.get("")),


                new PropertyVO("其他", "", R.color.validBlue, 0),
                new PropertyVO("基金经理", data.get("基金经理")),
                new PropertyVO("基金规模", data.get("基金规模")),
                new PropertyVO("份额规模", data.get("份额规模")));
        setProperties(properties);
    }

    protected void setProperties(List<PropertyVO> properties) {
        PropertyListAdapter adapter = new PropertyListAdapter(this, properties);
        listProperties.setAdapter(adapter);
    }



    private void initComponents() {
        txtInterestRate = (TextView) findViewById(R.id.txtInterestRate);
        txtPrdtName = (TextView) findViewById(R.id.txtPdtName);
        txtNewestNetValue = (TextView) findViewById(R.id.txtGAge);
        txtState = (TextView) findViewById(R.id.txtLength);
        listProperties = (ListView) findViewById(R.id.listProperties);
    }

    private TextView txtInterestRate,
                     txtPrdtName,
                     txtNewestNetValue,
                     txtState;
    private ListView listProperties;

}
