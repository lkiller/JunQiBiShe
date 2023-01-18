package test;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @auther lrz
 * @time 2022/12/28 14:50
 */
public class jframetest extends JFrame {
    public jframetest(){
        initUI();
    }

    private void initUI() {
        setTitle("窗口测试");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        //EventQueue.invokeLater(() -> {
            jframetest ex = new jframetest();
            ex.setVisible(true);
          //      }
        //);
    }
}
