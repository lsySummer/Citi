package edu.nju.action;

import com.opensymphony.xwork2.ActionContext;
import edu.nju.service.ExceptionsAndError.ErrorManager;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.ServiceManagerImpl;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/9/4.
 */
public class SearchAction extends BaseAction {
    @SuppressWarnings("unchecked")
    public String getInstitutionList() {
        //TODO:set category
        String productCategory = request.getParameter("type");
        ActionContext context = ActionContext.getContext();

        try {

            SearchService searchService = ServiceManagerImpl.getInstance().getSearchService();
            List<String> institutionList = searchService.getInstitutionNameList(productCategory);

            if (institutionList == null) {
                ErrorManager.setError(request, ErrorManager.errorDataNotFound);
                context.put("institutionList", new String[0]);
            } else {
                ErrorManager.setError(request, ErrorManager.errorNormal);
                context.put("institutionList", institutionList.toArray());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            ErrorManager.setError(request, ErrorManager.errorNormal);
            context.put("institutionList", new String[0]);
        }

        return SUCCESS;
    }
}
