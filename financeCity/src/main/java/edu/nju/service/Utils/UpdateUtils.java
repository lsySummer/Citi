package edu.nju.service.Utils;

import edu.nju.service.CategoryAndProduct.Category;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by Sun YuHao on 2016/9/7.
 */
@Component
public class UpdateUtils {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://123.206.202.103:3306/citi?useUnicode=true&characterEncoding=UTF-8";
    private static final String username = "user";
    private static final String password = "root";

    //update fund
    static public void updateNameToId_Fund() {
        Connection connection = getConn();

        String sql_select = "SELECT * FROM product_fund";
        String sql_insert = "INSERT INTO name_to_id(id, name) values(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql_select);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Byte type = resultSet.getByte("category");
                if (resultSet.wasNull()) {
                    type = null;
                }
                Category category = ProductCategoryManager.getFundCategory(type);
                Integer id = resultSet.getInt("id");
                int pid = ProductCategoryManager.generateProductID(id, category.getCategoryName());

                System.out.print(resultSet.getString("name"));
                PreparedStatement prep = connection.prepareStatement(sql_insert);
                prep.setInt(1, pid);
                prep.setString(2, resultSet.getString("name"));

                prep.executeUpdate();

            }
            connection.close();
        }
        catch (SQLException s) {
            s.printStackTrace();
        }
    }


    static public void updateNameToId_Bank() {
        Connection connection = getConn();

        String sql_select = "SELECT * FROM product_bank";
        String sql_insert = "INSERT INTO name_to_id(id, name) values(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql_select);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category category = ProductCategoryManager.getCategoryByName(ProductCategoryManager.categoryBank);
                Integer id = resultSet.getInt("id");
                int pid = ProductCategoryManager.generateProductID(id, category.getCategoryName());

                System.out.print(resultSet.getString("name"));
                PreparedStatement prep = connection.prepareStatement(sql_insert);
                prep.setInt(1, pid);
                prep.setString(2, resultSet.getString("name"));

                prep.executeUpdate();

            }
            connection.close();
        }
        catch (SQLException s) {
            s.printStackTrace();
        }
    }

    static public void updateNameToId_Bond() {
        Connection connection = getConn();

        String sql_select = "SELECT * FROM product_bond";
        String sql_insert = "INSERT INTO name_to_id(id, name) values(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql_select);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category category = ProductCategoryManager.getCategoryByName(ProductCategoryManager.categoryBond);
                Integer id = resultSet.getInt("id");
                int pid = ProductCategoryManager.generateProductID(id, category.getCategoryName());

                System.out.println(pid);
                PreparedStatement prep = connection.prepareStatement(sql_insert);
                prep.setInt(1, pid);
                prep.setString(2, resultSet.getString("name"));

                prep.executeUpdate();

            }
            connection.close();
        }
        catch (SQLException s) {
            s.printStackTrace();
        }
    }

    static public void updateFundDaily() {
        Connection connection = getConn();

        String sql_select = "SELECT * FROM product_fund";
        String sql_insert = "UPDATE fund_daily_history SET fund_id = ? WHERE product_code = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql_select);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Byte type = resultSet.getByte("category");
                if (resultSet.wasNull()) {
                    type = null;
                }
                Category category = ProductCategoryManager.getFundCategory(type);
                Integer id = resultSet.getInt("id");
                String product_code = resultSet.getString("product_code");
                int pid = ProductCategoryManager.generateProductID(id, category.getCategoryName());

                //System.out.print(resultSet.getString("name"));
                PreparedStatement prep = connection.prepareStatement(sql_insert);
                prep.setInt(1, pid);
                prep.setInt(2, Integer.valueOf(product_code));

                prep.executeUpdate();

            }
            connection.close();
        }
        catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public static void updateIfNav_Bank() {
        Connection connection = getConn();

        String sql_select = "SELECT * FROM product_bank";
        String sql_insert = "UPDATE product_bank SET if_NAV_type = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql_select);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                BigDecimal nav = resultSet.getBigDecimal("nav");

                System.out.println(resultSet.getString("name"));
                if (nav != null) {
                    PreparedStatement prep = connection.prepareStatement(sql_insert);
                    prep.setInt(2, id);
                    prep.setByte(1, (byte)1);

                    prep.executeUpdate();
                }
            }
            connection.close();
        }
        catch (SQLException s) {
            s.printStackTrace();
        }
    }

    static public void cleanTradHistory() {
        Connection connection = getConn();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM citi.trade_history");
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("DELETE FROM citi.unpaid_item");
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("DELETE FROM citi.invest_status");
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("DELETE FROM citi.invested_products");
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("DELETE FROM citi.investment_portfolio");
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("DELETE FROM citi.investment_portfolio");
            preparedStatement.executeUpdate();

            connection.close();
        }
        catch (SQLException s) {
            s.printStackTrace();
        }
    }

    static private Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return conn;
    }

    public static void updateFundScore() {
        final int history_num = 365;
        Connection connection = getConn();

        try {
            //get HS300,bond index return
            String getSci300 = "SELECT HS300_return, bond_index_return FROM Hs300_daily INNER JOIN bond_index_return ON Hs300_daily.date = bond_index_return.date ORDER BY Hs300_daily.date DESC";
            PreparedStatement preparedStatement = connection.prepareStatement(getSci300);
            preparedStatement.setMaxRows(history_num);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Double> hs300 = new ArrayList<>();
            List<Double> bondIndex = new ArrayList<>();
            while (resultSet.next()) {
                hs300.add(resultSet.getBigDecimal("HS300_return").doubleValue() / 100 + 1);
                bondIndex.add(resultSet.getBigDecimal("bond_index_return").doubleValue() / 100 + 1);
            }

            //get total
            String getTotal = "SELECT COUNT(*) AS count FROM product_fund";
            preparedStatement = connection.prepareStatement(getTotal);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int total = resultSet.getInt("count");

            //get rpt
            String getFunds = "SELECT id, category FROM product_fund ORDER BY id";
            String getFundDaily = "SELECT daily_return FROM fund_daily_history WHERE fund_id=? ORDER BY date DESC";
            preparedStatement = connection.prepareStatement(getFunds);
            resultSet = preparedStatement.executeQuery();
            int done = 0;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Byte category_byte = resultSet.getByte("category");
                if (resultSet.wasNull()) {
                    category_byte = null;
                }

                Category category = ProductCategoryManager.getFundCategory(category_byte);
                int pid = ProductCategoryManager.generateProductID(id, category.getCategoryName());

                PreparedStatement prep = connection.prepareStatement(getFundDaily);
                prep.setInt(1, pid);
                prep.setMaxRows(history_num);

                ResultSet res = prep.executeQuery();
                List<Double> rpt = new ArrayList<>();
                while (res.next()) {
                    rpt.add(res.getBigDecimal("daily_return").doubleValue() / 100 + 1);
                }

                int min_size = Math.min(hs300.size(), bondIndex.size());
                min_size = Math.min(min_size, rpt.size());
                System.out.print("Process Size:" + min_size);

                List<Double> hs300_t = hs300.subList(0, min_size);
                List<Double> bondIndex_t = bondIndex.subList(0, min_size);
                List<Double> rpt_t = rpt.subList(0, min_size);

                List<Double> empty =  getEmptyList(min_size);
                double ret = SFA.getFundScore(rpt_t, hs300_t, bondIndex_t, empty, empty, empty, empty);

                String add_score = "UPDATE product_fund SET fund_score=? WHERE id=?";
                prep = connection.prepareStatement(add_score);
                prep.setBigDecimal(1, new BigDecimal(ret));
                prep.setInt(2, ProductCategoryManager.getProductItemIndex(pid));
                prep.executeUpdate();

                done++;
                System.out.println("Fund " + pid + " Scores:" + ret);
                System.out.println(done + "/" + total + " items have been done");

                //if (done >= 10) {
                //    break;
                //}
            }


        }
        catch (SQLException s) {
            s.printStackTrace();
        }
    }

    static public void updateFundYearlyRate() {
        Connection connection = getConn();

        String getFunds = "SELECT id, category FROM product_fund";
        try {
            PreparedStatement prep = connection.prepareStatement(getFunds);
            ResultSet resultSet = prep.executeQuery();

            int done = 0;

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Byte type = resultSet.getByte("category");
                if (resultSet.wasNull()) {
                    type = null;
                }
                Category category = ProductCategoryManager.getFundCategory(type);
                int pid = ProductCategoryManager.generateProductID(id, category.getCategoryName());

                System.out.print("Fund " + pid);

                String getNowNAV = "SELECT NAV FROM fund_daily_history WHERE fund_id=? ORDER BY date DESC LIMIT 1";
                prep = connection.prepareStatement(getNowNAV);
                prep.setInt(1, pid);
                ResultSet res = prep.executeQuery();
                res.next();
                double nowNAV = res.getBigDecimal("NAV").doubleValue();

                Date yearBefore = TimeTransformation.getDateBeforeNow(1, TimeTransformation.year);
                String getYearBefore = "SELECT NAV FROM fund_daily_history WHERE fund_id=? AND to_days(?)<to_days(date) ORDER BY date LIMIT 1";
                prep = connection.prepareStatement(getYearBefore);
                prep.setInt(1, pid);
                prep.setDate(2, yearBefore);
                res = prep.executeQuery();
                res.next();
                double yearBeforeNAV = res.getBigDecimal("NAV").doubleValue();

                double RTR = (nowNAV - yearBeforeNAV) / yearBeforeNAV;
                RTR *= 100;
                System.out.println(" RTR:" + RTR);


                String insert = "UPDATE product_fund SET yearly_rtn_rate=? WHERE id=?";
                prep = connection.prepareStatement(insert);
                prep.setBigDecimal(1, new BigDecimal(RTR));
                prep.setInt(2, ProductCategoryManager.getProductItemIndex(pid));
                prep.executeUpdate();
            }
        }
        catch (SQLException s) {
            s.printStackTrace();
        }
    }

    static private List<Double> getEmptyList(int length) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < length; ++i) {
            list.add(0d);
        }

        return list;
    }

    public static void test() {
        Connection connection = getConn();
        try {
            PreparedStatement p = connection.
                    prepareStatement("SELECT pbk.*, pbd.*  FROM citi.product_bank pbk, citi.product_bond pbd INNER JOIN citi.name_to_id n ON pbk.id=n.id WHERE n.name LIKE '%%'");
            p.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    static public void main(String[] args) {
        UpdateUtils.updateFundScore();
    }
}
