package edu.nju.service.Utils;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Sun YuHao on 2016/9/7.
 */
public class ListUtils {
    public static void eliminateDumplicatedString(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }

        HashSet<String> h  =   new HashSet<>(list);
        list.clear();
        list.addAll(h);
    }
}
