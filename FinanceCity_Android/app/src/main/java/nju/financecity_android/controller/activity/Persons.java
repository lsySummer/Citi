package nju.financecity_android.controller.activity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

import nju.financecity_android.R;
import nju.financecity_android.model.PersonGet;

/**
 * Created by sam on 16/9/5.
 */
public class Persons extends Fragment {

    private TextView My_Name;
    private TextView Mobile;
    private TextView Birthday;
    private TextView IfCity;
    private TextView GetIn;
    private TextView GetOut;
    private ImageView Modify, prefer;

    private View theview;
    private PersonGet personGet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_user, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        theview = getView();
        initComponent();
        addListener();
    }

    private void initComponent(){
        My_Name = (TextView) findViewById(R.id.id_name);
        Mobile = (TextView) findViewById(R.id.mobile);
        Birthday = (TextView) findViewById(R.id.birthday);
        IfCity = (TextView) findViewById(R.id.city_country);
        GetIn = (TextView) findViewById(R.id.get_in);
        GetOut = (TextView) findViewById(R.id.get_out);
        Modify = (ImageView) findViewById(R.id.modify_mes);
        prefer = (ImageView) findViewById(R.id.btPrefer);

        personGet = new PersonGet();


    }

    private View findViewById(int ResId){
        View FindView = theview.findViewById(ResId);
        return FindView;
    }

    private void addListener(){
        prefer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Persons.this.getActivity(), QuestionActivity.class);
                Persons.this.getActivity().startActivity(intent);
            }
        });

        Modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Persons_Edit.class);
                startActivity(intent);

            }
        });
    }

    private void updateMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    HashMap<String ,Object> res = personGet.analyse();
                    int error = (int) res.get("error");
                    Log.d("SeeErr","error为"+error+"");
                    String mess = (String) res.get("message");
                    Log.d("SeeErr","mess为"+mess);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
