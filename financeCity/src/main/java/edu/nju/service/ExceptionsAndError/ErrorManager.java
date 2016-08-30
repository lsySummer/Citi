package edu.nju.service.ExceptionsAndError;

import org.python.antlr.ast.Str;

/**
 * Created by Sun YuHao on 2016/8/29.
 */
public class ErrorManager {
    static public final int errorNormal = 0;
    static public final int errorNotLogin = 1;
    static public final int errorDateNotFound = 2;

    static private String[] errorDescreption;

    static {
        errorDescreption = new String[] {
                "Normal",
                "Not Login",
                "No Data Found"
        };
    }

    static public String getDescreption(int i) {
        return errorDescreption[i];
    }
}
