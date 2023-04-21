/**
 * \* Created with IntelliJ IDEA.
 * \* Author: 土豆
 * \* Date: 2023/4/18
 * \* Time: 14:57
 * \* Description:
 * \
 */
package com.lrz.pojo;

/**
 * 该类用于存储用户名与数据库之间的连接
 */
public class PlayerAccount {
    private String accountStr;
    private String passwordStr;

    public PlayerAccount(String accountStr, String passwordStr) {
        this.accountStr = accountStr;
        this.passwordStr = passwordStr;
    }

    @Override
    public String toString() {
        return "PlayerAccount{" +
                "account='" + accountStr + '\'' +
                ", password='" + passwordStr + '\'' +
                '}';
    }

    public PlayerAccount() {
    }

    public String getAccount() {
        return accountStr;
    }

    public void setAccount(String accountStr) {
        this.accountStr = accountStr;
    }

    public String getPassword() {
        return passwordStr;
    }

    public void setPassword(String passwordStr) {
        this.passwordStr = passwordStr;
    }
}
