/**
 * \* Created with IntelliJ IDEA.
 * \* Author: 土豆
 * \* Date: 2023/4/3
 * \* Time: 16:06
 * \* Description:选择与某个客户端进行游戏的界面
 * \
 */
package com.lrz.Frame;

import com.lrz.pojo.Chess;
import com.lrz.ChessServer.ClientThread;
import com.lrz.ChessSon.*;
import com.lrz.pojo.Message;
import com.lrz.utils.SocketUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

public class SelectFrame extends JFrame {
    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }
    GameFrame gameFrame1 = null;GameFrame gameFrame2 = null;

    private boolean isSend = false;//是否是发送方
    private ArrayList<Chess> chessList = new ArrayList<>();
    private Socket socket;
    private String account;//当前登陆的用户名
    private JList jlist;
    private final DefaultListModel model;
    String toSend;
    private Vector<String> data;//所有登陆的用户数据
    private GameFrame gameFrame;
    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public SelectFrame(Socket socket, String account) {
        this.socket = socket;
        this.account = account;

        //设置名称
        setTitle("当前登陆用户为：" + this.getAccount());
        //设置大小
        setSize(400, 400);
        //String[] item = {"客户端A", "客户端B", "客户端C"};

        model = new DefaultListModel();
        /*for (int i = 0; i < item.length; i++) {
            model.addElement(item[i]);
        }*/
        jlist = new JList(model);
        jlist.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2){
                    System.out.println("双击" + jlist.getSelectedIndex());
                    String to = data.elementAt(jlist.getSelectedIndex());
                    toSend = to;
                    isSend = true;//表示是发送方
                    Message req = new Message();
                    req.setType(Message.Type.CHALLENGE);
                    req.setFrom(account);
                    req.setTo(to);
                    SocketUtil.send(socket, req);
                }
            }
        });
        JScrollPane jScrollPane = new JScrollPane(jlist);
        add(jScrollPane, BorderLayout.CENTER);
        //设置叉叉按钮
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置绝对布局
        //设置居中
        setLocationRelativeTo(null);
        //this.setLayout(null);
        //设置可见性
        setVisible(true);
        getClientList();
    }
    ClientThread ct;
    /**
     * 得到所有登陆的用户
     */
    private void getClientList(){
        Message req = new Message();
        req.setType(Message.Type.LIST);
        req.setFrom(account);
        SocketUtil.send(socket, req);//发送请求过去
        ct = new ClientThread(socket, new ClientThread.ResponseListener() {
            @Override
            public void success(Message resp) {//message为传回的信息
                System.out.println("执行success");
                if(resp.getType() == Message.Type.SUCCESS){
                    model.clear();
                    data = (Vector<String>)resp.getContent();
                    data.forEach(item ->{
                        model.addElement(item);
                    });
                    jlist.validate();
                }else if(resp.getType() == Message.Type.CHALLENGE_SUCCESS){
                    SelectFrame.this.dispose();//隐藏窗口
                    ct.setShutDown(true);
                    //到这里已经是发送挑战成功了，所以不需要再接收信息了
                    if(account.equals(resp.getFrom())){
                        gameFrame1 = new GameFrame(socket, "军棋 当前账户为"+ account + "当前对手为" + resp.getTo(),account, resp.getTo());
                        gameFrame1.myPanel.First_Send(resp.getTo());
                        gameFrame1.myPanel.setLocked(false);//发起者先走，被挑战者不能走
                    }else{
                        //最后一个参数是设置对手，设置成  服务器发过来的请求中的From的那个
                        gameFrame2 = new GameFrame(socket, "军棋 当前账户为" + account + "当前对手为" + resp.getFrom(), account ,resp.getFrom());//
                        gameFrame2.myPanel.setLocked(true);
                    }
                }/*else if(resp.getType() == Message.Type.REFRESH_OK){
                    //Second_Receive(resp);
                }*/
            }
        });
        ct.start();
    }

    private void Second_Receive(Message resp) {
        System.out.println(" ++++ "+ resp);
        if(resp instanceof Message){
            Object content = resp.getContent();
            ArrayList<Chess> chessArrayList = (ArrayList<Chess>)content;
            gameFrame2.myPanel.reFresh(chessArrayList);
        }
    }

    /**
     * 第一个发起请求的用户，向服务器发送其棋谱
     * 参数是告诉服务器像谁发出去
     */
    private void First_Send(String to) {
        ArrayList<Chess> chessList1 = gameFrame1.myPanel.getChessList();
        Message major_message = new Message();
        major_message.setContent(chessList1);
        major_message.setType(Message.Type.REFRESH);
        major_message.setTo(to);
        SocketUtil.send(socket, major_message);
    }

    public static void main(String[] args) {

    }
    private ArrayList<Chess> createChess(){
        {
            chessList.add(new Siling("司令", "红"));
            chessList.add(new JunZhang("军长", "红"));
            chessList.add(new ShiZhang("师长", "红"));
            chessList.add(new ShiZhang("师长", "红"));
            chessList.add(new LvZhang("旅长", "红"));
            chessList.add(new LvZhang("旅长", "红"));
            chessList.add(new TuanZhang("团长", "红"));
            chessList.add(new TuanZhang("团长", "红"));
            chessList.add(new YingZhang("营长", "红"));
            chessList.add(new YingZhang("营长", "红"));
            chessList.add(new LianZhang("连长", "红"));
            chessList.add(new LianZhang("连长", "红"));
            chessList.add(new LianZhang("连长", "红"));
            chessList.add(new PaiZhang("排长", "红"));
            chessList.add(new PaiZhang("排长", "红"));
            chessList.add(new PaiZhang("排长", "红"));
            chessList.add(new GongBing("工兵", "红"));
            chessList.add(new GongBing("工兵", "红"));
            chessList.add(new GongBing("工兵", "红"));
            chessList.add(new DiLei("地雷", "红"));
            chessList.add(new DiLei("地雷", "红"));
            chessList.add(new DiLei("地雷", "红"));
            chessList.add(new ZhaDan("炸弹", "红"));
            chessList.add(new ZhaDan("炸弹", "红"));
            chessList.add(new JunQi("军旗", "红"));
            chessList.add(new Siling("司令", "蓝"));
            chessList.add(new JunZhang("军长", "蓝"));
            chessList.add(new ShiZhang("师长", "蓝"));
            chessList.add(new ShiZhang("师长", "蓝"));
            chessList.add(new LvZhang("旅长", "蓝"));
            chessList.add(new LvZhang("旅长", "蓝"));
            chessList.add(new TuanZhang("团长", "蓝"));
            chessList.add(new TuanZhang("团长", "蓝"));
            chessList.add(new YingZhang("营长", "蓝"));
            chessList.add(new YingZhang("营长", "蓝"));
            chessList.add(new LianZhang("连长", "蓝"));
            chessList.add(new LianZhang("连长", "蓝"));
            chessList.add(new LianZhang("连长", "蓝"));
            chessList.add(new PaiZhang("排长", "蓝"));
            chessList.add(new PaiZhang("排长", "蓝"));
            chessList.add(new PaiZhang("排长", "蓝"));
            chessList.add(new GongBing("工兵", "蓝"));
            chessList.add(new GongBing("工兵", "蓝"));
            chessList.add(new GongBing("工兵", "蓝"));
            chessList.add(new DiLei("地雷", "蓝"));
            chessList.add(new DiLei("地雷", "蓝"));
            chessList.add(new DiLei("地雷", "蓝"));
            chessList.add(new ZhaDan("炸弹", "蓝"));
            chessList.add(new ZhaDan("炸弹", "蓝"));
            chessList.add(new JunQi("军旗", "蓝"));
        }
        return chessList;
    }
}
