package edu.nju.vo;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/8/29.
 */
public class TradeHistoryListVO extends BaseVO {
    List<TradeHistoryVO> tradeHistoryVOList;

    public List<TradeHistoryVO> getTradeHistoryVOList() {
        return tradeHistoryVOList;
    }

    public void setTradeHistoryVOList(List<TradeHistoryVO> tradeHistoryVOList) {
        this.tradeHistoryVOList = tradeHistoryVOList;
    }
}
