package edu.nju.service.CategoryAndProduct;

import edu.nju.model.ProductBank;
import edu.nju.model.ProductBond;
import edu.nju.model.ProductFund;
import edu.nju.model.ProductInsurance;

import java.math.BigDecimal;

/**
 * Created by Sun YuHao on 2016/8/26.
 */
public class Product {
    private Integer ID;
    private Category category;
    private Object product;

    public Product(Integer ID, Category category, Object product) {
        this.ID = ID;
        this.category = category;
        this.product = product;
    }

    public Integer getID() {
        return ID;
    }

    public Category getCategory() {
        return category;
    }

    public Object getProduct() {
        return product;
    }

    public String getUnit() {
        return category.getUnit();
    }

    public String getName() {
        if (category.belongTo(ProductCategoryManager.categoryBank)) {
            return ((ProductBank)product).getName();
        }
        else if (category.belongTo(ProductCategoryManager.categoryBond)) {
            return ((ProductBond)product).getName();
        }
        else if (category.belongTo(ProductCategoryManager.categoryInsurance)) {
            return ((ProductInsurance)product).getName();
        }
        else if (category.belongTo((ProductCategoryManager.categoryFund))) {
            return ((ProductFund)product).getName();
        }

        return null;
    }

    public Integer getDayLength() {
        Integer length = null;
        if (category.belongTo(ProductCategoryManager.categoryBond)) {
            length = ((ProductBond)product).getLength();
        }
        else if (category.belongTo(ProductCategoryManager.categoryBank)) {
            length = ((ProductBank)product).getLength();
        }
        else if (category.belongTo(ProductCategoryManager.categoryInsurance)) {
            length = ((ProductInsurance)product).getWarrantyPeriod() * 365;
        }
        else if (category.belongTo(ProductCategoryManager.categoryFund)) {
            length = ((ProductFund)product).getLength();
        }

        return length == null ? 0 :length;
    }

    public double getRTR() {
        BigDecimal rtr = null;
        if (category.belongTo(ProductCategoryManager.categoryBank)) {
             rtr =((ProductBank)product).getExpectedRate();
        }
        else if (category.belongTo(ProductCategoryManager.categoryBond)) {
            rtr = ((ProductBond)product).getCoupon();
        }
        else if (category.belongTo(ProductCategoryManager.categoryInsurance)) {
            rtr = ((ProductInsurance)product).getExpectedRate();
        }
        else if (category.belongTo((ProductCategoryManager.categoryFund))) {
            rtr = ((ProductFund)product).getYearlyRtnRate();
        }

        return rtr == null ? 0 : rtr.doubleValue() / 100;
    }
}
