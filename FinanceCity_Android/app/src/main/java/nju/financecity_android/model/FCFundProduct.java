package nju.financecity_android.model;

/**
 * Created by coral on 16-9-3.
 */
public class FCFundProduct extends FCBaseProduct {

    public FCFundProduct(String productId) {
        super(productId);
    }

    @Override
    protected void processDate() {
        String fadingmingcheng;
        String jijinbianhao;
        String guanlijigou;
        String tuoguanjigou;
        double jinyinianshouyilv;
        int zuixinjinzhi;
        int jijintouzimubiaoleixing;
        String yejibijiaojizhun;
        String genzongbiaodi;
        String fengxiandengji;
        int zhuangtai;
        int shifoufengbi;
        double shengoufeilv;
        double rengoufeilv;
        double shuhuifeilv;
        double guangyiguanlifeilv;
        int qigoujine;
        int dizenggoumaizuixiaodanwei;
        String mujikaishiri;
        String mujijiezhiri;
        String qixiri;
        String kaifangri;
        int qixian;
        int rengousudu;
        int shuhuisudu;
        String jijinjingli;
        int jijingguimo;
        int feneguimo;

        fadingmingcheng = mRawData.get("name").toString();
        jijinbianhao = mRawData.get("product_code").toString();
        guanlijigou = mRawData.get("institution_manage").toString();
        tuoguanjigou = mRawData.get("institution_trusteeship").toString();
        jinyinianshouyilv = Double.parseDouble(mRawData.get("last_year_rate").toString());
        zuixinjinzhi = Integer.parseInt(mRawData.get("NAV").toString());
        jijintouzimubiaoleixing = Integer.parseInt(mRawData.get("fund_type").toString());
        yejibijiaojizhun = mRawData.get("perf_benchmark").toString();
        genzongbiaodi = mRawData.get("target_ID").toString();
        fengxiandengji = mRawData.get("risk_level").toString();
        zhuangtai = Integer.parseInt(mRawData.get("state").toString());
        shifoufengbi = Integer.parseInt(mRawData.get("operation_mode").toString());
        shengoufeilv = Integer.parseInt(mRawData.get("rate_purchase").toString());
        rengoufeilv = Integer.parseInt(mRawData.get("rate_subscribe").toString());
        shuhuifeilv = Integer.parseInt(mRawData.get("rate_redem").toString());
        guangyiguanlifeilv = Double.parseDouble(mRawData.get("rate_manage").toString());
        qigoujine = Integer.parseInt(mRawData.get("purchase_threshold").toString());
        dizenggoumaizuixiaodanwei = Integer.parseInt(mRawData.get("increasing_unit").toString());
        mujikaishiri = mRawData.get("on_purchase_day").toString();
        mujijiezhiri = mRawData.get("off_purchase_day").toString();
        qixiri = mRawData.get("first_accr_date").toString();
        kaifangri = mRawData.get("on_redemption_date").toString();
        qixian = Integer.parseInt(mRawData.get("length").toString());
        rengousudu = Integer.parseInt(mRawData.get("subscribe_speed").toString());
        shuhuisudu = Integer.parseInt(mRawData.get("redem_speed").toString());
        jijinjingli = mRawData.get("manager_name").toString();
        jijingguimo = Integer.parseInt(mRawData.get("fund_size").toString());
        feneguimo = Integer.parseInt(mRawData.get("share_size").toString());

        mData.put("法定名称", fadingmingcheng);
        mData.put("基金编号", jijinbianhao);
        mData.put("管理机构", guanlijigou);
        mData.put("托管机构", tuoguanjigou);
        mData.put("近一年收益率", jinyinianshouyilv);
        mData.put("最新净值", zuixinjinzhi + "元");
        mData.put("基金投资目标类型", jijintouzimubiaoleixing);
        switch (jijintouzimubiaoleixing) {
            case 0:
                mData.put("基金投资目标类型", "股票型");
                break;
            case 1:
                mData.put("基金投资目标类型", "债券型");
                break;
            case 2:
                mData.put("基金投资目标类型", "货币型");
                break;
            case 3:
                mData.put("基金投资目标类型", "混合型");
                break;
            case 4:
                mData.put("基金投资目标类型", "eft");
                break;
            case 5:
                mData.put("基金投资目标类型", "lof");
                break;
            case 6:
                mData.put("基金投资目标类型", "fof");
                break;
            case 7:
                mData.put("基金投资目标类型", "QDII");
                break;
            case 8:
                mData.put("基金投资目标类型", "指数型");
                break;
            case 9:
                mData.put("基金投资目标类型", "保本型");
                break;
            default:
                mData.put("基金投资目标类型", "--");
        }
        mData.put("业绩比较标准", yejibijiaojizhun);
        mData.put("跟踪标的", genzongbiaodi);
        mData.put("风险等级", fengxiandengji + "级");
        switch (zhuangtai) {
            case 0:
                mData.put("状态", "申购中");
                break;
            case 1:
                mData.put("状态", "认购中");
                break;
            case 2:
                mData.put("状态", "已关闭");
                break;
            default:
                mData.put("状态", "--");
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
        mData.put("认购费率", String.valueOf(rengoufeilv * 100) + "%");
        mData.put("广义管理费率", String.valueOf(guangyiguanlifeilv * 100) + "%");
        mData.put("起购金额", "￥" + qigoujine);
        mData.put("递增购买最小单位", "￥" + dizenggoumaizuixiaodanwei);
        mData.put("募集开始日", mujikaishiri);
        mData.put("募集截止日", mujijiezhiri);
        mData.put("起息日", qixiri);
        mData.put("开放日", kaifangri);
        mData.put("期限", qixian + "天");
        mData.put("认购速度", rengousudu + "天");
        mData.put("赎回速度", shuhuisudu + "天");
        mData.put("基金经理", jijinjingli);
        mData.put("基金规模", "￥" + jijingguimo);
        mData.put("份额规模", "￥" + feneguimo);
    }
}
