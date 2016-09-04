package edu.nju.action;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import edu.nju.service.CategoryAndProduct.Product;
import edu.nju.service.ExceptionsAndError.InvalidParametersException;
import edu.nju.service.POJO.ProductVOFactory;
import edu.nju.service.POJO.SearchFilterFactory;
import edu.nju.service.SearchService.ProductFilter;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.ServiceManagerImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;

import java.util.*;

/**
 * Created by Hermit on 16/9/3.
 */
@Controller
public class SearchFilterAction extends BaseAction {


    private String test = "{\n" +
            "    'error': 0,\n" +
            "    'message': 'reason of error',\n" +
            "    'data': [\n" +
            "        {   // bank\n" +
            "            'pid': 100001,\n" +
            "            'name': 'name',\n" +
            "            'yearly_income_rate': 0.0295,\n" +
            "            'product_type': '开放式净值型',\n" +
            "            'income_type': '保本浮动收益型',\n" +
            "            'initial_money': 50000,\n" +
            "            'open_date': 'yyyy-MM-dd',\n" +
            "            'distributor_bank': '浦发银行',\n" +
            "            'distributor_institution': '浦发银行',\n" +
            "        },\n" +
            "        {   // fund\n" +
            "            'pid': 100001,\n" +
            "            'name': 'name',\n" +
            "            'expected_income_rate': 0.05,\n" +
            "            'state': '产品状态',\n" +
            "            'net_value': 10000,\n" +
            "            'sid': '基金编号',\n" +
            "            'type': '简单基金',\n" +
            "            'mng_charge_rate': 4.5,\n" +
            "            'est_date': 'yyyy-MM-dd'\n" +
            "        },\n" +
            "        {   // insurance\n" +
            "            'pid': 100001,\n" +
            "            'name': 'name',\n" +
            "            'insurance_life': '终身',\n" +
            "            'insurance_age': 30,\n" +
            "            'amount_in_force': [100000, 200000],    //保额区间\n" +
            "            'way_of_charge': '缴费方式',\n" +
            "            'distributor': '叉叉基金'\n" +
            "        },\n" +
            "        {   // bond\n" +
            "            'pid': 100001,\n" +
            "            'name': 'name',\n" +
            "            'yearly_interest_rate': 0.07,\n" +
            "            'nominal_interest_rate': 0.025, // 票面利率\n" +
            "            'life': 2,  // 债券期限\n" +
            "            'type': '债券类型',\n" +
            "            'code': '债券代码'\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<>();

        map.put("error", 0);
        map.put("message", "none");

        Map<String, Object> bank = new HashMap<>();
        bank.put("pid", "0001");
        bank.put("yearly_income_rate", "0.0295");
        bank.put("product_type", "开放式净值型");
        bank.put("income_type", "保本浮动收益型");
        bank.put("initial_money", "50000");
        bank.put("open_date", "yyyy-MM-dd");
        bank.put("distributor_bank", "浦发银行");
        bank.put("distributor_institution", "浦发银行");

        ArrayList<Map> list = new ArrayList<>();
        list.add(bank);

        map.put("data", list);

        return map;
    }

    @SuppressWarnings("unchecked")
    public String filter() {
        SearchService searchService = ServiceManagerImpl.getInstance().getSearchService();
        ActionContext context = ActionContext.getContext();

        String json_data = request.getParameter("data");

        Map<String, Object> map = null;

        JSONObject jsonObject = JSONObject.fromObject(json_data);
        map = jsonToMap(jsonObject);


        if(map==null){
            return SUCCESS;
        }

        String type = (String) map.get("type");
        String key = (String) map.get("keyword");
        String page_num_string = (String) map.get("page_num");

        int page_num = Integer.parseInt(page_num_string);
        System.out.println(type+" "+page_num);

//        try {
//            ProductFilter productFilter = SearchFilterFactory.createFilter(type, map);
//            List<Product> productList = searchService.searchProductsByKey(key);
//
//            ProductVOFactory productVOFactory = new ProductVOFactory();
//            for (Product product : productList) {
//                if (productFilter.isChosen(product.getProduct())) {
//                    productVOFactory.addProduct(product);
//                }
//            }
//
//            JSONArray jsonArray = JSONArray.fromObject(productVOFactory.getResultList());
//
//            context.put("searchResult", jsonArray.toString());
//
//        } catch (InvalidParametersException e) {
//            e.printStackTrace();
//        }

//        JSONObject result = JSONObject.fromObject(test);

//        System.out.println(result.toString());



        context.put("searchResultJSON", JSON.toJSON(test));
        context.put("searchResult", getMap());

        context.put("currentPage", 1);
        context.put("pageLength", 10);

        return SUCCESS;
    }

    private Map<String, Object> jsonToMap(JSONObject jsonObject) {

        Map<String, Object> map = new HashMap<>();
        map.put("keyword", jsonObject.get("keyword"));
        map.put("type", jsonObject.get("type"));
        map.put("page_num", jsonObject.get("page_num"));

        JSONObject options = jsonObject.getJSONObject("options");

        Map<String, Object> optMap = new HashMap<>();
        Iterator it = options.keys();
        while(it.hasNext()){
            String key = (String) it.next();
            optMap.put(key, options.get(key));
        }

        map.put("options", optMap);

        return map;
    }
}
