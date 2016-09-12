package nju.financecity_android.controller.activity;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.PieChartView;
import nju.financecity_android.R;

/**
 * Created by Administrator on 2016/9/12.
 */
public class AssetsTop extends Fragment
{
    private LinearLayout assets_top_layout;
    private PieChartView pieChart;
    private Button pieButton;
    private LineChartView lineChart;
    private Button lineButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.assets_top, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        setPieChart();
        setLineChart();

    }

    private void setPieChart()
    {
        pieChart=(PieChartView)getView().findViewById(R.id.pie);

//        pieChart.setOnValueTouchListener(new ValueTouchListener());//添加点击事件
        pieChart.setCircleFillRatio(0.9f);//设置图所占整个view的比例  当有外面的数据时使用，防止数据显示不全

//        prepareDataAnimation();//更新数据，并添加动画

        int numValues = 10;//分成的块数

        List<SliceValue> values = new ArrayList<SliceValue>();
        for (int i = 0; i < numValues; ++i) {
            SliceValue sliceValue = new SliceValue(20.0f, ChartUtils.pickColor());//每一块的值和颜色，图标根据值自动进行比例分配
            values.add(sliceValue);
        }
        PieChartData data = new PieChartData(values);
        data.setHasLabels(true);//显示数据
        data.setHasLabelsOnlyForSelected(false);//不用点击显示占的百分比
        data.setHasLabelsOutside(true);//占的百分比是否显示在饼图外面
        data.setHasCenterCircle(true);;//是否是环形显示
        data.setCenterCircleScale(0.5f);////设置环形的大小级别
        data.setValueLabelBackgroundColor(Color.TRANSPARENT);////设置值得背景透明
        data.setValueLabelBackgroundEnabled(false);//数据背景不显示
        data.setValueLabelsTextColor(Color.BLACK);

        //data.setValues(values);//填充数据
//        if (isExploded) {
//            data.setSlicesSpacing(1);//设置间隔为0
//        }
//
//        if (hasCenterText1) {
//            data.setCenterText1("Hello!");
//
//            // Get roboto-italic font.
//            //      Typeface tf = Typeface.createFromAsset(MainActivity.this.getAssets(), "Roboto-Italic.ttf");//设置字体
//            //   data.setCenterText1Typeface(tf);
//
//            // Get font size from dimens.xml and convert it to sp(library uses sp values).
//            data.setCenterText1FontSize(ChartUtils.px2sp(getResources().getDisplayMetrics().scaledDensity,
//                    (int) getResources().getDimension(R.dimen.pie_chart_text1_size)));
//            data.setCenterText1Color(Color.BLACK);////设置值得颜色*/
//        }
//
//        if (hasCenterText2) {
//            data.setCenterText2("Charts (Roboto Italic)");
//
////            Typeface tf = Typeface.createFromAsset(MainActivity.this.getAssets(), "Roboto-Italic.ttf");
//
//            data.setCenterText2Typeface(tf);
//            data.setCenterText2FontSize(ChartUtils.px2sp(getResources().getDisplayMetrics().scaledDensity,
//                    (int) getResources().getDimension(R.dimen.pie_chart_text2_size)));
//        }

        pieChart.setPieChartData(data);


        pieButton=(Button)getView().findViewById(R.id.pie_button);
        pieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("test","click pie button");
                MainActivity.nextAssets(R.id.pie);
            }
        });
    }

    private void setLineChart()
    {
        lineChart=(LineChartView)getView().findViewById(R.id.line);
        List<PointValue> mPointValues=new ArrayList<PointValue>();
        List<AxisValue> mAxisValues=new ArrayList<AxisValue>();

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
        lineChart.setInteractive(true);
        lineChart.setZoomType(ZoomType.HORIZONTAL);
        lineChart.setScrollEnabled(true);
        lineChart.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);
        lineChart.setLineChartData(data);
        lineChart.setVisibility(View.VISIBLE);
        Viewport v = new Viewport(pieChart.getMaximumViewport());
        v.left = 0;
        v.right= 6;
        lineChart.setCurrentViewport(v);


        lineButton=(Button)getView().findViewById(R.id.line_button);
        lineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("test","click line button");
                MainActivity.nextAssets(R.id.line);
            }
        });
    }

}
