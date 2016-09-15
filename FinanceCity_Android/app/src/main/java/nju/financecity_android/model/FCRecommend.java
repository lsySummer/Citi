package nju.financecity_android.model;

import nju.financecity_android.dao.RecommendDao;
import nju.financecity_android.vo.RecommendCombVO;
import nju.financecity_android.vo.RecommendSingleVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by coral on 16-9-15.
 */
public class FCRecommend {

    private FCRecommend() {
        combinationList = new ArrayList<>();
    }

    public static FCRecommend getRecommend() {
        FCRecommend result = new FCRecommend();
        result.combinationList = new ArrayList<>();
        RecommendDao dao = new RecommendDao();
        Map rawData = dao.readData();
        List recComb = null;
        if (rawData.containsKey("data")) {
            recComb = (List) rawData.get("data");
        } else {
            return null;
        }
        for (Object combination: recComb) {
            Map comb = (Map) combination;
            RecommendCombVO combVO = new RecommendCombVO();
            combVO.productList = new ArrayList<>();
            if (!comb.containsKey("portfolio")) {
                return null;
            }
            List prodList = (List) comb.get("portfolio");
            for (Object rawProduct: prodList) {
                Map product = (Map) rawProduct;
                RecommendSingleVO singleVO = new RecommendSingleVO();
                singleVO.amount = (int) Double.parseDouble(product.get("amount").toString());
                singleVO.productId = Integer.parseInt(product.get("productId").toString());
                combVO.productList.add(singleVO);
            }
            result.combinationList.add(combVO);
        }
        return result;
    }

    private List<RecommendCombVO> combinationList;
}
