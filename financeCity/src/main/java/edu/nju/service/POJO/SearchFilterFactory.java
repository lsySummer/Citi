package edu.nju.service.POJO;

import Jama.Matrix;
import edu.nju.model.ProductBank;
import edu.nju.model.ProductBond;
import edu.nju.model.ProductFund;
import edu.nju.model.ProductInsurance;
import edu.nju.service.CategoryAndProduct.Product;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;
import edu.nju.service.ExceptionsAndError.InvalidParametersException;
import edu.nju.service.SearchService.ProductFilter;
import org.python.antlr.ast.Str;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/8/31.
 */
public class SearchFilterFactory {
    static public ProductFilter createFilter(String type, Map map) {
        return null;
    }

    @SuppressWarnings("unchecked")
    static private ProductFilter createAllFilter(Map map) throws InvalidParametersException {
        double[] year_rate = new double[2];
        int[] expiration = new int[2];
        Boolean is_closed_ended;

        try {
            Map option = (Map)map.get("options");
            List<String> list = (List<String>)option.get("yearly_income_rate");
            init_arrary(list, year_rate);

            list = (List<String>)option.get("expiration");
            init_arrary(list, expiration);

            String if_close = (String)map.get("is_close_ended");
            if (if_close == null) {
                is_closed_ended = null;
            }
            else {
                is_closed_ended = Integer.valueOf(if_close) == 1;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new InvalidParametersException("createAllFilter");
        }


        ProductFilter productFilter = new ProductFilter() {
            double[] year_rate;
            int[] expiration;
            Boolean is_closed_ended;

            @Override
            public boolean isChosen(Object product) {
                if (product instanceof ProductBank) {
                    ProductBank productBank = (ProductBank)product;
                    return  (productBank.getExpectedRate().doubleValue() > year_rate[0] && productBank.getExpectedRate().doubleValue() < year_rate[1] &&
                            productBank.getLength() > expiration[0] && productBank.getLength() < expiration[1] &&
                            (is_closed_ended == null || ProductCategoryManager.ifClosedBankProduct(productBank) == is_closed_ended));
                }
                else if (product instanceof ProductBond) {
                    //TODO:if close
                    ProductBond productBond = (ProductBond)product;
                    return  (productBond.getYearRate().doubleValue() >= year_rate[0] && productBond.getYearRate().doubleValue() <= year_rate[1] &&
                            productBond.getLength() >= expiration[0] && productBond.getLength() <= expiration[1] &&
                            (is_closed_ended == null || false));
                }
                else if (product instanceof ProductInsurance) {
                    //TODO:if close
                    ProductInsurance productInsurance = (ProductInsurance)product;
                    return  (productInsurance.getExpectedRate().doubleValue() >= year_rate[0] && productInsurance.getExpectedRate().doubleValue() <= year_rate[1] &&
                            productInsurance.getLength() >= expiration[0] && productInsurance.getLength() <= expiration[1] &&
                            (is_closed_ended == null || false));
                }
                else if (product instanceof ProductFund) {
                    ProductFund productFund = (ProductFund)product;
                    return  (productFund.getYearlyRtnRate().doubleValue() >= year_rate[0] && productFund.getYearlyRtnRate().doubleValue() <= year_rate[1] &&
                            productFund.getLength() >= expiration[0] && productFund.getLength() <= expiration[1] &&
                            (is_closed_ended == null || (productFund.getOperationMode() == 1) == is_closed_ended));
                }
                else {
                    return false;
                }
            }

            @Override
            public List<String> getSearchScope() {
                return null;
            }

            private ProductFilter setParam(double[] year_rate, int[] expiration, Boolean is_closed_ended) {
                this.year_rate = year_rate;
                this.expiration = expiration;
                this.is_closed_ended = is_closed_ended;

                return this;
            }
        }.setParam(year_rate, expiration, is_closed_ended);

        return productFilter;
    }

    @SuppressWarnings("unchecked")
    static private ProductFilter createBondFilter(Map map) throws InvalidParametersException {
        double[] year_rate = new double[2];
        int[] expiration = new int[2];
        Timestamp expiration_date;
        Byte state;

        try {
            Map option = (Map)map.get("options");
            List<String> list = (List<String>)option.get("yearly_income_rate");
            init_arrary(list, year_rate);

            list = (List<String>)option.get("expiration");
            init_arrary(list, expiration);

            String expiration_date_s = (String)option.get("expiration_date");
            if (expiration_date_s == null) {
                expiration_date = null;
            }
            else {
                expiration_date = Timestamp.valueOf(expiration_date_s);
            }

            String state_s = (String)option.get("state");
            if (state_s == null) {
                state = null;
            }
            else {
                state = Byte.valueOf(state_s);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new InvalidParametersException("createBondFilter");
        }

        ProductFilter productFilter = new ProductFilter() {
            double[] year_rate = new double[2];
            int[] expiration = new int[2];
            Timestamp expiration_date;
            Byte state;

            @Override
            public boolean isChosen(Object product) {
                ProductBond productBond = (ProductBond)product;

                //TODO:judge date
                return (productBond.getYearRate().doubleValue() >= year_rate[0] && productBond.getYearRate().doubleValue() <=  year_rate[1] &&
                productBond.getLength() >= expiration[0] && productBond.getLength() <= expiration[1] &&
                        (expiration_date == null || expiration_date.after(productBond.getMaturityDate())) &&
                        (state == null || state.equals(productBond.getState())));
            }

            @Override
            public List<String> getSearchScope() {
                List<String> list = new ArrayList<String>();
                list.add(ProductCategoryManager.categoryBond);

                return list;
            }

            private ProductFilter setParam(double[] year_rate, int[] expiration, Timestamp expiration_date, Byte state) {
                this.year_rate = year_rate;
                this.expiration = expiration;
                this.expiration_date = expiration_date;
                this.state = state;

                return this;
            }
        }.setParam(year_rate, expiration, expiration_date, state);

        return productFilter;
    }

    @SuppressWarnings("unchecked")
    static private ProductFilter createFundFilter(Map map) throws InvalidParametersException {
        String institution_manage;
        Byte type;
        Byte state;
        int[] net_value = new int[2];
        Boolean is_close_ended;
        Byte sort_type = 0;
        int[] expiration = new int[2];

        try {
            Map option = (Map)map.get("options");
            List<String> list = (List<String>)option.get("expiration");
            init_arrary(list, expiration);

            list = (List<String>)option.get("net_value");
            init_arrary(list, net_value);

            institution_manage = (String)option.get("institution_manage");

            String type_s = (String)option.get("type");
            if (type_s == null) {
                type = null;
            }
            else {
                type = Byte.valueOf(type_s);
            }

            String state_s = (String)option.get("state");
            if (state_s == null) {
                state = null;
            }
            else {
                state = Byte.valueOf(state_s);
            }

            String sort_s = (String)option.get("sort_type");
            if (sort_s == null) {
                sort_type = null;
            }
            else {
                sort_type = Byte.valueOf(sort_s);
            }

            String if_close = (String)map.get("is_close_ended");
            if (if_close == null) {
                is_close_ended = null;
            }
            else {
                is_close_ended = Byte.valueOf(if_close) == 1;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new InvalidParametersException("createFundFilter");
        }

        ProductFilter productFilter = new ProductFilter() {
            String institution_manage;
            Byte type;
            Byte state;
            int[] net_value = new int[2];
            Boolean is_close_ended;
            Byte sort_type = 0;
            int[] expiration = new int[2];

            @Override
            public boolean isChosen(Object product) {
                ProductFund productFund = (ProductFund)product;
                return (institution_manage == null || institution_manage.equals(productFund.getInstitutionManage()) &&
                        (type == null || type.equals(productFund.getCategory())) &&
                        (state == null || state.equals(productFund.getState())) &&
                        (net_value[0] <= productFund.getNav().doubleValue() && net_value[1] >= productFund.getNav().doubleValue()) &&
                        (is_close_ended == null || is_close_ended.equals(productFund.getOperationMode() == 1)) &&
                        (expiration[0] <= productFund.getLength() && expiration[1] >= productFund.getLength()));
            }

            @Override
            public List<String> getSearchScope() {
                List<String> list = new ArrayList<>();
                list.add(ProductCategoryManager.categoryFund);

                return list;
            }

            private ProductFilter setParam(String institution_manage, Byte type, Byte state, int[] net_value,
                                           Boolean is_close_ended, Byte sort_type, int[] expiration) {
                this.institution_manage = institution_manage;
                this.state = state;
                this.net_value = net_value;
                this.type = type;
                this.is_close_ended = is_close_ended;
                this.sort_type = sort_type;
                this.expiration = expiration;

                return  this;

            }
        }.setParam(institution_manage, type, state, net_value, is_close_ended, sort_type, expiration);

        return productFilter;
    }

    @SuppressWarnings("unchecked")
    static private ProductFilter createBankFilter(Map map) throws InvalidParametersException {
        double[] year_rate = new double[2];
        int[] init_amount = new int[2];
        int[] expiration = new int[2];
        String institution_manage;
        Byte income_type;
        Boolean is_close_ended;

        try {
            Map option = (Map)map.get("options");
            List<String> list = (List<String>)option.get("yearly_income_rate");
            init_arrary(list, year_rate);

            list = (List<String>)option.get("expiration");
            init_arrary(list, expiration);

            list = (List<String>)option.get("initial_amount");
            init_arrary(list, init_amount);

            String if_close = (String)map.get("is_close_ended");
            if (if_close == null) {
                is_close_ended = null;
            }
            else {
                is_close_ended = Integer.valueOf(if_close) == 1;
            }

            institution_manage = (String)option.get("institution_manage");

            String income_t = (String)option.get("income_type");
            if (income_t == null) {
                income_type = null;
            }
            else {
                income_type = Byte.valueOf(income_t);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new InvalidParametersException("createBankFilter");
        }

        ProductFilter productFilter = new ProductFilter() {
            double[] year_rate = new double[2];
            int[] init_amount = new int[2];
            int[] expiration = new int[2];
            String institution_manage;
            Byte income_type;
            Boolean is_close_ended;

            @Override
            public boolean isChosen(Object product) {
                ProductBank productBank = (ProductBank)product;

                return (productBank.getExpectedRate().doubleValue() >= year_rate[0] && productBank.getExpectedRate().doubleValue() <= year_rate[1] &&
                productBank.getLength() >= expiration[0] && productBank.getLength() <= expiration[1] &&
                productBank.getPurchaseThreshold() >= init_amount[0] && productBank.getPurchaseThreshold() <= init_amount[1] &&
                        (institution_manage == null || institution_manage.equals(productBank.getInstitutionManage())) &&
                        (income_type == null || income_type.equals(productBank.getIncomeType())) &&
                        (is_close_ended == null || is_close_ended.equals(ProductCategoryManager.ifClosedBankProduct(productBank))));
            }

            @Override
            public List<String> getSearchScope() {
                List<String> list = new ArrayList<>();
                list.add(ProductCategoryManager.categoryBank);
                return list;
            }

            private ProductFilter setParam(double[] year_rate, int[] init_amount, int[] expiration, String institution_manage,
                                  Byte income_type, Boolean is_closed_ended) {
                this.year_rate =year_rate;
                this.init_amount = init_amount;
                this.expiration = expiration;
                this.institution_manage = institution_manage;
                this.income_type = income_type;
                this.is_close_ended = is_closed_ended;

                return this;
            }
        }.setParam(year_rate, init_amount, expiration, institution_manage, income_type, is_close_ended);

        return productFilter;
    }

    @SuppressWarnings("unchecked")
    static private ProductFilter createInsurance(Map map) throws InvalidParametersException {
        int[] year_length = new int[2];
        double[] income_rate = new double[2];
        String distributor;
        Integer price;

        try {
            Map option = (Map)map.get("options");
            List<String> list = (List<String>)option.get("length_of_years");
            init_arrary(list, year_length);

            list = (List<String>)option.get("income_rate");
            init_arrary(list, income_rate);

            distributor = (String)option.get("distributor");

            String price_s = (String)option.get("price");
            if (price_s == null) {
                price = null;
            }
            else {
                price = Integer.valueOf(price_s);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new InvalidParametersException("createInsurance");
        }

        ProductFilter productFilter = new ProductFilter() {
            int[] year_length = new int[2];
            double[] income_rate = new double[2];
            String distributor;
            Integer price;

            @Override
            public boolean isChosen(Object product) {
                ProductInsurance productInsurance = (ProductInsurance)product;

                return (productInsurance.getLength() >= year_length[0] && productInsurance.getLength() <= year_length[1] &&
                productInsurance.getYearRate().doubleValue() >= income_rate[0] && productInsurance.getYearRate().doubleValue() <= income_rate[1] &&
                        (distributor == null || distributor.equals(productInsurance.getInstitutionManage())) &&
                        (price == null || price.equals(productInsurance.getDenomination())));
            }

            @Override
            public List<String> getSearchScope() {
                List<String> list = new ArrayList<String>();
                list.add(ProductCategoryManager.categoryInsurance);

                return list;
            }

            private ProductFilter setParam(int[] year_length, double[] income_rate, String distributor, Integer price) {
                this.year_length = year_length;
                this.income_rate = income_rate;
                this.distributor = distributor;
                this.price = price;

                return this;
            }
        }.setParam(year_length, income_rate, distributor, price);

        return productFilter;
    }

    static private void init_arrary(List<String> list, double[] array) throws Exception {
        if (list == null || list.size() == 0) {
            array[0] = 0;
            array[1] = Double.MAX_VALUE;
        }
        else {
            array[0] = Double.valueOf(list.get(0));
            array[1] = Double.valueOf(list.get(1));
        }
    }

    static private void init_arrary(List<String> list, int[] array) throws Exception {
        if (list == null || list.size() == 0) {
            array[0] = 0;
            array[1] = Integer.MAX_VALUE;
        }
        else {
            array[0] = Integer.valueOf(list.get(0));
            array[1] = Integer.valueOf(list.get(1));
        }
    }
}
