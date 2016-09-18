package edu.nju.service.InvestAdvisorService.Strategy.StrategyImpl;

import edu.nju.service.CategoryAndProduct.Category;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;

/**
 * Created by Sun YuHao on 2016/9/18.
 */
class CategoryInfo {
    //TODO:change according to database
    static final int historyNum = 30;

    private Category category;  //资产类型
    private boolean chosen;  //是否选中
    private double E[];      //资产的历史收益率序列
    //double Er;        //预期年化收益率
    private double  W;     //资产的市值
    private double  Exp;     //专家预期收益观点
    private double  LC;      //观点的置信度
    private double  flowCapital; //流动资金
    private double  freeCapital; //固定投资资金

    static public CategoryInfo[] getCatetories() {
        CategoryInfo[] categoryInfos = new CategoryInfo[ProductCategoryManager.categoryNum];

        int no = 0;
        for (Category category : ProductCategoryManager.getCategoryList()) {
            if (!category.equals(ProductCategoryManager.categoryFund)) {
                categoryInfos[no] = new CategoryInfo();
                categoryInfos[no].category = category;
                ++no;
            }
        }

        return categoryInfos;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isChosen() {
        return chosen;
    }

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }

    public double[] getE() {
        return E;
    }

    public void setE(double[] e) {
        E = e;
    }

    public double getW() {
        return W;
    }

    public void setW(double w) {
        W = w;
    }

    public double getExp() {
        return Exp;
    }

    public void setExp(double exp) {
        Exp = exp;
    }

    public double getLC() {
        return LC;
    }

    public void setLC(double LC) {
        this.LC = LC;
    }

    public double getFlowCapital() {
        return flowCapital;
    }

    public void setFlowCapital(double flowCapital) {
        this.flowCapital = flowCapital;
    }

    public double getFreeCapital() {
        return freeCapital;
    }

    public void setFreeCapital(double freeCapital) {
        this.freeCapital = freeCapital;
    }
}
