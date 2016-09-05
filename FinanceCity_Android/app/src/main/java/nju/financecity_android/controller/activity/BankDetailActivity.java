package nju.financecity_android.controller.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.TextView;
import nju.financecity_android.R;
import nju.financecity_android.controller.widget.SimpleProperty;
import nju.financecity_android.model.ProductBank;
import nju.financecity_android.vo.PropertyVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BankDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_detail);
        initComponents();

        Intent intent = getIntent();
        String productId = intent.getStringExtra("productId");
        Map data = (new ProductBank(productId)).getProperties();
        processData(data);
    }

    protected void setProperties(List<PropertyVO> properties) {
        SimpleProperty.PropertyListAdapter adapter = new SimpleProperty.PropertyListAdapter(this, properties);
        listProperties.setAdapter(adapter);
    }

    protected void setHeaderInfo(String productName, String interestRate, String startBuyMoney, String openDate) {
        txtPrdtName.setText(productName);
        txtInterestRate.setText(interestRate);
        txtStartBuyMoney.setText(startBuyMoney);
        txtOpenDate.setText(openDate);
    }

    private void processData(Map data) {
        String productName = data.get("产品名称").toString();
        String interestRate = data.get("预计年化收益率").toString();
        String startBuyMoney = data.get("起购金额").toString();
        String openDate = data.get("开放日").toString();
        setHeaderInfo(productName, interestRate, startBuyMoney, openDate);

        List<PropertyVO> properties = new ArrayList<>();
        Collections.addAll(properties,
                new PropertyVO("基本信息", "", R.color.validBlue, 0),
                new PropertyVO("产品名称", productName),
                new PropertyVO("产品期次", data.get("产品期次")),
                new PropertyVO("管理机构", data.get("管理机构")),
                new PropertyVO("托管机构", data.get("托管机构")),
                new PropertyVO("", ""),

                new PropertyVO("风险收益", "", R.color.validBlue, 0),
                new PropertyVO("预计年化收益率", data.get("预计年化收益率")),
                new PropertyVO("收益类型", data.get("收益类型")),
                new PropertyVO("风险等级", data.get("风险等级")),
                new PropertyVO("", ""),

                new PropertyVO("申购赎回", "", R.color.validBlue, 0),
                new PropertyVO("是否净值型", data.get("是否净值型")),
                new PropertyVO("是否封闭", data.get("是否封闭")),
                new PropertyVO("申购费率", data.get("申购费率")),
                new PropertyVO("赎回费率", data.get("赎回费率")),
                new PropertyVO("广义管理费率", data.get("广义管理费率")),
                new PropertyVO("起购金额", data.get("起购金额")),
                new PropertyVO("递增购买最小单位", data.get("递增购买最小单位")),
                new PropertyVO("募集开始日", data.get("募集开始日")),
                new PropertyVO("募集截止日", data.get("募集截止日")),
                new PropertyVO("起息日", data.get("起息日")),
                new PropertyVO("开放日", data.get("开放日")),
                new PropertyVO("期限", data.get("期限")),
                new PropertyVO("赎回速度", data.get("赎回速度")),
                new PropertyVO("", ""),

                new PropertyVO("投资范围", "", R.color.validBlue, 0),
                new PropertyVO("理财币种", data.get("理财币种")),
                new PropertyVO("投资范围", data.get("投资范围")),
                new PropertyVO("投资比例", data.get("投资比例")),
                new PropertyVO("", ""),

                new PropertyVO("其他", "", R.color.validBlue, 0),
                new PropertyVO("产品编码", data.get("产品编码")),
                new PropertyVO("登记编码", data.get("登记编码")),
                new PropertyVO("销售区域", data.get("销售区域")),
                new PropertyVO("运行规模上限", data.get("运行规模上限")),
                new PropertyVO("理财本金及收益支付", data.get("理财本金及收益支付")),
                new PropertyVO("发行对象", data.get("发行对象")));
        setProperties(properties);
    }

    private void initComponents() {
        mInflater = LayoutInflater.from(this);

        listProperties = (ListView) findViewById(R.id.listProperties);
        txtInterestRate = (TextView) findViewById(R.id.txtInterestRate);
        txtOpenDate = (TextView) findViewById(R.id.txtLength);
        txtPrdtName = (TextView) findViewById(R.id.txtPdtName);
        txtStartBuyMoney = (TextView) findViewById(R.id.txt);
    }

    private TextView txtOpenDate;
    private TextView txtPrdtName;
    private TextView txtStartBuyMoney;
    private TextView txtInterestRate;
    private LayoutInflater mInflater;
    private ListView listProperties;
}
