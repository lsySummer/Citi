package nju.financecity_android.controller.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import nju.financecity_android.R;
import nju.financecity_android.vo.PropertyVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FundDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund_detail);
        initComponents();
    }

    protected void setHeaderInfo(String productName, double interestRate, int netValue, String state) {
        String strInterestRate = String.valueOf(interestRate * 100);
        if (strInterestRate.length() > 4) {
            strInterestRate = strInterestRate.substring(0, 4) + "%";
        }
        txtInterestRate.setText(strInterestRate);
        txtPrdtName.setText(productName);
        txtNewestNetValue.setText(String.valueOf(netValue));
        txtState.setText(state);
    }

    private void processData(Intent intent) {
        String productName = intent.getStringExtra("productName");
        double interestRate = intent.getDoubleExtra("interestRate", 0);
        int netValue = intent.getIntExtra("netValue", 0);
        String state = intent.getStringExtra("state");
        setHeaderInfo(productName, interestRate, netValue, state);

        List<PropertyVO> properties = new ArrayList<>();
        Collections.addAll(properties,
                new PropertyVO("基本信息", "", R.color.validBlue, 0),
                new PropertyVO("法定名称", productName),
                new PropertyVO("基金编号", intent.getStringExtra("基金编号")),
                new PropertyVO("管理机构", intent.getStringExtra("管理机构")),
                new PropertyVO("托管机构", intent.getStringExtra("托管机构")),
                new PropertyVO("", intent.getStringExtra("")),

                new PropertyVO("风险收益", "", R.color.validBlue, 0),
                new PropertyVO("近一年收益率", intent.getStringExtra("近一年收益率")),
                new PropertyVO("最新净值", intent.getStringExtra("最新净值")),
                new PropertyVO("份额净值", intent.getStringExtra("份额净值")),
                new PropertyVO("基金投资目标类型", intent.getStringExtra("基金投资目标类型")),
                new PropertyVO("业绩比较基准", intent.getStringExtra("业绩比较基准")),
                new PropertyVO("跟踪标的", intent.getStringExtra("跟踪标的")),
                new PropertyVO("风险等级", intent.getStringExtra("风险等级")),
                new PropertyVO("", intent.getStringExtra("")),

                new PropertyVO("申购赎回", "", R.color.validBlue, 0),
                new PropertyVO("状态", intent.getStringExtra("状态")),
                new PropertyVO("是否封闭", intent.getStringExtra("是否封闭")),
                new PropertyVO("申购费率", intent.getStringExtra("申购费率")),
                new PropertyVO("认购费率", intent.getStringExtra("认购费率")),
                new PropertyVO("赎回费率", intent.getStringExtra("赎回费率")),
                new PropertyVO("广义管理费率", intent.getStringExtra("广义管理费率")),
                new PropertyVO("递增购买最小单位", intent.getStringExtra("递增购买最小单位")),
                new PropertyVO("募集开始日", intent.getStringExtra("募集开始日")),
                new PropertyVO("募集截止日", intent.getStringExtra("募集截止日")),
                new PropertyVO("起息日", intent.getStringExtra("起息日")),
                new PropertyVO("开发日", intent.getStringExtra("开发日")),
                new PropertyVO("期限", intent.getStringExtra("期限")),
                new PropertyVO("认购速度", intent.getStringExtra("认购速度")),
                new PropertyVO("赎回速度", intent.getStringExtra("赎回速度")),
                new PropertyVO("", intent.getStringExtra("")),


                new PropertyVO("其他", "", R.color.validBlue, 0),
                new PropertyVO("基金经理", intent.getStringExtra("基金经理")),
                new PropertyVO("基金规模", intent.getStringExtra("基金规模")),
                new PropertyVO("份额规模", intent.getStringExtra("份额规模")));
    }

    private void initComponents() {
        txtInterestRate = (TextView) findViewById(R.id.txtInterestRate);
        txtPrdtName = (TextView) findViewById(R.id.txtPdtName);
        txtNewestNetValue = (TextView) findViewById(R.id.txtNewestNetValue);
        txtState = (TextView) findViewById(R.id.txtState);
        listProperties = (ListView) findViewById(R.id.listProperties);
    }

    private TextView txtInterestRate,
                     txtPrdtName,
                     txtNewestNetValue,
                     txtState;
    private ListView listProperties;

}
