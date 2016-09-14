package nju.financecity_android.controller.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import nju.financecity_android.R;
import nju.financecity_android.dao.CommonDao;
import nju.financecity_android.dao.QuestionDao;
import nju.financecity_android.util.HttpUtil;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionActivity extends AppCompatActivity implements IQuestionObserver {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        pages = new ArrayList<>();
        pages.add(new QuestionI());
        pages.add(new QuestionI_I());
        pages.add(new QuestionII());
        pages.add(new QuestionIII());
        for (Fragment page: pages) {
            ((IObservableQuestion) page).setObserver(this);
        }
        mAnswer = new HashMap<>();
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        setDisplayId(0);
        updateCurrFragment();
    }

    @Override
    public void putAnswer(String key, Object value) {
        mAnswer.put(key, value);
    }

    @Override
    public Object getAnswer(String key) {
        return mAnswer.get(key);
    }

    @Override
    public void showNextPage() {
        if (currPage == 3) {
            return;
        } else currPage++;
        updateCurrFragment();
    }

    @Override
    public void showNextPage(int skip) {
        currPage++;
        currPage+=skip;
        updateCurrFragment();
    }

    @Override
    public void showFormerPage() {
        if (currPage == 0) {
            this.finish();
            return;
        } else currPage--;
        updateCurrFragment();
    }

    @Override
    public void postAnswer() {
        QuestionDao dao = new QuestionDao(mAnswer);
        Map result = dao.readData();
        if ((Integer) result.get("error") != 0) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage("Error code:\t" + result.get("error") + "\n" +
                              "Error Message:\t" + result.get("message"));
        }
    }

    public void showFormerPage(int skip) {
        currPage--;
        currPage-=skip;
        updateCurrFragment();
    }
    public void setDisplayId(int displayId) {
        this.currPage = displayId;
    }

    protected void initComponents() {

    }

    protected void updateCurrFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainFragment, pages.get(currPage));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private HashMap<String, Object> mAnswer;
    private List<Fragment> pages;
    private int currPage = 0;
}
