/**
 * \* Created with IntelliJ IDEA.
 * \* Author: 土豆
 * \* Date: 2023/2/10
 * \* Time: 20:42
 * \* Description:
 * \
 */
package com.lrz.pojo;

import java.sql.Timestamp;

/**
 * 该类存储了保存棋盘的名字，时间戳，个数
 */
public class SaveNum {
    private int id;
    private String name;
    private String timestamp;
    private String culPlayer;
    private int player;

    public SaveNum(int id, String name, String timestamp,String culPlayer, int player) {
        this.id = id;
        this.name = name;
        this.timestamp = timestamp;
        this.culPlayer = culPlayer;
        this.player = player;
    }

    public SaveNum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCulPlayer() {
        return culPlayer;
    }

    public void setCulPlayer(String culPlayer) {
        this.culPlayer = culPlayer;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }
}
