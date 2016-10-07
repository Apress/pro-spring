/*
 * Created on 12-Aug-2004
 */
package com.apress.prospring.ch6.security;

/**
 * @author robh
 */
public class SecurityManager {

    private static ThreadLocal threadLocal = new ThreadLocal();

    public void login(String userName, String password) {
        // assumes that all credentials
        // are valid for a login
        threadLocal.set(new UserInfo(userName, password));
    }

    public void logout() {
        threadLocal.set(null);
        int x = 0;
    }

    public UserInfo getLoggedOnUser() {
        return (UserInfo) threadLocal.get();
    }
}