package edu.nju.service.ExceptionsAndError;

import edu.nju.vo.BaseVO;
import org.python.antlr.ast.Str;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sun YuHao on 2016/8/29.
 */
public class ErrorManager {
    static public final int errorNormal = 0;
    static public final int errorNotLogin = 1;
    static public final int errorDateNotFound = 2;
    static public final int errorInvalidPassword = 3;
    static public final int errorRegisterFailed = 4;
    static public final int errorNoSuchProduct = 5;
    static public final int errorInvalidParameter = 6;
    static public final int errorUserAlreadyExist = 7;
    static public final int errorUserNotExist = 8;
    static public final int errorInvalidMobile = 9;

    static private String[] errorDescreption;

    static {
        errorDescreption = new String[] {
                "Normal",
                "Not Login",
                "No Data Found",
                "Invalid Password",
                "Register Failed",
                "No Such Product",
                "Invalid Parameters",
                "User Already Exist",
                "User Not Exist",
                "Invalid Phone Number"
        };
    }

    static private String getDescreption(int i) {
        return errorDescreption[i];
    }

    static public void setError(BaseVO baseVO, int error) {
        baseVO.setError(error);
        baseVO.setMessage(ErrorManager.getDescreption(error));
    }

    static public void setError(HttpServletRequest request, int error) {
        request.setAttribute("error", error);
        request.setAttribute("message", ErrorManager.getDescreption(error));
    }
}
