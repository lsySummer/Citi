package nju.financecity_android.vo;

import java.util.List;

/**
 * Created by coral on 16-9-15.
 */
public class RecommendCombVO {
    public List<RecommendSingleVO> products;
    public int yield_score;
    public int risk_score;
    public int flow_score;
    public int length_score;
    public double total_amount;
    public String checkCode;

    public RecommendCombVO(){}
    public RecommendCombVO(List<RecommendSingleVO> products, int yield_score, int risk_score, int flow_score, int length_score, double total_amount, String checkCode) {
        this.products = products;
        this.yield_score = yield_score;
        this.risk_score = risk_score;
        this.flow_score = flow_score;
        this.length_score = length_score;
        this.total_amount = total_amount;
        this.checkCode = checkCode;
    }

}
