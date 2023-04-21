/**
 * \* Created with IntelliJ IDEA.
 * \* Author: 土豆
 * \* Date: 2023/4/18
 * \* Time: 14:26
 * \* Description:
 * \
 */
package com.lrz.Frame;

import com.lrz.pojo.PlayerAccount;
import com.lrz.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class RegisterFrame extends JFrame implements ActionListener {
    private JTextField account;
    private JPasswordField password;
    private JPasswordField password_again;
    public RegisterFrame(){
        setTitle("军棋注册");
        setSize(400, 600);
        //设置内部元素_用户名
        JLabel jLabel_Account = new JLabel("请输入账号");
        jLabel_Account.setBounds(30, 30, 80, 50);
        add(jLabel_Account);
        account = new JTextField();
        account.setBounds(120, 40, 150, 30);
        add(account);

        //设置内部元素_密码
        JLabel jLabel_Password = new JLabel("请输入密码");
        jLabel_Password.setBounds(30, 80, 80, 50);
        add(jLabel_Password);
        password = new JPasswordField();
        password.setBounds(120, 90, 150, 30);
        add(password);

        //设置内部元素_确认密码
        JLabel jLabel_Password_again = new JLabel("请确认密码");
        jLabel_Password_again.setBounds(30, 130, 80, 50);
        add(jLabel_Password_again);
        password_again = new JPasswordField();
        password_again.setBounds(120, 140, 150, 30);
        add(password_again);

        //设置内部注册 按钮
        JButton register_Btn = new JButton("确定注册");
        register_Btn.addActionListener(this);
        register_Btn.setActionCommand("ok");
        register_Btn.setBounds(150, 180, 100, 40);
        add(register_Btn);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置绝对布局
        this.setLayout(null);
        //设置可见性
        setVisible(true);
        //设置居中
        setLocationRelativeTo(null);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd){
            case "ok":
                register();
                break;
        }
    }

    private void register() {
        String accountStr = account.getText();
        String passwordStr = new String(password.getPassword());
        String confirmPasswordStr = new String(password_again.getPassword());
        int insertAccount = -1;
        PlayerAccount playerAccount1 = new PlayerAccount(accountStr, passwordStr);
        if(passwordStr.equals(confirmPasswordStr)){
            SqlSession sqlSession = SqlSessionUtils.openSession();
            int createTableAccount = sqlSession.update("createTable_account");
            System.out.println("创建用户表返回值" + createTableAccount);
            PlayerAccount isExistAccount = sqlSession.selectOne("isExistAccount", playerAccount1);
            System.out.println("返回的PlayerAccount " + isExistAccount);
            if(isExistAccount == null){
                insertAccount = sqlSession.insert("insertAccount", playerAccount1);
                sqlSession.commit();
                System.out.println("insertAccount语句返回" + insertAccount);
            }else{
                JOptionPane.showMessageDialog(null, "该用户名已被使用");
            }
            if(insertAccount == 1){
                JOptionPane.showMessageDialog( null, "注册成功");
                RegisterFrame.this.dispose();
            }
        }else{
            JOptionPane.showMessageDialog(null, "密码两次输入不一样，请重新输入");
        }
    }
}
