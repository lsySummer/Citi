package nju.financecity_android.controller.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import nju.financecity_android.R;
import nju.financecity_android.controller.widget.ListGoodsAdapter;
import nju.financecity_android.vo.GoodsInfo;

import java.util.List;


/**
 *
 */
public class OrderConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);
        initComponents();


    }

    protected void setListContent(List<GoodsInfo> content) {
        ListGoodsAdapter adapter = new ListGoodsAdapter(this, content);
        listGoods.setAdapter(adapter);
    }

    private void initComponents() {
        listGoods = (ListView) findViewById(R.id.listGoods);
        btCancel = (Button) findViewById(R.id.btCancel);
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderConfirmActivity.this.finish();
            }
        });
        btSubmit = (Button) findViewById(R.id.btSubmit);
        txtSummary = (TextView) findViewById(R.id.txtSummary);
    }

    private ListView listGoods;
    private Button btCancel, btSubmit;
    private TextView txtSummary;
}
