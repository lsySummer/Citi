package edu.nju.service.AssetManagementService;

import edu.nju.model.InvestStatus;
import edu.nju.model.TradeHistory;
import edu.nju.service.BaseService.BaseFunctionServiceAdaptor;
import edu.nju.service.Exceptions.NotLoginException;
import edu.nju.service.POJO.Event;
import edu.nju.vo.InvestProductVO;
import edu.nju.vo.TimeLineVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public class AssetManagementServiceImpl extends BaseFunctionServiceAdaptor implements AssetManagementService {

    @SuppressWarnings("unchecked")
    @Override
    public List<InvestProductVO> getInvestProductVOList() {
        try {
            List<InvestStatus> list = getUserService().getUserDao().
                    find("FROM InvestStatus investStatus WHERE investHistory.id=" + getUserService().getID());
            if (list == null || list.size() == 0) {
                return null;
            }
            else {
                List investList = new ArrayList();
                InvestProductVO investProductVO = new InvestProductVO();
                for (InvestStatus investStatus : list) {
                    investProductVO.setCurrentValue(investStatus.getCurrentPrice().doubleValue());
                    investProductVO.setInitMoney(investStatus.getCurrentPrice().doubleValue());
                    //TODO:set profit rate
                    investProductVO.setProfitRate(0);
                    //TODO:set due time
                    investProductVO.setDueTime("");
                    //TODO:set invest time
                    investProductVO.setInvestTime("");
                }

                return investList;
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Event> getEvents() {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public TimeLineVO getTimeLineVO() {
        try {
            List<TradeHistory> list = (List<TradeHistory>)getUserService().getUserDao().find(
                    "FROM TradeHistory tradHistory WHERE tradeHistory.userId=" + getUserService().getID());

            //TODO:create timelineVO
        }
        catch (NotLoginException n) {
            n.printStackTrace();
        }
        return null;
    }
}
