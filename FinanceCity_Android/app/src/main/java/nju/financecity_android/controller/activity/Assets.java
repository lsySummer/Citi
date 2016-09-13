package nju.financecity_android.controller.activity;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;
import nju.financecity_android.R;
import nju.financecity_android.dao.AssetValueDao;
import nju.financecity_android.model.UserSession;

/**
 * Created by Administrator on 2016/8/25.
 */
public class Assets extends Fragment {
    private ImageButton back;
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

        back=(ImageButton)getView().findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //切换到资产一级界面
            }
        });

    }

    public void setChart()
    {
        //资产变化曲线图
        chart = (LineChartView) getView().findViewById(R.id.chart);
        List<PointValue> mPointValues=new ArrayList<PointValue>();
        List<AxisValue> mAxisValues=new ArrayList<AxisValue>();

        final JSONObject[] jsonObjects=new JSONObject[1];
        jsonObjects[0]=new JSONObject();
        UserSession user=UserSession.getCurrUser();
        try {
            jsonObjects[0].put("id", 6);
            jsonObjects[0].put("session","a482dd91fc6dd55b5a1b74f103f48717");
//            jsonObjects[0].put("days",20);//TODO
        }catch(Exception e)
        {
            Log.i("test","user session or json exception");
            e.printStackTrace();
        }
        final String[] result={""};
        new Thread(new Runnable() {
            @Override
            public void run() {

                result[0]=new AssetValueDao().sendPost(jsonObjects[0]);
            }
        }).start();
        JSONObject jResult=null;
        try{
            jResult=new JSONObject(result[0]);
        }catch(Exception e)
        {
            Log.i("test","asset value result exception");
            e.printStackTrace();
        }
        /*==============================================================================*/
        List<Date> dates=new ArrayList<Date>();
        for(int i=0;i<20;i++)
        {
            dates.add(new Date(Calendar.getInstance().getTimeInMillis()+i*60*60*24*1000));
        }
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        /*==============================================================================*/

        for (int i = 0; i < dates.size() ; i++) {
            mPointValues.add(new PointValue(i, new Random().nextInt(10)-5));
            mAxisValues.add(new AxisValue(i).setLabel(format.format(dates.get(i)))); //为每个对应的i设置相应的label(显示在X轴)
        }
        Line line = new Line(mPointValues).setColor(getResources().getColor(R.color.lightBlue)).setCubic(false);
        line.setHasLabelsOnlyForSelected(true);
        line.setPointColor(getResources().getColor(R.color.validBlue));
        line.setPointRadius(4);//座标点大小
        List<Line> lines = new ArrayList<Line>();
        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);

        //坐标轴
        Axis axisX = new Axis(); //X轴
        axisX.setHasTiltedLabels(true);
        axisX.setTextColor(Color.BLUE);
        axisX.setName("时间");
        axisX.setMaxLabelChars(14);
        axisX.setValues(mAxisValues);
        axisX.setHasSeparationLine(false);
        axisX.setHasLines(true);
        data.setAxisXBottom(axisX);

        Axis axisY = new Axis();  //Y轴
        axisY.setMaxLabelChars(7); //默认是3，只能看最后三个数字
        data.setAxisYLeft(axisY);

        //设置行为属性，支持缩放、滑动以及平移
        chart.setInteractive(true);
        chart.setZoomType(ZoomType.HORIZONTAL);
        chart.setScrollEnabled(true);
        chart.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);
        chart.setLineChartData(data);
        chart.setVisibility(View.VISIBLE);
        Viewport v = new Viewport(chart.getMaximumViewport());
        v.left = 0;
        v.right= 6;
        chart.setCurrentViewport(v);
    }

    public void setTimeline()
    {
        //资产变化事迹
        timeline = (ListView) getView().findViewById(R.id.timeline);
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,Object>>();/*在数组中存放数据*/
        HashMap<String, Object> mapTitle = new HashMap<String, Object>();
        mapTitle.put("time", "时间");
        mapTitle.put("history", "事件");
        for(int i=0;i<2;i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("time", "2016-01-"+i+"");
            map.put("history", "购买。。。。。。。。。。。。。。。。。");
            listItem.add(map);
        }
        for(int i=2;i<4;i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("time", "2016-01-"+i+"");
            map.put("history", "购买。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
            listItem.add(map);
        }
        SimpleAdapter mSimpleAdapter = new SimpleAdapter(this.getActivity(),listItem,R.layout.assets_history,new String[]{"time", "history"},new int[] {R.id.time,R.id.history});
        //需要绑定的数据//每一行的布局//动态数组中的数据源的键对应到定义布局的View中new String[] {"ItemImage"
        timeline.setAdapter(mSimpleAdapter);//为ListView绑定适配器
        timeline.setVisibility(View.VISIBLE);
    }
}
