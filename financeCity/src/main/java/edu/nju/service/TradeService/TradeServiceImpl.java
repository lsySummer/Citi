package edu.nju.service.TradeService;

import edu.nju.model.UnpaidItem;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public class TradeServiceImpl implements TradeService {
    @Autowired
    UserService userService;
    
    //10 minutes
    private final long expiration = 10 * 60 * 1000;

    @Override
    public List<String> buyProduct(List<TradeItem> tradeItemList, FinanceCityUser financeCityUser) {
        List<String> checkCodeList = new ArrayList<>();
        Timestamp expiration_time = new Timestamp(System.currentTimeMillis() + expiration);
        try {
            for (TradeItem tradeItem : tradeItemList) {
                UnpaidItem unpaidItem = new UnpaidItem();
                unpaidItem.setId(financeCityUser.getID());
                unpaidItem.setExpirationTime(expiration_time);
                unpaidItem.setAmount(tradeItem.getAmount());
                unpaidItem.setUnit(tradeItem.getProduct().getUnit());
                unpaidItem.setTradingVolume(new BigDecimal(tradeItem.getTradingVolume()));
                unpaidItem.setProductId(tradeItem.getProduct().getID());
                //check code
                String checkCode = tradeItem.generateMD5(financeCityUser.getID(), expiration_time.toString());
                unpaidItem.setCheckCode(checkCode);

                userService.getUserDao(financeCityUser).save(unpaidItem);
                checkCodeList.add(checkCode);
            }

            return checkCodeList;
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            cancelAllUnpaid(financeCityUser);
            return null;
        }
    }

    @Override
    public boolean cancelUnpaid(String checkCode, FinanceCityUser financeCityUser) {
        try {
            List list = userService.getUserDao(financeCityUser).find("FROM UnpaidItem unpaidItem WHERE unpaidItem.checkCode=" +
            checkCode + " AND unpaidItem.userId=" + financeCityUser.getID());

            if (!(list == null || list.size() == 0)) {
                UnpaidItem unpaidItem = (UnpaidItem)list.get(0);
                userService.getUserDao(financeCityUser).delete(unpaidItem);
            }

            return true;
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean cancelAllUnpaid(FinanceCityUser financeCityUser) {
        try {
            userService.getUserDao(financeCityUser).query("DELETE UnpaidItem u WHERE u.userId=" + financeCityUser.getID());
            return true;
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean redeemProduct(Integer ProductID, FinanceCityUser financeCityUser) {
        return false;
    }

    @Override
    public boolean enforceInvestmentPlan() {
        return false;
    }
}
