package edu.nju.service.TradeService;

import edu.nju.model.UnpaidItem;
import edu.nju.service.BaseService.BaseFunctionServiceAdaptor;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public class TradeServiceImpl extends BaseFunctionServiceAdaptor implements TradeService {
    //10 minutes
    private final long expiration = 10 * 60 * 1000;

    @Override
    public List<String> buyProduct(List<TradeItem> tradeItemList) {
        List<String> checkCodeList = new ArrayList<>();
        Timestamp expiration_time = new Timestamp(System.currentTimeMillis() + expiration);
        try {
            for (TradeItem tradeItem : tradeItemList) {
                UnpaidItem unpaidItem = new UnpaidItem();
                unpaidItem.setId(getUserService().getID());
                unpaidItem.setExpirationTime(expiration_time);
                unpaidItem.setAmount(tradeItem.getAmount());
                unpaidItem.setUnit(tradeItem.getProduct().getUnit());
                unpaidItem.setTradingVolume(new BigDecimal(tradeItem.getTradingVolume()));
                unpaidItem.setProductId(tradeItem.getProduct().getID());
                //check code
                String checkCode = tradeItem.generateMD5(getUserService().getID(), expiration_time.toString());
                unpaidItem.setCheckCode(checkCode);

                getUserService().getUserDao().save(unpaidItem);
                checkCodeList.add(checkCode);
            }

            return checkCodeList;
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            cancelAllUnpaid();
            return null;
        }
    }

    @Override
    public boolean cancelUnpaid(String checkCode) {
        try {
            List list = getUserService().getUserDao().find("FROM UnpaidItem unpaidItem WHERE unpaidItem.checkCode=" +
            checkCode + " AND unpaidItem.userId=" + getUserService().getID());

            if (!(list == null || list.size() == 0)) {
                UnpaidItem unpaidItem = (UnpaidItem)list.get(0);
                getUserService().getUserDao().delete(unpaidItem);
            }

            return true;
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean cancelAllUnpaid() {
        try {
            getUserService().getUserDao().query("DELETE UnpaidItem u WHERE u.userId=" + getUserService().getID());
            return true;
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean redeemProduct(Integer ProductID) {
        return false;
    }

    @Override
    public boolean enforceInvestmentPlan() {
        return false;
    }
}
