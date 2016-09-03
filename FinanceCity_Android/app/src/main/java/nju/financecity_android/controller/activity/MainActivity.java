package nju.financecity_android.controller.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import android.view.View;
import nju.financecity_android.R;
import nju.financecity_android.controller.widget.Banner;
import nju.financecity_android.controller.widget.Footer;

/**
 * Created by Administrator on 2016/8/25.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
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
