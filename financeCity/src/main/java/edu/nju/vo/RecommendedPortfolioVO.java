package edu.nju.vo;

import edu.nju.service.POJO.SimplePortfolio;
import edu.nju.service.POJO.SimpleTradeInfo;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/9/14.
 */
public class RecommendedPortfolioVO extends BaseVO {
    private List<SimplePortfolio> data;

    public List<SimplePortfolio> getData() {
        return data;
    }

    public void setData(List<SimplePortfolio> data) {
        this.data = data;
    }
}
