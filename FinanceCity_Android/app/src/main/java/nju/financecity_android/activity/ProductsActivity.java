package nju.financecity_android.activity;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import nju.financecity_android.R;
import nju.financecity_android.widget.Footer;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_products);

        loadComponent();
    }

    private void loadComponent() {
        footer = (Footer) findViewById(R.id.footer);
    }

    private Footer footer;
}
