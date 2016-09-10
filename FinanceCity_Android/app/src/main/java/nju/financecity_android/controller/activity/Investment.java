package nju.financecity_android.controller.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import nju.financecity_android.R;
import nju.financecity_android.controller.widget.InvstPrdtAdapter;
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
    }

    private void initComponents() {
        // 初始化投资产品列表
        listInvstProducts = (ListView) findViewById(R.id.listInvstProducts);
    }

    private void setProductListData(List<ProductInfo> productInfos) {
        ListAdapter adapter = new InvstPrdtAdapter(getActivity(), productInfos);
        listInvstProducts.setAdapter(adapter);
    }

    private View findViewById(int resId) {
        return thisView.findViewById(resId);
    }

    private View thisView;
    private ListView listInvstProducts;
}
