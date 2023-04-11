/**
 * \* Created with IntelliJ IDEA.
 * \* Author: 土豆
 * \* Date: 2023/4/4
 * \* Time: 15:21
 * \* Description:
 * \
 */
package com.lrz.ChessServer;

import com.lrz.Chess;
import com.lrz.ChessSon.*;
import com.lrz.pojo.Message;
import com.lrz.utils.SocketUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {

    private static Map<String, ServerThread> clients;//保存所有登陆的客户端线程


    public static void main(String[] args) {
        new Server().start();
    }

    //启动服务端
    public void start() {
        try {
            ServerSocket server = new ServerSocket(9988);
            clients = new HashMap<>();
            System.out.println("服务端启动成功");
            while (true) {
                //每次进来一个客户端，都要开一个线程去服务
                Socket accept = server.accept();
                ServerThread serverThread = new ServerThread(accept);
                serverThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static Vector getAccountList(){
        Vector<String> list = new Vector<>();
        Set<String> strings = clients.keySet();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list.size() == 0 ? null : list;
    }
    public static class ServerThread extends Thread {
        private Socket socket;
        private Socket getSocket(){
            return this.socket;
        }
        public ServerThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            while (true) {
                //System.out.println(1);
                Object receive = SocketUtil.receive(socket);
                //System.out.println(receive);
                if (receive instanceof Message) {
                    Message request = (Message) receive;//向服务器发送请求消息
                    switch (request.getType()) {
                        case LOGIN:
                            Login(request);
                            break;
                        case REGISTER:
                            break;
                        case LIST:
                            getList();
                            break;
                        case CHALLENGE_SUCCESS:
                            break;
                        case CHALLENGE:
                            fight(request);
                            break;
                        case MOVE:
                            break;
                        case EAT:
                            break;
                        case PEACE:
                            break;
                        case DEFEAT:
                            break;
                        case REFRESH:
                            refresh(request);
                            break;
                    }
                }

            }
        }



        private void Login(Message message) {
            //假设登陆成功，将数据保存到客户端map中
            clients.put(message.getFrom(), this);
            //发送消息回去
            Message response = new Message();
            response.setFrom(message.getFrom());
            response.setType(Message.Type.SUCCESS);
            SocketUtil.send(socket, response);
        }
        private void getList(){
            Message resp = new Message();
            resp.setType(Message.Type.SUCCESS);
            resp.setContent(getAccountList());
            clients.forEach((k, v) ->{
                SocketUtil.send(v.getSocket(), resp);
            });
            //SocketUtil.send(socket, resp);
        }
        private void fight(Message req){
            String from = req.getFrom();
            String to  = req.getTo();
            ServerThread socketThreadFrom = clients.get(from);
            ServerThread socketThreadTo = clients.get(to);
            Message resp = new Message();//响应消息
            resp.setTo(to);
            resp.setFrom(from);
            resp.setType(Message.Type.CHALLENGE_SUCCESS);
            //规定阵营怎么写，在这
            SocketUtil.send(socketThreadFrom.getSocket(), resp);
            SocketUtil.send(socketThreadTo.getSocket(), resp);
        }

        private void refresh(Message req) {
            String to  = req.getTo();
            ServerThread socketThreadTo = clients.get(to);
            Message resp = new Message();//响应消息
            resp.setContent(req.getContent());
            resp.setType(Message.Type.REFRESH_OK);
            SocketUtil.send(socketThreadTo.getSocket(), resp);
        }
    }
}
