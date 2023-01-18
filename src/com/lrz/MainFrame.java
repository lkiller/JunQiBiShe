package com.lrz;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @auther lrz
 * @time 2023/1/3 17:05
 */
public class MainFrame extends JFrame {
    public MainFrame(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,1100);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame("军旗");
        mainFrame.setContentPane(new MyPanel());
        mainFrame.setVisible(true);
    }
}
