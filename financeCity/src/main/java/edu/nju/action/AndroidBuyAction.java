package edu.nju.action;

import edu.nju.service.SearchService.SearchService;
import edu.nju.service.ServiceManagerImpl;

import java.util.List;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/9/3.
 */
public class AndroidBuyAction extends AndroidAction {
    public String getOrderPrice() {
        Map map = getRequestMap();

        SearchService searchService = ServiceManagerImpl.getInstance().getSearchService();

        try {
            List<Map> productList = (List<Map>)map.get("product_list");
            if (productList.size() == 0) {
                setTextResult("Error:产品列表为空");
            }

            double count;
            int id[] = new int[productList.size()];
            int amount[] = new int[productList.size()];

            for (int i = 0; i < productList.size(); ++i) {
                Map productMap = productList.get(i);
                String id_s = (String)productMap.get("pid");
                String amount_s = (String)productMap.get("amount");

                id[i] = Integer.valueOf(id_s);
                amount[i] = Integer.valueOf(amount_s);
            }

            count = searchService.getCost(id, amount);
            if (count < 0) {
                setTextResult("Error:参数错误");
            }
            else {
                setTextResult(String.valueOf(count));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            setTextResult("Error:计算总价时发生异常");
        }

        return SUCCESS;
    }
}
