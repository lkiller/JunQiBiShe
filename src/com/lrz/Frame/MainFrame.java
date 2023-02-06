package com.lrz.Frame;

import com.lrz.HintPanel;
import com.lrz.MyPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @auther lrz
 * @time 2023/1/3 17:05
 */
public class MainFrame extends JFrame {
    public MyPanel myPanel = null;
    int width = 1000,height = 1100;
    public HintPanel hintPanel = null;
    public MainFrame(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        width = (int) screenSize.getWidth()/2;
        height = (int) screenSize.getHeight();
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
    }
    public static void setBtn(JButton btn){
        Font f = new Font("隶书",Font.PLAIN,30);
        btn.setFont(f);
    }
    /*public static void createFrame(){
        MainFrame mainFrame = new MainFrame("军旗");
        //设置布局管理器
        mainFrame.setLayout(new BorderLayout(100, 0));


        //添加右边工具栏
        GridBagLayout gridBagLayout = new GridBagLayout();

        JPanel btnPanel = new JPanel(new GridBagLayout());
        JLabel text = new JLabel("该红方走了");
        btnPanel.add(text);
        JButton huiQi = new JButton("悔棋");
        JButton save = new JButton("保存..........");
        JButton impt = new JButton("导入");
        JButton getFail = new JButton("认输");
        //设置按钮样式
        setBtn(huiQi);
        setBtn(save);
        setBtn(impt);
        setBtn(getFail);

        btnPanel.add(huiQi);
        btnPanel.add(save);
        btnPanel.add(impt);
        btnPanel.add(getFail);
        mainFrame.add(new MyPanel(), BorderLayout.CENTER);
        mainFrame.add(btnPanel, BorderLayout.EAST);

        mainFrame.setVisible(true);
    }
    public void createFrame2(){
        this.setLayout(new BorderLayout(100, 0));
        //添加右边工具栏
        GridBagLayout gridBagLayout = new GridBagLayout();
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(gridBagLayout);
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;//设置为一行末尾
        c.fill = GridBagConstraints.BOTH;//设置可以拉伸
        JButton huiQi = new JButton("悔棋");
        JButton save = new JButton("保存");
        JLabel jLabel = new JLabel("该红方走了");
        setBtn(huiQi);
        setBtn(save);
        addComponent(btnPanel, jLabel, gridBagLayout, c);
        addComponent(btnPanel, huiQi, gridBagLayout, c);
        c.fill = GridBagConstraints.BOTH;//设置可以拉伸
        addComponent(btnPanel, save, gridBagLayout, c);
        c.fill = GridBagConstraints.BOTH;//设置可以拉伸

        this.add(new MyPanel(), BorderLayout.CENTER);
        this.add(btnPanel, BorderLayout.EAST);
        this.setVisible(true);
    }
    public void addComponent(JPanel jPanel, Component component, GridBagLayout g, GridBagConstraints c){
        g.setConstraints(component, c);//设置按钮和约束关联
        jPanel.add(component);
    }


    public void createFrame3(){
        //this.setLayout(null);
        JButton huiQi = new JButton("悔棋");
        JButton save = new JButton("保存");
        JButton impt = new JButton("导入");
        JButton getFail = new JButton("认输");
        JPanel nextPlayer = new JPanel();
        nextPlayer.setBounds(780, 50, 100, 30);
        nextPlayer.add(new JLabel("下一位玩家"));
        JLabel color = new JLabel();
        color.setBounds(1,1,30,30);
        color.setOpaque(false);
        color.setBackground(Color.BLUE);
        nextPlayer.add(color);

        JTextArea jTextArea = new JTextArea("该红方走了fefefefefefefefefefe", 6, 10);
        jTextArea.setLineWrap(true);//设置当文本字长度超过frame的宽度时自动换行
        jTextArea.setWrapStyleWord(true);
        JScrollPane scrollpane=new JScrollPane(jTextArea);//滚动框，将文本框添加进去
        Font f1 = new Font("楷体",Font.PLAIN,24);//设置字体
        jTextArea.setFont(f1);
        setBtn(huiQi);
        setBtn(save);
        setBtn(impt);
        setBtn(getFail);
        huiQi.setBounds(800,500,100,50);
        save.setBounds(800,570,100,50);
        impt.setBounds(800,640,100,50);
        getFail.setBounds(800,710,100,50);
        scrollpane.setBounds(800, 100, 100, 400);
        this.add(huiQi);
        this.add(save);
        this.add(impt);
        this.add(getFail);
        this.add(scrollpane);
        this.add(nextPlayer);
        this.add(new MyPanel());
        this.setVisible(true);
    }*/
    public static void main(String[] args){
        MainFrame mainFrame = new MainFrame("军棋");
        mainFrame.setLayout(null);
        MyPanel myPanel = new MyPanel(mainFrame);
        mainFrame.myPanel = myPanel;
        HintPanel hintPanel = new HintPanel(mainFrame);
        mainFrame.hintPanel = hintPanel;
        mainFrame.add(myPanel);
        myPanel.setBounds(0,0,800,1000);
        mainFrame.add(hintPanel);
        hintPanel.setBounds(800, 5, 150, 800);
        //mainFrame.createFrame3();
        mainFrame.setVisible(true);

    }

}
