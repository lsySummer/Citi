package edu.nju.service.InvestAdvisorService.Strategy.StrategyImpl;

import edu.nju.service.POJO.Product;
import edu.nju.service.SearchService.SearchService;

import java.util.List;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/8/20.
 */
public interface RecommendedInsuranceSelector {
    List<Product> selectRecommendedInsurance(Map<String, Object> metaInfo, SearchService searchService);
}
