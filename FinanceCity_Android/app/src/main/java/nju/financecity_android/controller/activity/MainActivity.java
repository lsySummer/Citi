package nju.financecity_android.controller.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import nju.financecity_android.R;
import nju.financecity_android.controller.widget.Banner;
import nju.financecity_android.controller.widget.Footer;

/**
 * Created by Administrator on 2016/8/25.
 */
public class MainActivity extends Activity {
    private static FragmentManager fragmentManager;
    private static FragmentTransaction transaction;
    private static ProductSearch productSearchFragment;
    private static Products products;
    private static Fragment productDetailFragment;//TODO
    private static Fragment investmentFragment;//TODO
    private static Assets assetsFragment;
    private static AssetsTop assetsTop;
    private static Persons personFragment;//TODO
    private static Fragment testFrag = new QuestionI();
    //    private static Banner banner;
    private static LinearLayout main_mid_layout;
    private static Footer footer;
    private static Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(null);
        setContentView(R.layout.main);
        initComponents();
        fragmentManager = getFragmentManager();
        setFragment(0);


//        Intent intent = new Intent(this, OrderConfirmActivity.class);
//        for (int i = 0; i < 10; i++) {
//            GoodsInfo info = new GoodsInfo("123", "这是第" + i + "个产品", 10000 / (i + 1), i);
//            switch (i % 4) {
//                case 0:
//                    info.type = "银行理财";
//                    info.initialAmount = 10000;
//                    info.increasingUnit = 1000;
//                    break;
//                case 1:
//                    info.type = "保险";
//                    break;
//                case 2:
//                    info.type = "基金";
//                    break;
//                case 3:
//                    info.type = "债券";
//                    break;
//            }
//
//            intent.putExtra("product" + i, info);
//        }
//        startActivity(intent);
    }

    private void initComponents() {
//        banner = (Banner) findViewById(R.id.banner);
        main_mid_layout = (LinearLayout) findViewById(R.id.main_mid_layout);
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
        banner = (Banner) findViewById(R.id.banner);
    }

    /**
     * 只负责三个一级界面的显示
     */
    public static void setFragment(int i) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (i) {
            case 0://产品
//                banner.setDisplayText(footer.getText(0));
                footer.setSelectedById(0);
                productSearchFragment = new ProductSearch();

                transaction.add(R.id.main_mid_layout, productSearchFragment);
                if (productSearchFragment != null) {
                    transaction.show(productSearchFragment);
                }
//                transaction.add(R.id.main_mid_layout, testFrag);
//                if (productSearchFragment != null) {
//                    transaction.show(testFrag);
//                }
                banner.setDisplayText("产品概览");
                break;
            case 1://资产（暂时是资产变化信息二级界面）
//                banner.setDisplayText(footer.getText(1));
                footer.setSelectedById(1);
                assetsTop = new AssetsTop();
                transaction.add(R.id.main_mid_layout, assetsTop);
//                assetsFragment=new Assets();
//                transaction.add(R.id.main_mid_layout,assetsFragment);
                if (assetsFragment != null) {
                    transaction.show(assetsFragment);
                }
                banner.setDisplayText("个人资产");
                break;
            case 2://个人中心
//                banner.setDisplayText(footer.getText(2));
                footer.setSelectedById(2);
                personFragment = new Persons();
                transaction.add(R.id.main_mid_layout, personFragment);
                if (personFragment != null) {
                    transaction.show(personFragment);
                }
                banner.setDisplayText("个人信息");
                break;
        }
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public static void showProductDetail(String productId) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        if (productId != null) {
            transaction = fragmentManager.beginTransaction();
            products = new Products();//TODO 如何传入productId
            transaction.add(R.id.main_mid_layout, products);
            if (products != null) {
                transaction.show(products);
            }
            transaction.addToBackStack(null);
            transaction.commit();
        } else {
            Log.e("test", "no productId for detail");
        }
    }

    public static void nextAssets(int id) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        if (id == R.id.pie) {
            Log.i("test", "pie in");
            //TODO
            Investment inv = new Investment();
            transaction.add(R.id.main_mid_layout, inv);
            if (inv != null) {
                transaction.show(inv);
            }
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (id == R.id.line) {
            Log.i("test", "line in");
            assetsFragment = new Assets();
            transaction.add(R.id.main_mid_layout, assetsFragment);
            if (assetsFragment != null) {
                transaction.show(assetsFragment);
            }
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

    private static void clearSelection() {
        //消除所有选中状态
    }

    private static void hideFragments(FragmentTransaction transaction) {
        //将所有的fragment设置为隐藏状态
        if (products != null) {
            transaction.hide(products);
        }
        if (productSearchFragment != null) {
            transaction.hide(productSearchFragment);
        }
        if (productDetailFragment != null) {
            transaction.hide(productDetailFragment);
        }
        if (investmentFragment != null) {
            transaction.hide(investmentFragment);
        }
        if (assetsFragment != null) {
            transaction.hide(assetsFragment);
        }
        if (assetsTop != null) {
            transaction.hide(assetsTop);
        }
        if (personFragment != null) {
            transaction.hide(personFragment);
        }
    }
}
