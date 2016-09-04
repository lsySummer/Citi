package nju.financecity_android.controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

import nju.financecity_android.R;

/**
 * Created by sam on 16/9/4.
 */
public class RegisterActivity extends Activity {

    private LayoutInflater LInflater;
    private TextView accountText;
    private TextView securityText;
    private TextView pswText;
    private TextView Btnreg;
    private Button BtnSub;
    private Button BtnGet;

    private String Account;
    private String security;
    private String Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        initComponents();
        addListener();
    }

    public void initComponents(){
        LInflater = LayoutInflater.from(this);
        accountText = (TextView) findViewById(R.id.accountEt);
        securityText = (TextView) findViewById(R.id.messageET);
        pswText = (TextView) findViewById(R.id.pwdEt);
        Btnreg = (TextView) findViewById(R.id.Btnregister);
        BtnSub = (Button) findViewById(R.id.BtnSub);
        BtnGet = (Button) findViewById(R.id.messageGet);
    }

    public void addListener(){
        Btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent RegIntent = new Intent(RegisterActivity.this,Log_inActivity.class);
                        startActivity(RegIntent);
                        RegisterActivity.this.finish();

                        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                    }
                },300);
            }
        });

        BtnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Account = accountText.getText().toString();
                security = securityText.getText().toString();
                Password = pswText.getText().toString();
//                Log.d("account",Account);
//                Log.d("account",Password);
            }
        });

        BtnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this,"短信已发送",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
