package nju.financecity_android.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import nju.financecity_android.R;

/**
 * 自定义footer导航。
 *
 * Created by alpaca. on 16-8-20.
 */
public class Footer extends LinearLayout {

    public Footer(Context context) {
        super(context);
        init(context);
    }

    public Footer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public String getText(int id) {
        if (id >= lbls.length) return null;
        return lbls[id].getText().toString();
    }

    public void setText(int id, String text) {
        if (id >= lbls.length) return;
        lbls[id].setText(text);
    }

    public void setImage(int id, int resId) {
        if (id >= imgs.length) return;
        imgs[id].setImageResource(resId);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();


    }

    private void initComponents() {
        items = new LinearLayout[4];
        items[0] = (LinearLayout) findViewById(R.id.itmProduct);
        items[1] = (LinearLayout) findViewById(R.id.itmInvestment);
        items[2] = (LinearLayout) findViewById(R.id.itmAsset);
        items[3] = (LinearLayout) findViewById(R.id.itmPersonalInfo);

        imgs = new ImageView[4];
        imgs[0] = (ImageView) findViewById(R.id.imgProduct);
        imgs[1] = (ImageView) findViewById(R.id.imgInvestment);
        imgs[2] = (ImageView) findViewById(R.id.imgAsset);
        imgs[3] = (ImageView) findViewById(R.id.imgPersonalInfo);

        lbls = new TextView[4];
        lbls[0] = (TextView) findViewById(R.id.lblProduct);
        lbls[0].setText(getResources().getString(R.string.footer_lbl1));
        lbls[1] = (TextView) findViewById(R.id.lblInvestment);
        lbls[1].setText(getResources().getString(R.string.footer_lbl2));
        lbls[2] = (TextView) findViewById(R.id.lblAsset);
        lbls[2].setText(getResources().getString(R.string.footer_lbl3));
        lbls[3] = (TextView) findViewById(R.id.lblInvestment);
        lbls[3].setText(getResources().getString(R.string.footer_lbl4));
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.footer_bar, this, true);
    }

    private LinearLayout[] items;
    private ImageView[] imgs;
    private TextView[] lbls;
}
