/*
 * Created on 12-Aug-2004
 */
package com.apress.prospring.ch6.security;


class UserInfo {
    private String userName;

    private String password;

    public UserInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
    public String getUserName() {
        return userName;
    }
}