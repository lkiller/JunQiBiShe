/**
 * \* Created with IntelliJ IDEA.
 * \* Author: 土豆
 * \* Date: 2023/4/3
 * \* Time: 11:05
 * \* Description:军棋的登陆界面
 * \
 */
package com.lrz.Frame;

import com.lrz.pojo.Message;
import com.lrz.pojo.User;
import com.lrz.utils.SocketUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class LoginFrame extends JFrame implements ActionListener {
    private JTextField account;
    private JPasswordField password;

    private Socket socket;
    public LoginFrame() {
        //设置名称
        setTitle("军棋登陆");
        //设置大小
        setSize(400, 400);

        //设置内部元素_用户名
        JLabel jLabel_Account = new JLabel("账号");
        //jLabel.setFont(font);
        jLabel_Account.setBounds(30, 30, 50, 50);
        add(jLabel_Account);
        account = new JTextField();
        account.setBounds(70, 40, 150, 30);
        add(account);

        //设置内部元素_密码
        JLabel jLabel_Password = new JLabel("密码");
        jLabel_Password.setBounds(30, 80, 50, 50);
        add(jLabel_Password);
        password = new JPasswordField();
        password.setBounds(70, 90, 150, 30);
        add(password);

        //设置内部登陆 按钮
        JButton login_Btn = new JButton("登陆");
        login_Btn.setActionCommand("login");
        login_Btn.addActionListener(this);
        login_Btn.setBounds(30, 130, 100, 40);
        add(login_Btn);

        //设置内部注册 按钮
        JButton register_Btn = new JButton("注册");
        register_Btn.addActionListener(this);
        register_Btn.setActionCommand("register");
        register_Btn.setBounds(150, 130, 100, 40);
        add(register_Btn);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置绝对布局
        this.setLayout(null);
        //设置可见性
        setVisible(true);
        //设置居中
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd){
            case "login":
                this.login();
                break;

            case "register":
                this.register();
                break;
        }
    }

    /**
     * 实现登陆的功能，首先要获取登陆的账号和密码
     * 然后若socket为空，则new一个socket发送给服务器
     */
    private void login(){
        System.out.println("你点击了登录按钮");
        String accountStr = account.getText();
        char[] password1 = password.getPassword();
        String passwordStr = new String(password1);
        //发送这个到服务器
        User user = new User(accountStr, passwordStr);

        if(socket == null){
           socket = SocketUtil.createLocalHost(9988);
        }
        Message request = new Message();
        request.setType(Message.Type.LOGIN);//设置消息的类型
        request.setContent(user);//设置消息的内容
        request.setFrom(accountStr);
        //发送登陆请求
        SocketUtil.send(socket, request);
        //接收服务器的响应信息
        Object response = SocketUtil.receive(socket);
        //System.out.println(response);
        if(response instanceof Message){
            Message resp = (Message) response;
            if(resp.getType() == Message.Type.SUCCESS){
                //说明登陆成功，跳转到游戏大厅，并隐藏登陆界面
                LoginFrame.this.dispose();
                new SelectFrame(socket, accountStr);
            }
        }
    }
    private void register(){}
}
