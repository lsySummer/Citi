package edu.nju.dao.impl;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/8/21.
 */
public interface CommonDao {
    List find(String queryString);
    List find(String queryString, int days);
}
