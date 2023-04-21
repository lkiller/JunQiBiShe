/**
 * \* Created with IntelliJ IDEA.
 * \* Author: 土豆
 * \* Date: 2023/2/12
 * \* Time: 14:54
 * \* Description:
 * \
 */
package com.lrz.panel;

import com.lrz.pojo.Chess;
import com.lrz.ChessSon.*;
import com.lrz.Frame.GameFrame;
import com.lrz.pojo.SaveNum;
import com.lrz.pojo.saveChessList;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * 该类用于导入棋谱时在importFrame中的Panel
 */
public class ChoosePanel extends JPanel {
    GameFrame gameFrame;
    SqlSession sqlSession;
    public ChoosePanel(GameFrame gameFrame, SqlSession sqlSession) {
        this.gameFrame = gameFrame;
        this.sqlSession = sqlSession;
        this.start();
    }
    public void start(){
        JComboBox<String> stringJComboBox = new JComboBox<>();
        List<SaveNum> saveNumList = sqlSession.selectList("selectAllFromTSaveNum");
        for (SaveNum saveNum : saveNumList) {
            String info = saveNum.getId() + "." + saveNum.getName() + "  " + saveNum.getTimestamp();
            stringJComboBox.addItem(info);
        }
        this.add(stringJComboBox);
        stringJComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedItem = stringJComboBox.getSelectedItem();
                String s = (String)selectedItem;
                int num = Integer.valueOf(s.substring(0, s.indexOf(".")));
                getTableName(num, gameFrame);
            }
        });
    }

    public void getTableName(int num, GameFrame gameFrame){
        //得到数据库名称
        SaveNum table = sqlSession.selectOne("selectOneFromTSaveNumById",num);
        String name = "t_chessboard_" + table.getName();
        String culColor = table.getCulPlayer();
        List<saveChessList> chessList = sqlSession.selectList("selectAllFromT", name);
        System.out.println(chessList);
        ArrayList<Chess> myPanelChessList = gameFrame.myPanel.chessList;
        myPanelChessList.clear();
        for (saveChessList chessL : chessList) {
            myPanelChessList.add(this.getChess(chessL.getChessName(), chessL.getChessColor(),
                    new Point(chessL.getChessPointX(), chessL.getChessPointY()), chessL.isChessShow()));
            /*myPanelChessList.add(new Chess(chessL.getChessName(), chessL.getChessColor(),
                    new Point(chessL.getChessPointX(), chessL.getChessPointY()), chessL.isChessShow()));*/
        }
        gameFrame.myPanel.culPlayer.setColor(culColor);
        //gameFrame.hintPanel.colorLabel.setText("该" + culColor + "玩家走了");
        if(table.getPlayer() == 1){
            if("红".equals(culColor)){
                gameFrame.myPanel.player1.setColor(culColor);
                gameFrame.myPanel.player2.setColor("蓝");
            }else{
                gameFrame.myPanel.player1.setColor("红");
                gameFrame.myPanel.player2.setColor(culColor);
            }
        }else{//当前玩家为player2
            if("红".equals(culColor)){
                gameFrame.myPanel.player1.setColor("蓝");
                gameFrame.myPanel.player2.setColor(culColor);
            }else{
                gameFrame.myPanel.player1.setColor(culColor);
                gameFrame.myPanel.player2.setColor("红");
            }
        }
        gameFrame.myPanel.player1.setDefine(true);
        gameFrame.myPanel.player2.setDefine(true);
        gameFrame.myPanel.repaint();
    }

    public Chess getChess(String name, String color, Point p, Boolean show){
        switch (name){
            case "司令":
                return new Siling(name, color, p, show);
            case "军长":
                return new JunZhang(name, color, p, show);
            case "师长":
                return new ShiZhang(name, color, p, show);
            case "旅长":
                return new LvZhang(name, color, p, show);
            case "团长":
                return new TuanZhang(name, color, p, show);
            case "营长":
                return new YingZhang(name, color, p, show);
            case "连长":
                return new LianZhang(name, color, p, show);
            case "排长":
                return new PaiZhang(name, color, p, show);
            case "工兵":
                return new GongBing(name, color, p, show);
            case "地雷":
                return new DiLei(name, color, p, show);
            case "炸弹":
                return new ZhaDan(name, color, p, show);
            case "军旗":
                return new JunQi(name, color, p, show);
        }
        return null;
    }
}
