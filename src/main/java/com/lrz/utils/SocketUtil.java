/**
 * \* Created with IntelliJ IDEA.
 * \* Author: 土豆
 * \* Date: 2023/4/4
 * \* Time: 10:49
 * \* Description:Socket的工具类，包括获取socket和发送socket两个方法
 * \
 */
package com.lrz.utils;

import com.lrz.pojo.Message;
import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketUtil {

    public static Socket create(String ip, int port){
        try {
            return new Socket(InetAddress.getByName(ip), port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Socket createLocalHost(int port){
        try {
            return new Socket(InetAddress.getLocalHost(), port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




    public static void send(Socket s, Message msg){
        OutputStream outputStream = null;
        ObjectOutputStream oos = null;
        try {
             outputStream = s.getOutputStream();
             oos = new ObjectOutputStream(outputStream);
             oos.writeObject(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object receive(Socket s){
        InputStream inputStream = null;
        ObjectInputStream ois = null;
        try {
            inputStream = s.getInputStream();
            ois = new ObjectInputStream(inputStream);
            return ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public void close(InputStream is, OutputStream os){
        if(is != null){
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(os != null){
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
