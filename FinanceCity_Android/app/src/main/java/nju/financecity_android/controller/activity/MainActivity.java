package nju.financecity_android.controller.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import android.widget.Toast;
import nju.financecity_android.R;
import nju.financecity_android.controller.info.FragmentName;
import nju.financecity_android.controller.widget.Banner;
import nju.financecity_android.controller.widget.Bar;
import nju.financecity_android.controller.widget.Footer;

/**
 * Created by Administrator on 2016/8/25.
 */
public class MainActivity extends Activity{
    private static FragmentManager fragmentManager;
    private static FragmentTransaction transaction;
    private static ProductSearch productSearchFragment;
    private static Products products;
    private static Fragment productDetailFragment;//TODO
    private static Fragment investmentFragment;//TODO
    private static Assets assetsFragment;
    private static Persons personFragment;//TODO

//    private static Banner banner;
    private static LinearLayout main_mid_layout;
    private static Footer footer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(null);
        setContentView(R.layout.main);
        initComponents();
        fragmentManager=getFragmentManager();
        setFragment(0);
    }

    private void initComponents() {
//        banner = (Banner) findViewById(R.id.banner);
        main_mid_layout=(LinearLayout) findViewById(R.id.main_mid_layout);
        footer = (Footer) findViewById(R.id.footer);


        for (int i = 0; i < 3; i++) {
            final int tempi = i;
            footer.setOnClickListener(i, new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, tempi + "", Toast.LENGTH_SHORT).show();
                    MainActivity.setFragment(tempi);
                }
            });
        }
    }

    /**只负责三个一级界面的显示*/
    public static void setFragment(int i)
    {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch(i)
        {
            case 0://产品
//                banner.setDisplayText(footer.getText(0));
                footer.setSelectedById(0);
                productSearchFragment = new ProductSearch();
                transaction.add(R.id.main_mid_layout, productSearchFragment);
                if (productSearchFragment != null) {
                    transaction.show(productSearchFragment);
                }
                break;
            case 1://资产（暂时是资产变化信息二级界面）
//                banner.setDisplayText(footer.getText(1));
                footer.setSelectedById(1);
                assetsFragment=new Assets();
                transaction.add(R.id.main_mid_layout,assetsFragment);
                if(assetsFragment!=null)
                {
                    transaction.show(assetsFragment);
                }
                break;
            case 2://个人中心
//                banner.setDisplayText(footer.getText(2));
                footer.setSelectedById(2);
                personFragment = new Persons();
                transaction.add(R.id.main_mid_layout,personFragment);
                if(personFragment!=null){
                    transaction.show(personFragment);
                }
                break;
        }
        transaction.commit();
    }

    public static void showProductDetail(String productId)
    {
        if(productId!=null) {
            transaction=fragmentManager.beginTransaction();
            products = new Products();//TODO 如何传入productId
            transaction.add(R.id.main_mid_layout, products);
            if (products != null) {
                transaction.show(products);
            }
            transaction.commit();
        }
        else{
            Log.e("test","no productId for detail");
        }
    }

    private static void clearSelection() {
        //消除所有选中状态
    }
    private static void hideFragments(FragmentTransaction transaction) {
        //将所有的fragment设置为隐藏状态
        if(products!=null)
        {
            transaction.hide(products);
        }
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
