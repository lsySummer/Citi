package edu.nju.service.InvestAdvisorService.Strategy.StrategyImpl;

import edu.nju.dao.BaseDao;
import edu.nju.service.Exceptions.MissRequiredInfoException;
import edu.nju.service.POJO.InvestResult;
import edu.nju.service.SearchService.SearchService;

import java.util.Map;

/**
 * Created by Sun YuHao on 2016/8/18.
 */
public interface CategoryInvest {
    InvestResult invest(Map<String, Object> metaInfo, SearchService searchService) throws MissRequiredInfoException;
}
