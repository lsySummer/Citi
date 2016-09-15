package edu.nju.service.POJO;

import edu.nju.vo.ProductVO;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/9/10.
 */
public class Investment_portfolio {
    private List<ProductVO> productVOs;
    private String checkCode;

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public List<ProductVO> getProductVOs() {
        return productVOs;
    }

    public void setProductVOs(List<ProductVO> productVOs) {
        this.productVOs = productVOs;
    }
}
