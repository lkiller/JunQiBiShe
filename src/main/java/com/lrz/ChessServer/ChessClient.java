/**
 * \* Created with IntelliJ IDEA.
 * \* Author: 土豆
 * \* Date: 2023/4/5
 * \* Time: 9:47
 * \* Description:记录客户端数据
 * \
 */
package com.lrz.ChessServer;

public class ChessClient {
    private String account;
    private Server.ServerThread serverThread;

    public ChessClient() {
    }

    public ChessClient(String account, Server.ServerThread serverThread) {
        this.account = account;
        this.serverThread = serverThread;
    }

    public String getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "ChessClient{" +
                "account='" + account + '\'' +
                ", serverThread=" + serverThread +
                '}';
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Server.ServerThread getServerThread() {
        return serverThread;
    }

    public void setServerThread(Server.ServerThread serverThread) {
        this.serverThread = serverThread;
    }
}
