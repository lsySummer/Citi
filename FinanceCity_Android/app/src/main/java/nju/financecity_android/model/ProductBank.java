package nju.financecity_android.model;

/**
 * Created by coral on 16-9-3.
 */
public class    ProductBank extends BaseProduct {

    public ProductBank(String productId) {
        super(productId);
    }

    @Override
    protected void processData() {
        String chanpinmingcheng;
        String chanpinqici;
        String guanlijigou;
        String tuoguanjigou;
        double yujinianhuashouyilv;
        int shouyileixing;
        int fengxiandengji;
        int shifoujingzhixing;
        int shifoufengbi;
        double shengoufeilv;
        double shuhuifeilv;
        double guangyiguanlifeilv;
        int qigoujine;
        int dizenggoumaizuixiaodanwei;
        String mujikaishiri;
        String mujijiezhiri;
        String qixiri;
        String kaifangri;
        int qixian;
        int shuhuisudu;
        int licaibizhong;
        String touzifanwei;
        String touzibili;
        String chanpinbianma;
        String dengjibianma;
        String xiaoshouquyu;
        int yunxingguimoshangxian;
        String licaibenjinjishouyizhifu;
        String faxingduixiang;

        chanpinmingcheng = mRawData.get("name").toString();
        chanpinqici = mRawData.get("session").toString();
        guanlijigou = mRawData.get("institutionManage").toString();
        tuoguanjigou = mRawData.get("custodian").toString();
        yujinianhuashouyilv = Double.valueOf(mRawData.get("NAV").toString());
        shouyileixing = Integer.parseInt(mRawData.get("incomeType").toString());
        fengxiandengji = Integer.parseInt(mRawData.get("riskLevel").toString());
        shifoujingzhixing = Integer.parseInt(mRawData.get("ifNAVType").toString());
        shifoufengbi = Integer.parseInt(mRawData.get("ifClose").toString());
        shengoufeilv = Double.parseDouble(mRawData.get("ratePurchase").toString());
        shuhuifeilv = Double.parseDouble(mRawData.get("rateRedem").toString());
        guangyiguanlifeilv = Double.parseDouble(mRawData.get("rateManage").toString());
        qigoujine = Integer.parseInt(mRawData.get("purchaseThreshold").toString());
        dizenggoumaizuixiaodanwei = Integer.parseInt(mRawData.get("increasingUnit").toString());
        mujikaishiri = mRawData.get("onPurchaseDate").toString();
        mujijiezhiri = mRawData.get("offPurchaseDate").toString();
        qixiri = mRawData.get("startInterestDate").toString();
        kaifangri = mRawData.get("onRedemptionDate").toString();
        qixian = Integer.parseInt(mRawData.get("length").toString());
        shuhuisudu = Integer.parseInt(mRawData.get("redemSpeed").toString());
        licaibizhong = Integer.parseInt(mRawData.get("currency").toString());
        touzifanwei = mRawData.get("investField").toString();
        touzibili = mRawData.get("investRatio").toString();
        chanpinbianma = mRawData.get("productCode").toString();
        dengjibianma = mRawData.get("registerCode").toString();
        xiaoshouquyu = mRawData.get("salesTerritory").toString();
        yunxingguimoshangxian = Integer.parseInt(mRawData.get("sizeUpperLimit").toString());
        licaibenjinjishouyizhifu = mRawData.get("payType").toString();
        faxingduixiang = mRawData.get("objectOriented").toString();

        mData.put("产品名称", chanpinmingcheng);
        mData.put("产品期次", chanpinqici);
        mData.put("管理机构", guanlijigou);
        mData.put("托管机构", tuoguanjigou);
        String strYjnhsyl = String.valueOf(yujinianhuashouyilv * 100);
        if (strYjnhsyl.length() > 4) strYjnhsyl = strYjnhsyl.substring(0, 4);
        strYjnhsyl += "%";
        mData.put("预计年化收益率", strYjnhsyl);
        switch (shouyileixing) {
            case 0:
                mData.put("收益类型", "保本收益型");
                break;
            case 1:
                mData.put("收益类型", "保本浮动收益型");
                break;
            case 2:
                mData.put("收益类型", "非保本浮动收益型");
                break;
            default:
                mData.put("收益类型", "--");
        }
        mData.put("风险等级", fengxiandengji + "级");
        switch (shifoujingzhixing) {
            case 0:
                mData.put("是否净值型", "否");
                break;
            case 1:
                mData.put("是否净值型", "是");
                break;
            default:
                mData.put("是否净值型", "--");
        }
        switch (shifoufengbi) {
            case 0:
                mData.put("是否封闭", "否");
                break;
            case 1:
                mData.put("是否封闭", "是");
                break;
            default:
                mData.put("是否封闭", "--");
        }
        mData.put("申购费率", String.valueOf(shengoufeilv * 100) + "%");
        mData.put("赎回费率", String.valueOf(shuhuifeilv * 100) + "%");
        mData.put("广义管理费率", String.valueOf(guangyiguanlifeilv * 100) + "%");
        mData.put("起购金额", "￥" + qigoujine);
        mData.put("递增购买最小单位", "￥" + dizenggoumaizuixiaodanwei);
        mData.put("募集开始日", mujikaishiri);
        mData.put("募集截止日", mujijiezhiri);
        mData.put("起息日", qixiri);
        mData.put("开放日", kaifangri);
        mData.put("期限", qixian + "天");
        mData.put("赎回速度", shuhuisudu + "天");
        mData.put("理财币种", licaibizhong);
        mData.put("投资范围", touzifanwei);
        mData.put("投资比例", touzibili);
        mData.put("登记编码", dengjibianma);
        mData.put("产品编码", chanpinbianma);
        mData.put("销售区域", xiaoshouquyu);
        mData.put("运行规模上限", yunxingguimoshangxian + "亿元");
        mData.put("理财本金及收益支付", licaibenjinjishouyizhifu);
        mData.put("发行对象", faxingduixiang);
        if (shifoujingzhixing == 1)
            mData.put("历史净值", mRawData.get("history"));
    }
}
