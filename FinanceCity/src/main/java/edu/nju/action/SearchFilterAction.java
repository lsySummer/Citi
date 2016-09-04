package edu.nju.action;

import com.mathworks.toolbox.javabuilder.external.org.json.JSONArray;
import com.mathworks.toolbox.javabuilder.external.org.json.JSONException;
import com.mathworks.toolbox.javabuilder.external.org.json.JSONObject;
import com.opensymphony.xwork2.ActionContext;
import edu.nju.service.CategoryAndProduct.Product;
import edu.nju.service.ExceptionsAndError.InvalidParametersException;
import edu.nju.service.POJO.ProductVOFactory;
import edu.nju.service.POJO.SearchFilterFactory;
import edu.nju.service.SearchService.ProductFilter;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.ServiceManagerImpl;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Hermit on 16/9/3.
 */
@Controller
public class SearchFilterAction extends BaseAction {

//    public static final String ALL = "all";
//    public static final String BANK = "bank";
//    public static final String BOND = "bond";
//    public static final String FUND = "fund";
//    public static final String INSURANCE = "insurance";

    @SuppressWarnings("unchecked")
    public String filter() {
        SearchService searchService = ServiceManagerImpl.getInstance().getSearchService();
        ActionContext context = ActionContext.getContext();

        String json_data = request.getParameter("data");

        Map<String, Object> map = null;
        try {
            JSONObject jsonObject = new JSONObject(json_data);
            map = jsonToMap(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(map==null){
            return SUCCESS;
        }

        String type = (String) map.get("type");
        String key = (String) map.get("keyword");

        try {
            ProductFilter productFilter = SearchFilterFactory.createFilter(type, map);
            List<Product> productList = searchService.searchProductsByKey(key);

            ProductVOFactory productVOFactory = new ProductVOFactory();
            for (Product product : productList) {
                if (productFilter.isChosen(product.getProduct())) {
                    productVOFactory.addProduct(product);
                }
            }

            JSONArray list = new JSONArray();

            context.put("searchResult", productVOFactory.getResultList());

        } catch (InvalidParametersException e) {
            e.printStackTrace();
        }


        context.put("currentPage", 1);
        context.put("pageLength", 10);

        return SUCCESS;
    }

    private Map<String, Object> jsonToMap(JSONObject jsonObject) {
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("keyword", jsonObject.get("keyword"));
            map.put("type", jsonObject.get("type"));

            JSONObject options = jsonObject.getJSONObject("options");

            Map<String, Object> optMap = new HashMap<>();
            Iterator it = options.keys();
            while(it.hasNext()){
                String key = (String) it.next();
                optMap.put(key, options.get(key));
            }

            map.put("options", optMap);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return map;
    }
}
