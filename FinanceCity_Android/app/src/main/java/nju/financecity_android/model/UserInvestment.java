package nju.financecity_android.model;

import nju.financecity_android.dao.InvestmentDao;
import nju.financecity_android.vo.ProductInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by coral on 16-9-13.
 */
public class UserInvestment {

    private UserInvestment() {}

    public static UserInvestment getCurrUserInvestment() {
        Map rawResult = new InvestmentDao().readData();
        if (rawResult.get("investmentPortfolioList") == null) {
            return null;
        }
        List investmentList = (List) rawResult.get("investmentPortfolioList");
        List<ProductInfo> productInfoList = new ArrayList<>();
        for (Object rawInvCom: investmentList) {
            List products = (List) ((Map) rawInvCom).get("productVOs");
            for (Object rawProduct: products) {
                Map product = (Map) rawProduct;
                ProductInfo info = new ProductInfo();
                info.currPrice = Float.valueOf(product.get("currentValue").toString());
                info.productName = product.get("name").toString();
                info.productId = product.get("id").toString();
                info.buyPrice = Float.valueOf(product.get("buyingValue").toString());
                info.buy = product.get("buyingDate").toString();
                info.expiration = product.get("endDate").toString();
                info.type = product.get("type").toString();
                productInfoList.add(info);
            }
        }
        UserInvestment investment = new UserInvestment();
        investment.mData = productInfoList;
        return investment;
    }

    public List<ProductInfo> getProductList() {
        return mData;
    }

    public List<ProductInfo> mData;
}
