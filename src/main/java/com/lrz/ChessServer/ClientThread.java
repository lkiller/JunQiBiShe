/**
 * \* Created with IntelliJ IDEA.
 * \* Author: 土豆
 * \* Date: 2023/4/5
 * \* Time: 15:08
 * \* Description:
 * \
 */
package com.lrz.ChessServer;

import com.lrz.pojo.Message;
import com.lrz.utils.SocketUtil;

import java.net.Socket;
import java.util.Vector;

public class ClientThread extends Thread{
    private Socket socket;
    private ResponseListener L;
    private boolean shutDown;

    public void setShutDown(boolean shutDown) {
        this.shutDown = shutDown;
    }

    public boolean isShutDown() {
        return shutDown;
    }

    public ClientThread(Socket socket, ResponseListener L){
        this.socket = socket;
        this.L =  L;
    }
    public interface ResponseListener{
        void success(Message message);
    }

    @Override//相当于代理模式，有点难
    public void run() {
        while(!shutDown){
            System.out.println("执行run");
            Object receive = SocketUtil.receive(socket);//接收服务端传回的信息
            if(receive == null){
                continue;
            }
            //System.out.println("服务端传回的信息：" + receive);
            if(receive instanceof Message){
                Message resp = (Message) receive;
                if(L != null){
                    L.success(resp);
                }
                /*    Message resp = (Message) receive;
                model.clear();
                Vector<String> v = (Vector<String>)resp.getContent();
                v.forEach(item ->{
                    model.addElement(item);
                });
                jlist.validate();*/
            }
        }
    }
}
