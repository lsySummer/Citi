package edu.nju.action;

import com.opensymphony.xwork2.ActionContext;
import edu.nju.service.CategoryAndProduct.Product;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;
import edu.nju.service.ExceptionsAndError.ErrorManager;
import edu.nju.service.SearchService.SearchService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/9/4.
 */
public class SearchAction extends BaseAction {
    @Autowired
    SearchService searchService;

    @SuppressWarnings("unchecked")
    public String getInstitutionList() {
        //TODO:set category
        ActionContext context = ActionContext.getContext();

        List<String> bondYieldList = searchService.getBondYieldType();
        List<String> bondStateList = searchService.getBondStateType();
        List<String> fundTargetList = searchService.getFundTargetType();
        List<String> fundStateList = searchService.getFundState();

        List<String> bankInstitutionList = searchService.getInstitutionNameList(ProductCategoryManager.categoryBank);
        List<String> bondInstitutionList = searchService.getInstitutionNameList(ProductCategoryManager.categoryBond);
        List<String> fundInstitutionList = searchService.getInstitutionNameList(ProductCategoryManager.categoryFund);
        List<String> insuranceInstitutionList = searchService.getInstitutionNameList(ProductCategoryManager.categoryInsurance);

        context.put("bankInstitutionList", bankInstitutionList);
        context.put("bondInstitutionList", bondInstitutionList);
        context.put("fundInstitutionList", fundInstitutionList);
        context.put("insuranceInstitutionList", insuranceInstitutionList);

        System.out.println(bankInstitutionList);
        System.out.println(bondInstitutionList);
        System.out.println(fundInstitutionList);
        System.out.println(insuranceInstitutionList);

        context.put("bondStateList", bondStateList);
        context.put("bondYieldList", bondYieldList);
        context.put("fundStateList", fundStateList);
        context.put("fundTargetList", fundTargetList);

        return SUCCESS;
    }
}
