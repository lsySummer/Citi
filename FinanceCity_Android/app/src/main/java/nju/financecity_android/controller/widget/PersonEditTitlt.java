package nju.financecity_android.controller.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import nju.financecity_android.R;

/**
 * Created by sam on 16/9/10.
 */
public class PersonEditTitlt extends RelativeLayout {

    private TextView textName;
    private TextView textBack;
    private TextView textOk;

    public PersonEditTitlt(Context context){
        super(context);
        LayoutInflater.from(context).inflate(R.layout.person_edit_banner,this,true);
        onFinishInflate();
    }
    public PersonEditTitlt(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.person_edit_banner,this,true);
        onFinishInflate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        textBack = (TextView) findViewById(R.id.back);
        textName = (TextView) findViewById(R.id.lblText);
    }
}
