package nju.financecity_android.controller.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import nju.financecity_android.R;
import nju.financecity_android.controller.widget.Banner;
import nju.financecity_android.controller.widget.Footer;

/**
 * Created by Administrator on 2016/8/25.
 */
public class MainActivity extends Activity {

    private Banner banner;
    private LinearLayout main_mid_layout;
    private Footer footer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initComponents();
    }

    private void initComponents() {
        banner = (Banner) findViewById(R.id.banner);
        main_mid_layout=(LinearLayout) findViewById(R.id.main_mid_layout);
        footer = (Footer) findViewById(R.id.footer);

//        main_mid_layout.addView(findViewById(R.id.product_search_fragment));
//        banner.setDisplayText("投资");
        banner.setDisplayText("产品");


//        for (int i = 0; i < 4; i++) {
//            final int tempi = i;
//            footer.setOnClickListener(i, new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    banner.setDisplayText(footer.getText(tempi));
//                    footer.setSelectedById(tempi);
//                }
//            });
//        }
    }


}
