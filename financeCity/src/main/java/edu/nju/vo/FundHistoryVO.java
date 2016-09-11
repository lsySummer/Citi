package edu.nju.vo;

import edu.nju.service.POJO.FundValueHistory;

/**
 * Created by Sun YuHao on 2016/9/10.
 */
public class FundHistoryVO extends BaseVO {
    private FundValueHistory[] data;

    public FundValueHistory[] getData() {
        return data;
    }

    public void setData(FundValueHistory[] data) {
        this.data = data;
    }
}
