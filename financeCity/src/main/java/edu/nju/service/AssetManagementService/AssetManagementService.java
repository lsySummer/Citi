package edu.nju.service.AssetManagementService;

import java.util.List;
import edu.nju.service.POJO.*;
import edu.nju.service.BaseService.BaseService;
import edu.nju.vo.InvestProductVO;
import edu.nju.vo.TimeLineVO;
import org.springframework.stereotype.Service;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public interface AssetManagementService extends BaseService{

    /**
     * get InvestProductVOList
     * @return investProduct
     */
    List<InvestProductVO> getInvestProductVOList();

    /**
     * get events in chronological order
     * @return events
     */
    List<Event> getEvents();

    TimeLineVO getTimeLineVO();
}
