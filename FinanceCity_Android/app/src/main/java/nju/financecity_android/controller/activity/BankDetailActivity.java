package nju.financecity_android.controller.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.TextView;
import nju.financecity_android.R;
import nju.financecity_android.controller.widget.SimpleProperty;
import nju.financecity_android.vo.PropertyVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_detail);
        initComponents();
        processData(new Intent());
    }

    protected void setProperties(List<PropertyVO> properties) {
        SimpleProperty.PropertyListAdapter adapter = new SimpleProperty.PropertyListAdapter(this, properties);
        listProperties.setAdapter(adapter);
    }

    protected void setHeaderInfo(String productName, double interestRate, int startBuyMoney, String openDate) {
        txtPrdtName.setText(productName);
        String strInterestRate = String.valueOf(interestRate * 100);
        if (strInterestRate.length() > 4) {
            strInterestRate = strInterestRate.substring(0, 4) + "%";
        }
        txtInterestRate.setText(strInterestRate);
        txtStartBuyMoney.setText(String.valueOf(startBuyMoney));
        txtOpenDate.setText(openDate);
    }

    private void processData(Intent intent) {
        String productName = intent.getStringExtra("product_name");
        double interestRate = intent.getDoubleExtra("interestRate", 0.0);
        int startBuyMoney = intent.getIntExtra("startBuyMoney", 0);
        String openDate = intent.getStringExtra("openDate");
        setHeaderInfo(productName, interestRate, startBuyMoney, openDate);

        List<PropertyVO> properties = new ArrayList<>();
        Collections.addAll(properties,
                new PropertyVO("基本信息", "", R.color.validBlue, 0),
                new PropertyVO("产品名称", productName),
                new PropertyVO("产品期次", intent.getStringExtra("产品期次")),
                new PropertyVO("管理机构", intent.getStringExtra("管理机构")),
                new PropertyVO("托管机构", intent.getStringExtra("托管机构")),
                new PropertyVO("", intent.getStringExtra("")),

                new PropertyVO("风险收益", "", R.color.validBlue, 0),
                new PropertyVO("预计年华收益率", intent.getStringExtra("预计年华收益率")),
                new PropertyVO("收益类型", intent.getStringExtra("收益类型")),
                new PropertyVO("风险等级", intent.getStringExtra("风险等级")),
                new PropertyVO("", intent.getStringExtra("")),

                new PropertyVO("申购赎回", "", R.color.validBlue, 0),
                new PropertyVO("是否净值型", intent.getStringExtra("是否净值型")),
                new PropertyVO("是否封闭", intent.getStringExtra("是否封闭")),
                new PropertyVO("申购费率", intent.getStringExtra("申购费率")),
                new PropertyVO("赎回费率", intent.getStringExtra("赎回费率")),
                new PropertyVO("广义管理费率", intent.getStringExtra("广义管理费率")),
                new PropertyVO("起购金额", intent.getStringExtra("起购金额")),
                new PropertyVO("递增购买最小单位", intent.getStringExtra("递增购买最小单位")),
                new PropertyVO("募集开始日", intent.getStringExtra("募集开始日")),
                new PropertyVO("募集截止日", intent.getStringExtra("募集截止日")),
                new PropertyVO("起息日", intent.getStringExtra("起息日")),
                new PropertyVO("开放日", intent.getStringExtra("开放日")),
                new PropertyVO("期限", intent.getStringExtra("期限")),
                new PropertyVO("赎回速度", intent.getStringExtra("赎回速度")),
                new PropertyVO("", intent.getStringExtra("")),

                new PropertyVO("投资范围", "", R.color.validBlue, 0),
                new PropertyVO("理财币种", intent.getStringExtra("理财币种")),
                new PropertyVO("投资范围", intent.getStringExtra("投资范围")),
                new PropertyVO("投资比例", intent.getStringExtra("投资比例")),
                new PropertyVO("", intent.getStringExtra("")),

                new PropertyVO("其他", "", R.color.validBlue, 0),
                new PropertyVO("产品编码", intent.getStringExtra("产品编码")),
                new PropertyVO("登记编码", intent.getStringExtra("登记编码")),
                new PropertyVO("销售区域", intent.getStringExtra("销售区域")),
                new PropertyVO("运行规模上限", intent.getStringExtra("运行规模上限")),
                new PropertyVO("理财本金及收益支付", intent.getStringExtra("理财本金及收益支付")),
                new PropertyVO("发行对象", intent.getStringExtra("发行对象")));
        setProperties(properties);
    }

    private void initComponents() {
        mInflater = LayoutInflater.from(this);

        listProperties = (ListView) findViewById(R.id.listProperties);
        txtInterestRate = (TextView) findViewById(R.id.txtInterestRate);
        txtOpenDate = (TextView) findViewById(R.id.txtState);
        txtPrdtName = (TextView) findViewById(R.id.txtPdtName);
        txtStartBuyMoney = (TextView) findViewById(R.id.txtStartBuyMoney);
    }

    private TextView txtOpenDate;
    private TextView txtPrdtName;
    private TextView txtStartBuyMoney;
    private TextView txtInterestRate;
    private LayoutInflater mInflater;
    private ListView listProperties;
}
