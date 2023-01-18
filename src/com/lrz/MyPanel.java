package com.lrz;

import com.lrz.ChessSon.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;


/**
 * @version 1.0
 * @auther lrz
 * @time 2023/1/3 17:12
 */
public class MyPanel extends JPanel {
    public ArrayList<Chess> chessList = new ArrayList<Chess>();
    ArrayList<Point> plist = new ArrayList<>();
    Chess selectedChess = null;
    Point p;
    Chess c1;
    Player player1 = new Player();//玩家一
    Player player2 = new Player();//玩家二
    Player culPlayer = new Player();//当前玩家
    int BlueDiLei = 3;
    int RedDiLei = 3;
    boolean RedDiLeiIsOver = false;
    boolean BlueDiLeiIsOver = false;
    boolean isInited = false;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //画背景
        String bgPath = "lib\\bg.jpg";
        Image bgimg = Toolkit.getDefaultToolkit().getImage(bgPath);
        g.drawImage(bgimg, 0, 0 ,this);
        if(!isInited){
            InitdrawChess(g);
        }else{
            drawChess(g);
        }
        isInited = true;
        if(selectedChess != null){
            selectedChess.drawMargin(g);
        }

    }
    public MyPanel(){
        createChess();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(player1.isDefine() && player2.isDefine()){
                    GuiZe(e);
                }else{
                    setPlayerColor(e);
                }
            }
        });
    }

    /**
     * 创建棋子
     */
    private void createChess(){
        {chessList.add(new Siling("司令", "红"));
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
            chessList.add(new JunZhang("军旗", "红"));
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
            chessList.add(new JunQi("军旗", "蓝"));}
            Collections.shuffle(chessList);
        //设置所有棋子不可见
        for(Chess c : chessList){
                c.setShow(false);
            }
    }
    /**
     * 画棋子
     * @param g
     */
    private void InitdrawChess(Graphics g){
        int pi = 0;
        {plist.add(new Point(1,1));
            plist.add(new Point(2,1));
            plist.add(new Point(3,1));
            plist.add(new Point(4,1));
            plist.add(new Point(5,1));

            plist.add(new Point(1,2));
            plist.add(new Point(2,2));
            plist.add(new Point(3,2));
            plist.add(new Point(4,2));
            plist.add(new Point(5,2));

            plist.add(new Point(1,3));
            plist.add(new Point(3,3));
            plist.add(new Point(5,3));

            plist.add(new Point(1,4));
            plist.add(new Point(2,4));
            plist.add(new Point(4,4));
            plist.add(new Point(5,4));

            plist.add(new Point(1,5));
            plist.add(new Point(3,5));
            plist.add(new Point(5,5));

            plist.add(new Point(1,6));
            plist.add(new Point(2,6));
            plist.add(new Point(3,6));
            plist.add(new Point(4,6));
            plist.add(new Point(5,6));
            plist.add(new Point(1,9));
            plist.add(new Point(2,9));
            plist.add(new Point(3,9));
            plist.add(new Point(4,9));
            plist.add(new Point(5,9));

            plist.add(new Point(1,10));
            plist.add(new Point(3,10));
            plist.add(new Point(5,10));

            plist.add(new Point(1,11));
            plist.add(new Point(2,11));
            plist.add(new Point(4,11));
            plist.add(new Point(5,11));

            plist.add(new Point(1,12));
            plist.add(new Point(3,12));
            plist.add(new Point(5,12));

            plist.add(new Point(1,13));
            plist.add(new Point(2,13));
            plist.add(new Point(3,13));
            plist.add(new Point(4,13));
            plist.add(new Point(5,13));

            plist.add(new Point(1,14));
            plist.add(new Point(2,14));
            plist.add(new Point(3,14));
            plist.add(new Point(4,14));
            plist.add(new Point(5,14));}
        for (Chess chess : chessList) {
            chess.setP(plist.get(pi++));
            //画出未知样子
            chess.drawUnknown(g, this);
        }
    }

    /**
     * 画所有棋子，分可见和不可见
     * @param g
     */
    private void drawChess(Graphics g){
        for (Chess chess : chessList) {
            if(chess.isShow()){
                chess.draw(g, this);
            }else{
                chess.drawUnknown(g, this);
            }
        }
    }

    /**
     * 游戏规则
     * @param e
     */
    private void GuiZe(MouseEvent e){
        p = Chess.getPointFromXY(e.getX(), e.getY());
        System.out.println("(" + p.getX() + "," + p.getY() + ")");
        //打印点击的棋子信息
        try{
            System.out.println("点击的棋子是" + Chess.getChessByPoint(p, chessList).getColor() + Chess.getChessByPoint(p, chessList).getName());
        }catch (NullPointerException nullPointerException){
            System.out.println("点击位置空白");
        }
        //吃子、重选、走路
        // 第一次选择
        if(selectedChess == null){
            selectedChess = Chess.getChessByPoint(p, chessList);
            if(selectedChess == null){
                System.out.println("请不要点击空白\n");
            }
            //当前棋子已经翻开并且当前玩家阵营与当前选择棋子是同一个阵营
            else if(selectedChess.isShow() && selectedChess.getColor().equals(culPlayer.getColor())){
                System.out.println( culPlayer.getColor() + "方第一次选择棋子");
            }else if(!selectedChess.isShow()){//未翻开
                System.out.println(culPlayer.getColor() + "方翻开了" + selectedChess.getColor() + selectedChess.getName());
                selectedChess.setShow(true);
                //翻开过后换玩家
                culPlayer = changePlayer(culPlayer);
                System.out.println("该" + culPlayer.getColor() +  "玩家走了" );
            }else if(selectedChess.isShow() && !selectedChess.getColor().equals(culPlayer.getColor())){
                System.out.println("请重新选择自己方的棋子！\n" );
                selectedChess = null;
            }
        }
        //第n次点击棋盘
        else{
            c1 = Chess.getChessByPoint(p, chessList);
            if(c1 != null && !c1.isShow()){
                selectedChess.setShow(true);
                //翻开过后换玩家
                culPlayer = changePlayer(culPlayer);
                System.out.println("该" + culPlayer.getColor() +  "玩家走了" );
                System.out.println(culPlayer.getColor() + "方翻开了" + selectedChess.getColor() + selectedChess.getName());
            }
            if(selectedChess.isAbleMove(selectedChess.getP(), p) && selectedChess.hasNoOtherChess(selectedChess.getP(), p, MyPanel.this)){
                System.out.println("起始位置(" + selectedChess.getP().getX() + "," + selectedChess.getP().getY() + ")到(" +
                        p.getX() + "," + p.getY() + ")");
            }else if(c1 != selectedChess){
                System.out.println("起始位置(" + selectedChess.getP().getX() + "," + selectedChess.getP().getY() + ")到(" +
                        p.getX() + "," + p.getY() + ")");
                System.out.print("不可以移动");
                if(selectedChess.isAbleMove(selectedChess.getP(), p)){
                    System.out.print("，原因是路线中有棋子遮挡\n");
                }
            }
            //如果点击的位置是空  并且   可以移动  并且  移动的路上没有其他棋子遮挡
            if(c1 == null && selectedChess.isAbleMove(selectedChess.getP(), p)
                    && selectedChess.hasNoOtherChess(selectedChess.getP(), p, MyPanel.this)){
                selectedChess.setP(p);
                System.out.println(culPlayer.getColor() + "方移动了" + selectedChess.getColor() + selectedChess.getName());
                //移动过后换玩家
                culPlayer = changePlayer(culPlayer);
                System.out.println("该" + culPlayer.getColor() +  "玩家走了\n" );
            }
            else try{
                //两次选择同一种阵营，即重新选择
                if(selectedChess.getColor().equals(c1.getColor()) && c1.isShow()) {
                    selectedChess = c1;
                    System.out.println("切换一个棋子\n");
                }
                //两次选择不同阵营，则吃子，下面是吃子的一系列判断
                else if(!selectedChess.getColor().equals(c1.getColor())) {
                    if(!c1.isShow()){//如果c1还未翻开
                        System.out.println("不能吃未翻开的棋子！请重新选择！");
                    }else{
                        //吃子需要删除被吃棋子、并将吃的棋子移动到被吃位置，被吃棋子如何找
                        Chess eated = c1;
                        //红方地雷挖完
                        if(RedDiLeiIsOver && eated.getLevel() == -1 && isMinLevel(selectedChess)){
                            System.out.println("游戏结束，蓝方胜利");
                        }
                        if(BlueDiLeiIsOver && eated.getLevel() == -1 && isMinLevel(selectedChess)){
                            System.out.println("游戏结束，红方胜利");
                        }
                        //如果是工兵，则被吃的只能是地雷
                        if(selectedChess.getLevel() == 1 && eated.getLevel() == 0 ){
                            boolean remove = chessList.remove(eated);
                            //移除失败打印
                            if(!remove){
                                System.out.println("吃子失败");
                            }else{
                                System.out.println("吃子成功");
                                //如果吃的棋子是红色地雷，则红地雷数量减一
                                if(eated.getColor().equals("红")){
                                    RedDiLei--;
                                    if(RedDiLei == 0){
                                        RedDiLeiIsOver = true;
                                        System.out.println("红色地雷全部挖完，当前最小者可以开始扛蓝方军旗");
                                    }
                                }else if(eated.getColor().equals("蓝")){
                                    BlueDiLei--;
                                    if(BlueDiLei == 0){
                                        BlueDiLeiIsOver = true;
                                        System.out.println("蓝色地雷全部挖完，当前最小者可以开始扛红方军旗");
                                    }
                                }
                                selectedChess.setP(p);
                            }
                            culPlayer = changePlayer(culPlayer);
                            System.out.println("该" + culPlayer.getColor() +  "玩家走了\n" );
                        }
                        //如果是炸弹，则同归于尽，军旗除外  ||  如果被吃棋子是炸弹，则两边都死
                        else if((selectedChess.getLevel() == 10 && eated.getLevel() != -1 )
                                || (eated.getLevel() == 10 && !Chess.isAtXingYing(eated)) ){
                            System.out.println("是否在行营中" + Chess.isAtXingYing(eated));
                            boolean remove1 = chessList.remove(eated);
                            boolean remove2 = chessList.remove(selectedChess);
                            //移除失败打印
                            if(!remove1 || !remove2){
                                System.out.println("炸失败");
                            }else{
                                System.out.println("炸成功");
                            }
                            culPlayer = changePlayer(culPlayer);
                            System.out.println("该" + culPlayer.getColor() +  "玩家走了\n" );
                        }
                        //如果两个棋子等级一样，同归于尽
                        else if(selectedChess.getLevel() == eated.getLevel() && !Chess.isAtXingYing(eated)){
                            System.out.println("同归于尽");
                            boolean remove1 = chessList.remove(selectedChess);
                            boolean remove2 = chessList.remove(eated);
                            if(remove1 && remove2){
                                System.out.println("同归于尽成功");
                            }else{
                                System.out.println("同归于尽失败");
                            }
                            culPlayer = changePlayer(culPlayer);
                            System.out.println("该" + culPlayer.getColor() +  "玩家走了\n" );
                        }
                        else if(Chess.isAtXingYing(eated)){
                            System.out.println("被吃棋子在行营中，不可吃");
                        }
                        //如果等级比被吃大且被吃棋子不在行营中
                        else if((selectedChess.getLevel() > eated.getLevel()) && !Chess.isAtXingYing(eated)){
                            boolean remove = chessList.remove(eated);
                            //移除失败打印
                            if(!remove){
                                System.out.println("吃子失败");
                            }else{
                                System.out.println("吃子成功");
                                selectedChess.setP(p);
                            }
                            culPlayer = changePlayer(culPlayer);
                            System.out.println("该" + culPlayer.getColor() +  "玩家走了" );
                            System.out.println(" ");
                        }
                    }
                }
            }catch (NullPointerException nullPointerException){ }

        }
        repaint();
    }

    /**
     * 改变当前玩家
     * @param culPlayer
     * @return
     */
    private Player changePlayer(Player culPlayer){
        selectedChess = null;
        return culPlayer == player1 ? player2 : player1;
    }

    Chess culChess = null;

    /**
     * 分配阵营
     * @param e
     */
    private void setPlayerColor(MouseEvent e){
        p = Chess.getPointFromXY(e.getX(), e.getY());
        System.out.println("(" + p.getX() + "," + p.getY() + ")");
        Chess chessByPoint = Chess.getChessByPoint(p, chessList);
//打印点击的棋子信息
        if(chessByPoint == null){
            System.out.println("请不要点击空白处！\n");
        }else {
            //第一次点 且只能点未翻开的
            if (culChess == null && !chessByPoint.isShow()) {
                System.out.println("点击的棋子是" + chessByPoint.getColor() + chessByPoint.getName());
                culChess = chessByPoint;
                culChess.setShow(true);
                culPlayer = player1;
                culPlayer.setColor(culChess.getColor());
                System.out.println("下面是player2回合\n");
                //设置为玩家2
                culPlayer = changePlayer(culPlayer);
                repaint();
            }
            //第n次点
            else {
                //如果第n次和上一次点的颜色不同
                if (!culChess.getColor().equals(chessByPoint.getColor())) {
                    System.out.println("点击的棋子是" + chessByPoint.getColor() + chessByPoint.getName());
                    culPlayer.setColor(chessByPoint.getColor());
                    chessByPoint.setShow(true);
                    System.out.println("分配成功，下面是player1回合");
                    System.out.println("player1为" + player1.getColor() + "方");
                    System.out.println("player2为" + player2.getColor() + "方\n");
                    culPlayer = changePlayer(culPlayer);
                    player1.setDefine(true);
                    player2.setDefine(true);
                    repaint();
                    return;
                }//两次颜色相同
                else {
                    System.out.println("还未分配成功，下面是player1回合\n");
                    culPlayer = changePlayer(culPlayer);
                    chessByPoint.setShow(true);
                    culChess = null;
                    repaint();
                }
            }
        }
    }

    /**
     * 判断是否是当前最小棋子
     * @param c
     * @return
     */
    public boolean isMinLevel(Chess c){
        int cLevel = c.getLevel();
        String cColor = c.getColor();
        for (Chess chess: chessList) {
            if(chess.getColor().equals(cColor)){
                //只要有一个比当前级别小，就返回false，即不是最小棋子，地雷军旗除外
                if(chess.getLevel() < cLevel && chess.getLevel() > 0){
                    return false;
                }
            }
        }
        return true;
    }

}
