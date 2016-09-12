package nju.financecity_android.controller.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import nju.financecity_android.R;

/**
 * Created by sam on 16/9/12.
 */
public class QuestionIII extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question_iii,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        initComponent();
    }

    public View findViewById(int resId) {
        return getView().findViewById(resId);
    }

    public void setObserver(IQuestionObserver observer) {
        this.mObserver = observer;
    }

    private void initComponent(){
        btCancel = (Button) findViewById(R.id.btCancle);
        btContinue = (Button) findViewById(R.id.btContinue);
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mObserver.showFormerPage();
            }
        });
        btContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateData();
                mObserver.showNextPage();
            }
        });
    }

    private void generateData() {
        
    }

    private IQuestionObserver mObserver;
    private Button btCancel, btContinue;
}
