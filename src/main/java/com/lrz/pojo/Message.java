/**
 * \* Created with IntelliJ IDEA.
 * \* Author: 土豆
 * \* Date: 2023/4/5
 * \* Time: 9:32
 * \* Description:Socket发送消息的类
 * \
 */
package com.lrz.pojo;

import com.lrz.Frame.GameFrame;

import java.io.Serializable;

public class Message implements Serializable {
    //消息的主体内容
    private Object content;
    private GameFrame gameFrame;//游戏内容，传输这个是因为要同步两边的棋子布局
    @Override
    public String toString() {
        return "Message{" +
                "content=" + content +
                ", type=" + type +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Message() {
    }

    public Message(Object content, Type type, String from, String to) {
        this.content = content;
        this.type = type;
        this.from = from;
        this.to = to;
    }

    //消息类型
    private Type type;

    private String from;
    private String to;

    public static enum Type {
        LOGIN,//登陆
        REGISTER,//注册
        LIST,//获取当前所有人
        CHALLENGE,//挑战
        CHALLENGE_SUCCESS,//发送挑战请求成功
        MOVE,//移动
        TURN_OVER,//翻棋
        EAT,//吃子
        EAT_ZHA,//炸弹炸
        EAT_TOGETHER,//同归于尽
        PEACE,//求和
        DEFEAT,//认输
        SUCCESS,//发送成功
        FAILURE,//发送失败
        REFRESH,//刷新棋谱
        REFRESH_OK,//刷新棋谱
        CONFIRM_NO_1,//表示player1发送的还确认没有阵营
        CONFIRM_NO_8,//表示还没有阵营，不过是8
        CONFIRM_OK,//确定阵营成功
        HUIQI,//开始悔棋
        HUIQI_CONFIRM,//请求悔棋
        HUIQI_OK,//同意悔棋
        HUIQI_NO//不同意悔棋

    }
}
