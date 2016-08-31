package edu.nju.service.ExceptionsAndError;

import edu.nju.vo.BaseVO;
import org.python.antlr.ast.Str;

/**
 * Created by Sun YuHao on 2016/8/29.
 */
public class ErrorManager {
    static public final int errorNormal = 0;
    static public final int errorNotLogin = 1;
    static public final int errorDateNotFound = 2;
    static public final int errorInvalidUserOrPassword = 3;
    static public final int errorRegisterFailed = 4;
    static public final int errorNoSuchProduct = 5;
    static public final int errorInvalidParameter = 6;

    static private String[] errorDescreption;

    static {
        errorDescreption = new String[] {
                "Normal",
                "Not Login",
                "No Data Found",
                "No Such User Or Password Error",
                "Register Failed",
                "No Such Product",
                "Invalid Parameters"
        };
    }

    static private String getDescreption(int i) {
        return errorDescreption[i];
    }

    static public void setError(BaseVO baseVO, int error) {
        baseVO.setError(error);
        baseVO.setMessage(ErrorManager.getDescreption(error));
    }
}
