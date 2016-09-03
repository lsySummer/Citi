package edu.nju.service.Sessions;

import edu.nju.service.ServiceManagerImpl;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Sun YuHao on 2016/9/2.
 */
public class OnlineUserListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        FinanceCityUser financeCityUser = (FinanceCityUser)session.getAttribute("user");

        try {
            if (financeCityUser != null) {
                ServiceManagerImpl.getInstance().getUserService().logout(financeCityUser);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
