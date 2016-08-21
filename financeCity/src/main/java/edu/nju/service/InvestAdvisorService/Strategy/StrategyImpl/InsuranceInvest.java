package edu.nju.service.InvestAdvisorService.Strategy.StrategyImpl;

import edu.nju.model.ProductInsurance;
import edu.nju.service.Exceptions.MissRequiredInfoException;
import edu.nju.service.POJO.InvestResult;
import edu.nju.service.POJO.Product;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.TradeService.TradeItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/8/20.
 */
public class InsuranceInvest implements CategoryInvest {
    static final String categoryName = "Insurance";
    static final String paramCapital = "capital";
    static final String paramTimeLimit = "timeLimit";
    static final String paramProductAmount = "productAmount";

    @Override
    public InvestResult invest(Map<String, Object> metaInfo, SearchService searchService) throws MissRequiredInfoException {
        double timeLimit;
        int productAmount;
        double capital;
        InvestResult investResult = new InvestResult();

        try {
            capital = (double)metaInfo.get(paramCapital);
            timeLimit = (double)metaInfo.get(paramTimeLimit);
            productAmount = (int)metaInfo.get(paramProductAmount);
        }
        catch (NullPointerException n) {
            n.printStackTrace();
            throw new MissRequiredInfoException(categoryName);
        }

        List<Product> productList = searchService.getProductListByOrder(categoryName, "p.yearRate DESC");
        if (productList == null) {
            throw new MissRequiredInfoException(categoryName);
        }

        if (timeLimit == 5 || timeLimit == 10 || timeLimit < 5) {
            ExpectationSortor expectationSortor = new ExpectationSortor();
            expectationSortor.setProductListWithYearRateOrder(productList);

            productList = expectationSortor.sortByShortTermExp();
            if (timeLimit == 5) {
                productList = selectProductByDuration(productList, 5);
            }
            else if(timeLimit == 10) {
                productList = selectProductByDuration(productList, 10);
            }
        }
        else if (timeLimit == 15 || timeLimit == 20 || timeLimit > 20) {
            ExpectationSortor expectationSortor = new ExpectationSortor();
            expectationSortor.setProductListWithYearRateOrder(productList);

            productList = expectationSortor.sortByLongTermExp();
            if (timeLimit == 15) {
                productList = selectProductByDuration(productList, 15);
            }
            else if(timeLimit == 20) {
                productList = selectProductByDuration(productList, 20);
            }
        }

        investResult.addUnusedCapital(capital, categoryName);
        for (int i = 0; i < 5 && i < productList.size(); ++i) {
            investResult.addTradItem(new TradeItem(0, categoryName, productList.get(i), null));
        }

        return investResult;
    }

    private List<Product> selectProductByDuration(List<Product> productList, int duration) {
        List<Product> ret = new ArrayList<>();
        for (Product product :productList) {
            ProductInsurance productInsurance = (ProductInsurance)product.getProduct();

            //TODO:??? if correct
            int BuyTime = 0;
            int DueTime = 0;
            if (DueTime - BuyTime == duration) {
                ret.add(product);
            }
        }

        return ret;
    }

    class ExpectationSortor {
        List<Product> productList;
        List<Integer> unitCompensationOrder;
        List<Integer> yearRateOrder;
        List<Double> shortTermExp;
        List<Double> longTermExp;

        public void setProductListWithYearRateOrder(List<Product> productList) {
            this.productList = productList;
            yearRateOrder = new ArrayList<>();

            for (int i = 0; i < productList.size(); ++i) {
                yearRateOrder.add(i);
            }
        }

        public List<Product> sortByShortTermExp() {
            calcuUnitCompensationOrder();

            shortTermExp = new ArrayList<>(productList.size());
            for (int i = 0; i < productList.size(); ++i) {
                shortTermExp.set(i, yearRateOrder.get(i) * 0.7 +
                        unitCompensationOrder.get(i) * 0.3);
            }

            List<SimpleStruct> list = new ArrayList<>();
            for (int i = 0; i < productList.size(); ++i) {
                list.add(new SimpleStruct(productList.get(i), shortTermExp.get(i)));
            }

            list.sort(new Comparator<SimpleStruct>() {
                @Override
                public int compare(SimpleStruct o1, SimpleStruct o2) {
                    return o2.score.compareTo(o1.score);
                }
            });

            List<Product> ret = new ArrayList<>();
            for (SimpleStruct simpleStruct : list) {
                ret.add(simpleStruct.product);
            }

            return ret;
        }

        public List<Product> sortByLongTermExp() {
            calcuUnitCompensationOrder();

            longTermExp = new ArrayList<>(productList.size());
            for (int i = 0; i < productList.size(); ++i) {
                longTermExp.set(i, yearRateOrder.get(i) * 0.3 +
                        unitCompensationOrder.get(i) * 0.7);
            }

            List<SimpleStruct> list = new ArrayList<>();
            for (int i = 0; i < productList.size(); ++i) {
                list.add(new SimpleStruct(productList.get(i), longTermExp.get(i)));
            }

            list.sort(new Comparator<SimpleStruct>() {
                @Override
                public int compare(SimpleStruct o1, SimpleStruct o2) {
                    return o2.score.compareTo(o1.score);
                }
            });

            List<Product> ret = new ArrayList<>();
            for (SimpleStruct simpleStruct : list) {
                ret.add(simpleStruct.product);
            }

            return ret;
        }



        private void calcuUnitCompensationOrder() {
            List<Integer> noList = new ArrayList<>();
            for (int i = 0; i < productList.size(); ++i) {
                noList.add(i);
            }

            Comparator<Integer> comparator = new Comparator<Integer>() {
                List<Product> productList;

                @Override
                public int compare(Integer o1, Integer o2) {
                    Integer unitCompensation1 = 0;
                    Integer unitCompensation2 = 0;
                    return unitCompensation2.compareTo(unitCompensation1);
                }

                public Comparator<Integer> setProductList(List<Product> productList) {
                    this.productList = productList;
                    return this;
                }
            }.setProductList(productList);

            unitCompensationOrder = new ArrayList<>(noList.size());
            for (int i = 0; i < noList.size(); ++i) {
                unitCompensationOrder.set(noList.get(i), i);
            }
        }

        private class SimpleStruct {
            public Product product;
            public Double score;

            public SimpleStruct(Product product, double score) {
                this.product = product;
                this.score = score;
            }
        };
    }
}
