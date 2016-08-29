package edu.nju.service.AssetManagementService;

import java.util.List;

import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.POJO.*;
import edu.nju.service.BaseService.BaseService;
import edu.nju.service.SearchService.SearchService;
import edu.nju.vo.CurrentInvestmentVO;
import edu.nju.vo.TradeHistoryListVO;
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
    CurrentInvestmentVO getInvestProductVOList() throws NotLoginException;

    /**
     * get events in chronological order
     * @return events
     */
    List<Event> getEvents();

    void bindSearchService(SearchService searchService);

    TradeHistoryListVO getTradeHistory() throws NotLoginException;
}
