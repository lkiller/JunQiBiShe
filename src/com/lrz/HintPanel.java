/**
 * \* Created with IntelliJ IDEA.
 * \* Author: 土豆
 * \* Date: 2023/2/4
 * \* Time: 23:03
 * \* Description:
 * \
 */
package com.lrz;

import com.lrz.Frame.MainFrame;
import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HintPanel extends JPanel implements ActionListener {
    public JTextArea jTextArea = null;
    public MainFrame mainFrame = null;
    JLabel colorLabel = new JLabel("翻棋以确定阵营");
    public JLabel j1 = null;
    public JLabel j2 = null;
    public JLabel j3 = null;
    public JLabel j4 = null;
    public JLabel redDiLei = null;
    public JLabel blueDiLei = null;
    /*
    * 设置按钮样式*/
    public static void setBtn(JButton btn){
        Font f = new Font("隶书",Font.PLAIN,30);
        btn.setFont(f);
        btn.setSize(1200,200);
    }

    public HintPanel(MainFrame mainFrame){
        j1 = new JLabel();
        j2 = new JLabel();
        j3 = new JLabel();
        j4 = new JLabel();
        redDiLei = new JLabel();
        blueDiLei = new JLabel();
        this.setLayout(null);
        this.mainFrame = mainFrame;
        JButton huiQi = new JButton("悔棋");
        JButton save = new JButton("保存");
        JButton impt = new JButton("导入");
        JButton getFail = new JButton("认输");

        JPanel nextPlayer = new JPanel();
        nextPlayer.setBounds(0, 40, 120, 30);
        j1.setBounds(0,350,120,30);
        j2.setBounds(0,400,120,30);
        j3.setBounds(0,450,120,30);
        j4.setBounds(0,500,120,30);
        redDiLei.setBounds(0,600,120,30);
        blueDiLei.setBounds(0,650,120,30);

        colorLabel.setFont(new Font("宋体", Font.BOLD,13));
        nextPlayer.add(colorLabel);
        //jTextArea = new JTextArea("该红方走了fefefefefefefefefefe", 15, 10);
        //jTextArea.setLineWrap(true);//设置当文本字长度超过frame的宽度时自动换行
        //jTextArea.setWrapStyleWord(true);
        JScrollPane scrollpane=new JScrollPane(jTextArea);//滚动框，将文本框添加进去
        Font f1 = new Font("楷体",Font.PLAIN,24);//设置字体
        //jTextArea.setFont(f1);
        setBtn(huiQi);
        setBtn(save);
        setBtn(impt);
        setBtn(getFail);
        huiQi.setBounds(0,100,100,50);
        save.setBounds(0,160,100,50);
        impt.setBounds(0,220,100,50);
        getFail.setBounds(0,280,100,50);
        //scrollpane.setBounds(0, 100, 100, 800);
        huiQi.addActionListener(this);
        huiQi.setActionCommand("huiQi");
        save.addActionListener(this);
        save.setActionCommand("save");
        impt.addActionListener(this);
        impt.setActionCommand("impt");
        getFail.addActionListener(this);
        getFail.setActionCommand("getFail");
        this.add(huiQi);
        this.add(save);
        this.add(impt);
        this.add(getFail);
        this.add(j1);
        this.add(j2);
        this.add(j3);
        this.add(j4);
        this.add(redDiLei);
        this.add(blueDiLei);
        //this.add(scrollpane);
        this.add(nextPlayer);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand){
            case "huiQi":
                System.out.println("悔棋被点击");break;
            case "save":
                System.out.println("保存被点击");break;
            case "impt":
                System.out.println("导入被点击");break;
            case "getFail":
                System.out.println("认输被点击");break;
        }

    }
}
