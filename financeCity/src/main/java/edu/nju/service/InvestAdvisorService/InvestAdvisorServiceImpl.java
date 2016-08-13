package edu.nju.service.InvestAdvisorService;

import edu.nju.dao.BaseDao;
import edu.nju.model.User;
import edu.nju.model.UserFamilySpeeding;
import edu.nju.model.UserInformation;
import edu.nju.model.UserTemperPrefer;
import edu.nju.service.BaseService.BaseFunctionServiceAdaptor;
import edu.nju.service.Exceptions.NotAllConfigurationSetException;
import edu.nju.service.Exceptions.NotLoginException;
import edu.nju.service.InvestAdvisorService.Strategy.InvestStrategy;
import edu.nju.service.POJO.*;
import edu.nju.vo.FamilySpendingVO;
import edu.nju.vo.IdentityVO;
import edu.nju.vo.TemperPreferVO;
import edu.nju.vo.UserVO;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public class InvestAdvisorServiceImpl extends BaseFunctionServiceAdaptor implements InvestAdvisorService {

    private InvestStrategy investStrategy;

    @Override
    public boolean setIdentity(IdentityVO identity) {
        try {
            UserInformation userInformation = new UserInformation();
            userInformation.setId(getUserService().getID().intValue());
            //TODO:add timestamp
            userInformation.setCreatedAt(new Timestamp(0));
            userInformation.setExperience(Byte.valueOf(identity.getExperience()));
            userInformation.setId(getUserService().getID().intValue());
            //TODO:add intention/job/marriage/salary/update time
            userInformation.setIntention(new Byte((identity.getRiskPrefer())));
            userInformation.setJob(new Byte(identity.getJob()));
            userInformation.setMarriageStatus(new Byte(identity.getMarriage()));
            userInformation.setSalary(new Integer((int)identity.getIncome()));
            userInformation.setUpdateAt(new Timestamp(0));

            getUserService().getUserDao().saveOrUpdate(userInformation);

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public IdentityVO getIdentity() {
        try {
            UserInformation userInformation = (UserInformation) getUserService().getUserDao().
                    find("FROM UserInformation userInformation where userInformation.id=" + getUserService().getID()).get(0);

            IdentityVO identityVO = new IdentityVO();

            /* set property*/
            identityVO.setIncome(userInformation.getSalary());
            //TODO:convert experience to string
            identityVO.setExperience(userInformation.getExperience().toString());
            //TODO:convert byte to job
            identityVO.setJob("");
            identityVO.setRiskPrefer("");
            identityVO.setMarriage(userInformation.getMarriageStatus() == 1 ? "是" : "否");
            identityVO.setTarget("");

            return identityVO;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean setTemperPrefer(TemperPreferVO temperPreferVO) {
        try {
            UserTemperPrefer userTemperPrefer = new UserTemperPrefer();
            userTemperPrefer.setId(getUserService().getID().intValue());
            userTemperPrefer.setBearLoss(new BigDecimal(temperPreferVO.getBearLoss()));
            //TODO:convert time type
            userTemperPrefer.setBeginTime(new Timestamp(Long.valueOf(temperPreferVO.getBeginTime())));
            userTemperPrefer.setEndTime(new Timestamp(Long.valueOf(temperPreferVO.getEndTime())));
            userTemperPrefer.setMoney(new BigDecimal(temperPreferVO.getMoney()));
            userTemperPrefer.setStopProfit(new BigDecimal(temperPreferVO.getStopProfit()));
            //TODO:add project array

            getUserService().getUserDao().saveOrUpdate(userTemperPrefer);

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public TemperPreferVO getTemperPreferVO() {
        try {
            UserTemperPrefer userTemperPrefer = (UserTemperPrefer) getUserService().getUserDao().
                    find("FROM UserTemperPrefer userTemperPrefer where userTemperPrefer.id=" + getUserService().getID()).get(0);

            TemperPreferVO temperPreferVO = new TemperPreferVO();

            /* set property*/
            temperPreferVO.setBearLoss(userTemperPrefer.getBearLoss().toString());
            temperPreferVO.setBeginTime(userTemperPrefer.getBeginTime().toString());
            temperPreferVO.setEndTime(userTemperPrefer.getEndTime().toString());
            temperPreferVO.setMoney(userTemperPrefer.getMoney().doubleValue());
            //TODO:add project array
            //temperPreferVO.setProjectArr(userTemperPrefer.g);
            temperPreferVO.setStopProfit(userTemperPrefer.getStopProfit().doubleValue());

            return temperPreferVO;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean setFamilySpending(FamilySpendingVO familySpending) {
        try {
            UserFamilySpeeding userFamilySpeeding = new UserFamilySpeeding();
            userFamilySpeeding.setId(getUserService().getID().intValue());
            userFamilySpeeding.setIfNeed(familySpending.isIfNeed() ? new Byte((byte)1) : new Byte((byte)0));
            userFamilySpeeding.setIsPrepare(familySpending.isIfPrepare() ? new Byte((byte)1) : new Byte((byte)0));

            getUserService().getUserDao().saveOrUpdate(userFamilySpeeding);

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public FamilySpendingVO getFamilySpendingVO() {
        try {
            UserFamilySpeeding userFamilySpeeding = (UserFamilySpeeding)getUserService().getUserDao().
                    find("FROM UserFamilySpending userFamilySpending where userFamilySpending.id=" + getUserService().getID()).get(0);

            FamilySpendingVO familySpendingVO = new FamilySpendingVO();

            /* set property*/
            familySpendingVO.setIfNeed(userFamilySpeeding.getIfNeed() == 1);
            familySpendingVO.setIfPrepare(userFamilySpeeding.getIsPrepare() == 1);

            return familySpendingVO;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean ifIdentityIsSet() {
        try {
            BaseDao DAO = getUserService().getUserDao();
            List list = DAO.find("SELECT id FROM UserInformation identity WHERE identity.id=" + getUserService().getID());
            return !(list == null || list.size() == 0);
        }
        catch (NotLoginException n) {
            return false;
        }
    }

    @Override
    public boolean ifPreferenceIsSet() {
        try {
            BaseDao DAO = getUserService().getUserDao();
            List list = DAO.find("SELECT id FROM UserTemperPrefer preference WHERE preference.id=" + getUserService().getID());
            return !(list == null || list.size() == 0);
        }
        catch (NotLoginException n) {
            return false;
        }
    }

    @Override
    public boolean ifAllSet() {
        try {
            BaseDao DAO = getUserService().getUserDao();
            List list = DAO.find("SELECT id FROM UserFamilySpending familySpending WHERE familySpending.id=" + getUserService().getID());
            return !(list == null || list.size() == 0);
        }
        catch (NotLoginException n) {
            return false;
        }
    }

    @Override
    public InvestmentPortFolio createInvestmentPortFolio() throws NotAllConfigurationSetException, NotLoginException {
        BaseDao DAO = getUserService().getUserDao();
        UserInformation identity = (UserInformation)DAO.find("SELECT id FROM UserInformation identity WHERE identity.id=" + getUserService().getID()).get(0);
        UserTemperPrefer preference = (UserTemperPrefer)DAO.find("SELECT id FROM UserTemperPrefer preference WHERE preference.id=" + getUserService().getID()).get(0);
        UserFamilySpeeding familyExpense = (UserFamilySpeeding) DAO.find("SELECT id FROM UserFamilySpending familySpending WHERE familySpending.id=" + getUserService().getID()).get(0);

        return investStrategy.createInvestmentPortfolio(identity, preference, familyExpense);
    }

    @Override
    public UserVO getUserVO() {
         UserVO userVO = new UserVO();

        try {
            User user = (User)getUserService().getUserDao().
                    find("FROM User user where user.id=" + getUserService().getID()).get(0);

            userVO.setAnswer(user.getSecureAnswer());
            userVO.setEmail(user.getEmail());
            //TODO:add birthday\card number\city\if city
            userVO.setBirthday("");
            userVO.setCardNumber("");
            userVO.setCity("");
            userVO.setExpense("");
            userVO.setIfCity(false);

            return userVO;

        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
