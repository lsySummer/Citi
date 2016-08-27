package nju.financecity_android.controller.activity;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;
import nju.financecity_android.R;

/**
 * Created by Administrator on 2016/8/25.
 */
public class Assets extends Fragment {

    public LinearLayout linearLayout;
    public LineChartView chart;
    public ListView timeline;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.assets, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        setChart();
        setTimeline();

    }

    public void setChart()
    {
        //资产变化曲线图
        chart = (LineChartView) getView().findViewById(R.id.chart);
        List<PointValue> mPointValues=new ArrayList<PointValue>();
        List<AxisValue> mAxisValues=new ArrayList<AxisValue>();
        for (int i = 0; i < 10 ; i++) {
            mPointValues.add(new PointValue(i, new Random().nextInt(10)));
            mAxisValues.add(new AxisValue(i).setLabel(i+"")); //为每个对应的i设置相应的label(显示在X轴)
        }
        Line line = new Line(mPointValues).setColor(Color.BLUE).setCubic(false);
        List<Line> lines = new ArrayList<Line>();
        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);

        //坐标轴
        Axis axisX = new Axis(); //X轴
        axisX.setHasTiltedLabels(true);
        axisX.setTextColor(Color.BLUE);
        axisX.setName("采集时间");
        axisX.setMaxLabelChars(10);
        axisX.setValues(mAxisValues);
        data.setAxisXBottom(axisX);

        Axis axisY = new Axis();  //Y轴
        axisY.setMaxLabelChars(7); //默认是3，只能看最后三个数字
        data.setAxisYLeft(axisY);

        //设置行为属性，支持缩放、滑动以及平移
        chart.setInteractive(true);
        chart.setZoomType(ZoomType.HORIZONTAL);
        chart.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);
        chart.setLineChartData(data);
        chart.setVisibility(View.VISIBLE);
    }

    public void setTimeline()
    {
        //资产变化事迹
        timeline = (ListView) getView().findViewById(R.id.timeline);
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,Object>>();/*在数组中存放数据*/
        HashMap<String, Object> mapTitle = new HashMap<String, Object>();
        mapTitle.put("time", "时间");
        mapTitle.put("history", "事件");
        for(int i=0;i<10;i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("time", "2016年1月"+i+""+"日");
            map.put("history", "购买。。。。。。。。。。。。。。。。。");
            listItem.add(map);
        }
        SimpleAdapter mSimpleAdapter = new SimpleAdapter(this.getActivity(),listItem,R.layout.assets_history,new String[]{"time", "history"},new int[] {R.id.time,R.id.history});
        //需要绑定的数据//每一行的布局//动态数组中的数据源的键对应到定义布局的View中new String[] {"ItemImage"
        timeline.setAdapter(mSimpleAdapter);//为ListView绑定适配器 lv.setOnItemClickListener(new
        timeline.setVisibility(View.VISIBLE);
    }
}
