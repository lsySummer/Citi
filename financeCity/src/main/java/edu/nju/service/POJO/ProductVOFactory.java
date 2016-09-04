package edu.nju.service.POJO;

import edu.nju.model.ProductBank;
import edu.nju.model.ProductBond;
import edu.nju.model.ProductFund;
import edu.nju.model.ProductInsurance;
import edu.nju.service.CategoryAndProduct.Product;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;
import edu.nju.service.SearchService.ProductFilter;
import edu.nju.vo.BankVO;
import edu.nju.vo.BondVO;
import edu.nju.vo.FundVO;
import edu.nju.vo.InsuranceVO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

/**
 * Created by Sun YuHao on 2016/9/1.
 */
public class ProductVOFactory {
    private List<Object> poducts = new ArrayList<>();

    public void addProduct(Product product) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (product.getCategory().equals(ProductCategoryManager.categoryBond)) {
            BondVO bondVO = new BondVO();
            ProductBond productBond = (ProductBond)product.getProduct();

            bondVO.setProductType("bond");
            bondVO.setProductId(product.getID());
            bondVO.setType(product.getCategory().getChineseName());
            bondVO.setCode(productBond.getProductCode());
            bondVO.setLife(productBond.getLength());
            bondVO.setName(productBond.getTitle());
            bondVO.setNominal_interest_rate(productBond.getCoupon().doubleValue());
            bondVO.setPid(product.getID());
            bondVO.setYearly_interest_rate(productBond.getAdjustYearlyRate().doubleValue());

            poducts.add(bondVO);
        }
        else if (product.getCategory().equals(ProductCategoryManager.categoryBank)) {
            BankVO bankVO = new BankVO();
            ProductBank productBank = (ProductBank)product.getProduct();

            bankVO.setProductType("bank");
            bankVO.setProductId(product.getID());
            bankVO.setPid(product.getID());
            bankVO.setName(productBank.getName());
            bankVO.setIncome_type(ProductCategoryManager.getBankIncomeTypeInChinese(productBank));
            bankVO.setInitial_money(productBank.getPurchaseThreshold());
            bankVO.setOpen_date(dateFormat.format(productBank.getOnRedemptionDate()));
            bankVO.setYearly_income_rate(productBank.getExpectedRate().doubleValue());
            bankVO.setProduct_type(ProductCategoryManager.getBankType(productBank));
            //TODO:check if right
            bankVO.setDistributor_bank(productBank.getCustodian());
            bankVO.setDistributor_institution(productBank.getInstitutionManage());

            poducts.add(bankVO);
        }
        else if (product.getCategory().equals(ProductCategoryManager.categoryInsurance)) {
            InsuranceVO insuranceVO = new InsuranceVO();
            ProductInsurance productInsurance = (ProductInsurance)product.getProduct();

            insuranceVO.setProductType("insurance");
            insuranceVO.setProductId(product.getID());
            insuranceVO.setName(productInsurance.getName());
            insuranceVO.setDistributor(productInsurance.getInstitutionManage());
            insuranceVO.setPid(product.getID());
            insuranceVO.setWay_of_charge(ProductCategoryManager.getInsurancePayType(productInsurance));
            //TODO:data missing
            insuranceVO.setAmount_in_force(new int[2]);
            insuranceVO.setInsurance_age(0);
            insuranceVO.setInsurance_lift("");

            poducts.add(insuranceVO);
        }
        else if (product.getCategory().belongTo(ProductCategoryManager.categoryFund)) {
            ProductFund productFund = (ProductFund)product.getProduct();
            FundVO fundVO = new FundVO();

            fundVO.setProductType("fund");
            fundVO.setProductId(product.getID());
            fundVO.setPid(product.getID());
            fundVO.setName(productFund.getName());
            fundVO.setExpected_income_rate(productFund.getYearlyRtnRate().doubleValue());
            fundVO.setState(ProductCategoryManager.getFundState(productFund));
            fundVO.setNet_value(productFund.getNav().intValue());
            fundVO.setSid(productFund.getProductCode());
            fundVO.setType(product.getCategory().getChineseName());
            fundVO.setMng_charge_rate(productFund.getRateManage().doubleValue());
            //TODO:set est date
            fundVO.setEst_date(dateFormat.format(productFund.getOnPurchaseDate()));

            poducts.add(fundVO);
        }
    }

    public Object[] getResultList() {
        if (poducts.size() == 0) {
            return new Object[0];
        }
        else {
            return poducts.toArray();
        }
    }
}
