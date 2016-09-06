package edu.nju.vo;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/8/29.
 */
public class CurrentInvestmentVO extends BaseVO{
    private List<ProductVO> productVOList;

    public List<ProductVO> getProductVOList() {
        return productVOList;
    }

    public void setProductVOList(List<ProductVO> productVOList) {
        this.productVOList = productVOList;
    }
}
