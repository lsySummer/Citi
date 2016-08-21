package edu.nju.service.Utils;

import edu.nju.service.POJO.AmountAndLeft;

import java.util.Map;

/**
 * Created by Sun YuHao on 2016/8/19.
 */
public class UnitTransformation {
    //int[0] ==> amount
    //int[1] ==> left
    static public AmountAndLeft getAmountAndLeft(double capital, String unit, int threshold, Map<String, Object> meta) {
        double amount = 0;
        double left = capital;
        AmountAndLeft amountAndLeft = new AmountAndLeft();
        if (unit.equals("Yuan")) {
            int increasingAmount = (int)meta.get("increasingAmount");
            left = (capital - threshold) % increasingAmount;
            amount = capital - left;
        }//Yuan
        if (unit.equals("份")) {
            double price = (double)meta.get("price");
            amount = (int)(capital / price);
            left = capital - amount * price;
        }//份

        amountAndLeft.setAmount(amount);
        amountAndLeft.setLeft(left);
        return amountAndLeft;
    }
}
