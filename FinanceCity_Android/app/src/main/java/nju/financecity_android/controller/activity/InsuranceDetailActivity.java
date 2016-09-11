package nju.financecity_android.controller.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import nju.financecity_android.R;
import nju.financecity_android.controller.widget.item.adapter.PropertyListAdapter;
import nju.financecity_android.model.ProductInsurance;
import nju.financecity_android.vo.PropertyVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class InsuranceDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance_detail);
        initComponents();

        Intent intent = getIntent();
        String productId = intent.getStringExtra("productId");
        Map data = (new ProductInsurance(productId)).getProperties();
        processData(data);
    }

    protected void processData(Map data) {
        String productName = data.get("险种名称").toString();
        String length = data.get("保障年限").toString();
        String age = data.get("承保年龄").toString();
        String interestRate = data.get("年化收益率").toString();
        setHeaderInfo(productName, age, length, interestRate);

        List<PropertyVO> properties = new ArrayList<>();
        Collections.addAll(properties,
                new PropertyVO("基本信息", "", R.color.validBlue, 0),
                new PropertyVO("险种名称", data.get("险种名称")),
                new PropertyVO("产品发行公司", data.get("产品发行公司")),
                new PropertyVO("赔偿金额", data.get("赔偿金额")),
                new PropertyVO("保险产品面额", data.get("保险产品面额")),
                new PropertyVO("", ""),

                new PropertyVO("基本信息", "", R.color.validBlue, 0),
                new PropertyVO("单位金额赔偿", data.get("单位金额赔偿")),
                new PropertyVO("年化收益率", data.get("年化收益率")),
                new PropertyVO("年结算利率/预计收益率", data.get("年结算利率")),
                new PropertyVO("保证利率", data.get("保证利率")),
                new PropertyVO("预期利率", data.get("预期利率")),
                new PropertyVO("日结算利率", data.get("日结算利率")),
                new PropertyVO("", ""),

                new PropertyVO("购买相关", "", R.color.validBlue, 0),
                new PropertyVO("缴费方式", data.get("缴费方式")),
                new PropertyVO("保险年限", data.get("保险年限")),
                new PropertyVO("购买日", data.get("购买日")),
                new PropertyVO("到期日", data.get("到期日")),
                new PropertyVO("期限", data.get("期限"))
                );
        setProperties(properties);
    }

    protected void setProperties(List<PropertyVO> properties) {
        PropertyListAdapter adapter = new PropertyListAdapter(this, properties);
        listProperties.setAdapter(adapter);
    }

    protected void setHeaderInfo(String productName, String age, String length, String interestRate) {
        txtPrdtName.setText(productName);
        txtGAge.setText(age);
        txtLength.setText(length);
        txtInterestRate.setText(interestRate);
    }

    private void initComponents() {
        listProperties = (ListView) findViewById(R.id.listProperties);
        txtPrdtName = (TextView) findViewById(R.id.txtPdtName);
        txtGAge = (TextView) findViewById(R.id.txtGAge);
        txtLength = (TextView) findViewById(R.id.txtLength);
        txtInterestRate = (TextView) findViewById(R.id.txtInterestRate);
    }

    private ListView listProperties;
    private TextView txtPrdtName;
    private TextView txtLength;
    private TextView txtGAge;
    private TextView txtInterestRate;
}
