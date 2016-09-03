package edu.nju.vo;

import edu.nju.model.PayWay;

/**
 * Created by Sun YuHao on 2016/9/1.
 */
public class PayWayVO extends BaseVO {
    PayWayResult[] date;

    public PayWayResult[] getDate() {
        return date;
    }

    public void setDate(PayWayResult[] date) {
        this.date = date;
    }

    public class PayWayResult {
        int pid;
        String description;

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
