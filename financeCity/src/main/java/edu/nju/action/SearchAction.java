package edu.nju.action;

import com.opensymphony.xwork2.ActionContext;
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
//        String productCategory = "";
//
//        SearchService searchService = ServiceManagerImpl.getInstance().getSearchService();
//        List<String> institutionList = searchService.getInstitutionNameList(productCategory);
//
//        if (institutionList == null) {
//            ErrorManager.setError(request, ErrorManager.errorDataNotFound);
//            context.put("institutionList", new String[0]);
//        }
//        else {
//            ErrorManager.setError(request, ErrorManager.errorNormal);
//            context.put("institutionList", institutionList.toArray());
//        }

//        System.out.println(institutionList.toArray());

        List<String> institutionNameList = searchService.getInstitutionNameList((String)context.get("type"));


        return SUCCESS;
    }
}
