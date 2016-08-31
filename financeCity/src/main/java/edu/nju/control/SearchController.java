package edu.nju.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sun YuHao on 2016/8/30.
 */
@Controller
@RequestMapping(value = "/api")
public class SearchController {
    @RequestMapping(value = "/search", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    String test(HttpServletRequest request) {
        return request.getSession().getId();
    }
}
