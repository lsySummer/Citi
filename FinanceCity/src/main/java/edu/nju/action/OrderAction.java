package edu.nju.action;

import org.springframework.stereotype.Controller;

/**
 * Created by Hermit on 16/9/5.
 */
@Controller
public class OrderAction extends BaseAction {

    @SuppressWarnings("unchecked")
    public String confirm() {

        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    public String pay() {

        return SUCCESS;
    }
}
