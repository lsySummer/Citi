package nju.financecity_android.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import nju.financecity_android.R;
import nju.financecity_android.widget.Banner;
import nju.financecity_android.widget.Footer;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_products);

        initComponents();
    }

    private void initComponents() {
        footer = (Footer) findViewById(R.id.footer);
        banner = (Banner) findViewById(R.id.banner);

        banner.setDisplayText("投资");

        for (int i = 0; i < 4; i++) {
            final int tempi = i;
            footer.setOnClickListener(i, new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    banner.setDisplayText(footer.getText(tempi));
                    footer.setSelectedById(tempi);
                }
            });
        }
    }

    private Footer footer;
    private Banner banner;
}
