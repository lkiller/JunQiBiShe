/**
 * \* Created with IntelliJ IDEA.
 * \* Author: 土豆
 * \* Date: 2023/2/12
 * \* Time: 11:36
 * \* Description:
 * \
 */
package com.lrz.Frame;


import javax.swing.*;
import java.awt.*;
import com.lrz.panel.ChoosePanel;
import com.lrz.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

public class importFrame extends JFrame {
    SqlSession sqlSession = SqlSessionUtils.openSession();
    public importFrame(String title, GameFrame gameFrame) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(2);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = (int) screenSize.getWidth() / 4;
        int height = (int) screenSize.getHeight() / 2;
        ChoosePanel choosePanel = new ChoosePanel(gameFrame, sqlSession);
        this.setContentPane(choosePanel);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
