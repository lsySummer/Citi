package nju.financecity_android.controller.activity;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;
import nju.financecity_android.R;
import nju.financecity_android.controller.widget.item.adapter.InvstPrdtAdapter;
import nju.financecity_android.model.User;
import nju.financecity_android.model.UserInvestment;
import nju.financecity_android.util.ColorBoard;
import nju.financecity_android.vo.ProductInfo;

import java.util.*;

/**
 * Created by coral on 16-8-26.
 */
public class Investment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_investment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        thisView = getView();

        initComponents();

        // processData();

        List<ProductInfo> data = new ArrayList<>();
        ProductInfo info = new ProductInfo();
        info.productName = "123";
        info.buyPrice = 200;
        info.buy = "2016-01-01";
        info.currPrice = 150;
        data.add(info);
        info = new ProductInfo();
        info.productName = "14423";
        info.buyPrice = 60;
        info.buy = "2016-01-01";
        info.currPrice = 100;
        data.add(info);
        info = new ProductInfo();
        info.productName = "1233";
        info.buyPrice = 200;
        info.buy = "2016-01-01";
        info.currPrice = 200;
        data.add(info);
        setProductListData(data);
    }

    public static PieChartView setPieChart(PieChartView chart) {
        return chart;
    }

    private void initComponents() {
        // 初始化投资产品列表
        listInvstProducts = (ListView) findViewById(R.id.listInvstProducts);
        pieChart = (PieChartView) findViewById(R.id.pieChart);
    }

    private void processData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                UserInvestment investment = UserInvestment.getCurrUserInvestment();
                if (investment == null) {
                    mainThreadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            Investment.this.getActivity().finish();
                        }
                    });
                    return;
                }
                final List<ProductInfo> list = investment.getProductList();
                mainThreadHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        setProductListData(list);
                    }
                });
            }
        }).start();
    }

    private void setProductListData(List<ProductInfo> productInfos) {
        ListAdapter adapter = new InvstPrdtAdapter(getActivity(), productInfos);
        listInvstProducts.setAdapter(adapter);

        // 饼图
        List<SliceValue> values = new ArrayList<>();
        for (int i = 0; i < productInfos.size(); ++i) {
            SliceValue slice = new SliceValue(productInfos.get(i).currPrice);
            slice.setLabel(productInfos.get(i).productName);
            slice.setColor(ColorBoard.nextColor());
            values.add(slice);
        }
        PieChartData data = new PieChartData(values);
        data.setHasLabels(true);
        data.setHasLabelsOutside(true);
        data.setHasLabelsOnlyForSelected(false);
        data.setHasCenterCircle(true);
        data.setCenterCircleScale(0.5f);
        data.setValueLabelBackgroundColor(Color.TRANSPARENT);
        data.setValueLabelBackgroundEnabled(false);
        data.setValueLabelsTextColor(Color.GRAY);
        data.setSlicesSpacing(1);

        pieChart.setPieChartData(data);
    }

    private View findViewById(int resId) {
        return thisView.findViewById(resId);
    }
    private Handler mainThreadHandler = new Handler();
    private View thisView;
    private PieChartView pieChart;
    private ListView listInvstProducts;
}
