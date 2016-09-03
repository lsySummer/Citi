package edu.nju.control;

import edu.nju.service.SearchService.SearchService;
import edu.nju.service.ServiceManagerImpl;
import edu.nju.service.Utils.UnitTransformation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/9/1.
 */
@Controller
@RequestMapping(value = "/")
public class BuyController {
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "order", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String getOrderPrice(@RequestBody Map map) {
        SearchService searchService = ServiceManagerImpl.getInstance().getSearchService();

        try {
            List<Map> productList = (List<Map>)map.get("product_list");
            if (productList.size() == 0) {
                return "Error:产品列表为空";
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
                return "Error:参数错误";
            }
            else {
                return String.valueOf(count);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error:计算总价时发生异常";
        }
    }
}
