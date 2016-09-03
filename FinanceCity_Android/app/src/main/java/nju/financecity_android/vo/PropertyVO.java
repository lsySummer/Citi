package nju.financecity_android.vo;

import nju.financecity_android.R;

/**
 * Created by coral on 16-9-2.
 */
public class PropertyVO {
    public String propertyName;
    public Object value;
    public int pcolor = 0, vcolor = 0;

    public PropertyVO(String propertyName, Object value) {
        this.propertyName = propertyName;
        this.value = value;
        pcolor = R.color.propertyName;
        vcolor = R.color.propertyValue;
    }

    public PropertyVO(String propertyName, Object value, int pcolor, int vcolor) {
        this(propertyName, value);
        this.pcolor = pcolor;
        this.vcolor = vcolor;
    }
}
