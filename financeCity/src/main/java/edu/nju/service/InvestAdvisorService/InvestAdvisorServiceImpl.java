package edu.nju.service.InvestAdvisorService;

import edu.nju.model.UserTemperPrefer;
import edu.nju.service.ExceptionsAndError.NotAllConfigurationSetException;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.InvestAdvisorService.Strategy.InvestStrategy;
import edu.nju.service.POJO.*;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.service.UserService.UserService;
import edu.nju.service.Utils.MD5Utils;
import edu.nju.vo.TemperPreferVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public class InvestAdvisorServiceImpl implements InvestAdvisorService {
    @Autowired
    SearchService searchService;
    @Autowired
    private InvestStrategy investStrategy;

    @Override
    public List<TradeInfoWithCheckCode> createInvestmentPortFolio(UserTemperPrefer preference) throws NotAllConfigurationSetException {
        if (preference == null) {
            throw new NotAllConfigurationSetException();
        }

        List<TradeInfoWithCheckCode> list = new ArrayList<>();
        List<List<SimpleTradeInfo>> info = investStrategy.createInvestmentPortfolio(preference, searchService);

        for (List<SimpleTradeInfo> item : info) {
            TradeInfoWithCheckCode tradeInfoWithCheckCode = new TradeInfoWithCheckCode();
            tradeInfoWithCheckCode.setTradeInfos(item);
            tradeInfoWithCheckCode.setCheckCode(MD5Utils.generateMD5(item.toString()));

            list.add(tradeInfoWithCheckCode);
        }

        return list;
    }
}
