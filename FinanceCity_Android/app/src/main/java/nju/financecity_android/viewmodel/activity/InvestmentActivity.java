package nju.financecity_android.viewmodel.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import nju.financecity_android.R;

/**
 * Created by coral on 16-8-26.
 */
public class InvestmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_investment);

        initComponents();
    }

    private void initComponents() {
        listInvstProducts = (ListView) findViewById(R.id.listInvstProducts);
    }

    private ListView listInvstProducts;
}
