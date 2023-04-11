/**
 * \* Created with IntelliJ IDEA.
 * \* Author: 土豆
 * \* Date: 2023/2/4
 * \* Time: 23:03
 * \* Description:
 * \
 */
package com.lrz.panel;

import com.lrz.Chess;
import com.lrz.Frame.importFrame;
import com.lrz.Frame.GameFrame;
import com.lrz.pojo.saveChessList;
import com.lrz.utils.SqlSessionUtils;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.lrz.pojo.SaveNum;

public class HintPanel extends JPanel implements ActionListener {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public JTextArea jTextArea = null;
    public GameFrame gameFrame = null;
    JLabel colorLabel = new JLabel("翻棋以确定阵营");
    public JLabel j1 = null;
    public JLabel j2 = null;
    public JLabel j3 = null;
    public JLabel j4 = null;
    public JLabel redDiLei = null;
    public JLabel blueDiLei = null;
    String culPlayerColor = null;
    public int player;
    public importFrame imp;

    /*
    * 设置按钮样式*/
    public static void setBtn(JButton btn){
        Font f = new Font("隶书",Font.PLAIN,30);
        btn.setFont(f);
        btn.setSize(1200,200);
    }

    public HintPanel(GameFrame gameFrame){
        j1 = new JLabel();
        j2 = new JLabel();
        j3 = new JLabel();
        j4 = new JLabel();
        redDiLei = new JLabel();
        blueDiLei = new JLabel();
        this.setLayout(null);
        this.gameFrame = gameFrame;
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
        this.add(nextPlayer);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand){
            case "huiQi":
                int tips = JOptionPane.showConfirmDialog(null, "落子无悔，您确认悔棋吗","提示",  JOptionPane.YES_NO_OPTION);
                if(tips == 0){
                    gameFrame.myPanel.huiQi();
                    System.out.println("悔棋被点击");
                }
                break;
            case "save":
                System.out.println("保存被点击");
                String chessBoardName = JOptionPane.showInputDialog("请输入该棋局名称",JOptionPane.YES_NO_OPTION);
                if(chessBoardName != null){
                    System.out.println("保存了名字为" + chessBoardName);
                    saveChessBoard(chessBoardName);
                    String sqlName = "t_chessBoard_" + chessBoardName;
                }
                break;
            case "impt":
                System.out.println("导入被点击");
                imp = new importFrame("请选择棋谱", gameFrame);
                break;
            case "getFail":
                System.out.println("认输被点击");
                culPlayerColor = gameFrame.myPanel.culPlayer.getColor();
                if("红".equals(culPlayerColor)){
                    JOptionPane.showMessageDialog(null,"游戏结束，蓝方胜利");
                }else {
                    JOptionPane.showMessageDialog(null,"游戏结束，红方胜利");
                }
                break;
        }

    }

    private void saveChessBoard(String chessBoardName) {
        int chessId = 1;
        SaveNum saveNum = null;
        String sqlName = "t_chessBoard_" + chessBoardName;
        SqlSession sqlSession = SqlSessionUtils.openSession();
        saveNum = sqlSession.selectOne("selectLastFromTSaveNum", (ResultHandler) saveNum);
        if(saveNum!= null){
            SaveNum selectLastFromTSaveNum = sqlSession.selectOne("selectLastFromTSaveNum", saveNum);
            int maxNum = selectLastFromTSaveNum.getId();
            System.out.println("当前获取的最大id值为" + maxNum);
            maxNum++;
            int id = maxNum;
            culPlayerColor = gameFrame.myPanel.culPlayer.getColor();
            if(culPlayerColor.equals(gameFrame.myPanel.player1.getColor())){
                player = 1;
            }else{
                player = 2;
            }
            SaveNum newObj = new SaveNum(maxNum, chessBoardName, sdf.format(System.currentTimeMillis()), culPlayerColor, player);
            int num = sqlSession.insert("insertToTSaveNum", newObj);
            int createTable = sqlSession.update("createTable", sqlName);
            if(createTable != 0){
                JOptionPane.showMessageDialog(null, "表名已经存在，请重新取名");
            }else{
                ArrayList<Chess> chessList = gameFrame.myPanel.chessList;
                chessList.forEach(chess -> sqlSession.insert("insertChessList",
                        new saveChessList(sqlName, id, chess.getName(), chess.getColor(), chess.getP().x,chess.getP().y, chess.isShow())));
            }
            sqlSession.commit();
        }else{
            System.out.println("数据库中saveNum表为空");
            culPlayerColor = gameFrame.myPanel.culPlayer.getColor();
            if(culPlayerColor.equals(gameFrame.myPanel.player1.getColor())){
                player = 1;
            }else{
                player = 2;
            }
            saveNum = new SaveNum(1, chessBoardName, sdf.format(System.currentTimeMillis()), culPlayerColor, player);
            int num = sqlSession.insert("insertToTSaveNum", saveNum);
            System.out.println(this.getClass().getName() +"143行插入了" + num + "条数据" );
            int createTable = sqlSession.update("createTable", sqlName);
            if(createTable != 0){
                JOptionPane.showMessageDialog(null, "表名已经存在，请重新取名");
            }else{
                ArrayList<Chess> chessList = gameFrame.myPanel.chessList;
                chessList.forEach(chess -> sqlSession.insert("insertChessList",
                        new saveChessList(sqlName, 1, chess.getName(), chess.getColor(), chess.getP().x,chess.getP().y, chess.isShow())));
            }
            sqlSession.commit();
        }
    }
}
