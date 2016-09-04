package nju.financecity_android.controller.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import nju.financecity_android.R;
import nju.financecity_android.controller.widget.Banner;
import nju.financecity_android.controller.widget.Bar;
import nju.financecity_android.controller.widget.Footer;

/**
 * Created by Administrator on 2016/8/25.
 */
public class MainActivity extends Activity{
    private static FragmentManager fragmentManager;
    private static ProductSearch productSearchFragment;
    private static Fragment productDetailFragment;//TODO
    private static Fragment investmentFragment;//TODO
    private static Assets assetsFragment;
    private static Fragment personFragment;//TODO

    private static Banner banner;
    private static LinearLayout main_mid_layout;
    private static Footer footer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initComponents();
        fragmentManager=getFragmentManager();
        setFragment(2);
    }

    private void initComponents() {
        banner = (Banner) findViewById(R.id.banner);
        main_mid_layout=(LinearLayout) findViewById(R.id.main_mid_layout);
        footer = (Footer) findViewById(R.id.footer);


        for (int i = 0; i < 4; i++) {
            final int tempi = i;
            footer.setOnClickListener(i, new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    MainActivity.setFragment(tempi);
                }
            });
        }
    }

    public static void setFragment(int i)
    {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch(i)
        {
            case 0:
                banner.setDisplayText(footer.getText(0));
                footer.setSelectedById(0);
                productSearchFragment=new ProductSearch();
                transaction.add(R.id.main_mid_layout,productSearchFragment);
                if(productSearchFragment!=null)
                {
                    transaction.show(productSearchFragment);
                }
                break;
            case 1:
//                transaction.add(R.id.,f);investment TODO
                break;
            case 2:
                banner.setDisplayText(footer.getText(2));
                footer.setSelectedById(2);
                assetsFragment=new Assets();
                transaction.add(R.id.main_mid_layout,assetsFragment);
                if(assetsFragment!=null)
                {
                    transaction.show(assetsFragment);
                }
                break;
            case 3:
//                transaction.add(R.id.,f);person TODO
                break;
            case 4:
//                transaction.add(R.id.,f);more TODO
                break;
        }
        transaction.commit();
    }
    private static void clearSelection() {
        //消除所有选中状态
    }
    private static void hideFragments(FragmentTransaction transaction) {
        //将所有的fragment设置为隐藏状态
        if (productSearchFragment != null)
        {
            transaction.hide(productSearchFragment);
        }
        if (productDetailFragment != null)
        {
            transaction.hide(productDetailFragment);
        }
        if (investmentFragment != null)
        {
            transaction.hide(investmentFragment);
        }
        if (assetsFragment != null)
        {
            transaction.hide(assetsFragment);
        }
        if(personFragment!=null)
        {
            transaction.hide(personFragment);
        }
    }}
