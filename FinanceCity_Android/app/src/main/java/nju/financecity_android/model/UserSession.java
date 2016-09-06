package nju.financecity_android.model;

/**
 * Created by coral on 16-9-4.
 */
public class UserSession {

    private UserSession() { }

    public static UserSession getCurrUser() {
        return currUser;
    }

    public String getUserId() {
        return userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public static void disableUser() {
        currUser = null;
    }

    public boolean isLoggedIn() {
        return currUser == null;
    }

    static UserSession currUser;

    String userId;
    String sessionId;
}
