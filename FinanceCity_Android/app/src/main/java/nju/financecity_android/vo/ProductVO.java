package nju.financecity_android.vo;

/**
 * Created by Administrator on 2016/9/6.
 */
public class ProductVO {
    private String pid;
    private String name;
    private String type;
    private double year;
    private String introduction;

    public ProductVO(String pid, String name, String type, double year, String introduction) {
        this.pid = pid;
        this.name = name;
        this.type = type;
        this.year = year;
        this.introduction = introduction;
    }

    public String getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getYear() {
        return year;
    }

    public String getIntroduction() {
        return introduction;
    }
}
