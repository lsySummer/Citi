package edu.nju.service.Utils;

import edu.nju.service.CategoryAndProduct.Category;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.sql.*;
import java.util.List;

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
                Category category = ProductCategoryManager.getFundCategory(resultSet.getByte("category"));
                Integer id = resultSet.getInt("id");
                int pid = ProductCategoryManager.generateProductID(id, category.getCategoryName());

                System.out.print(resultSet.getString("name"));
                PreparedStatement prep = connection.prepareStatement(sql_insert);
                prep.setInt(1, pid);
                prep.setString(2, resultSet.getString("name"));

                prep.executeUpdate();

            }
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

    static public void main(String[] args) {
        UpdateUtils.updateNameToId_Fund();
    }
}
