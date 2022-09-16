package com.sxt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame {

    //设置游戏状态 0\未开始 1\游戏中\2游戏失败3\通关成功4\暂停
    static  int state = 0;//默认游戏状态

    Image offScreenImge;
    //    创建启动方法,设置窗口信息
//    设置窗口大小
    private int width = 1200;
    private int height = 800;

    //
    double random;
    //计数器
    int time = 0;
    //游戏背景
    Bg bg = new Bg();//开始背景

    //敌对方的添加
    Enarry enarry;

    Enarry boos;
    boolean isboos = false;
    //我方小黑
    MyFish myFish = new MyFish();

    public void launch(){
        this.setVisible(true);
        this.setSize(width,height);   //窗口的大小
        this.setLocationRelativeTo(null);  //窗口居中
//        this.setResizable(false);  //设置大小不可改变
        this.setTitle("大黑吃小黑");  //设置窗口名称
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭窗口按钮
        //开始点击事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton()==1&&state==0){
                    state=1;
                    repaint();
                }
                if(e.getButton()==1&&(state==2||state==3)){
                    reGame();
                    state=1;
                }
            }
        });
        //键盘移动
        this.addKeyListener(new KeyAdapter() {
            @Override//按下
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == 87) {
                    GameUtils.UP = true;
                }
                if (e.getKeyCode() == 83) {
                    GameUtils.DOWN = true;
                }
                if (e.getKeyCode() == 65) {
                    GameUtils.LEFT = true;
                }
                if (e.getKeyCode() == 68) {
                    GameUtils.RIGHT = true;
                }
                if(e.getKeyCode()==32){
                    switch (state){
                        case 1:
                            state =4;
                            GameUtils.drawWord(getGraphics(),"游戏暂停",Color.red,50,600,300);
                            break;
                        case 4:
                            state =1;
                            break;
                    }

                }
            }

            @Override//抬起
            public void  keyReleased(KeyEvent e){
                super.keyPressed(e);
                if (e.getKeyCode() == 87) {
                    GameUtils.UP = false;
                }
                if (e.getKeyCode() == 83) {
                    GameUtils.DOWN = false;
                }
                if (e.getKeyCode() == 65) {
                    GameUtils.LEFT = false;
                }
                if (e.getKeyCode() == 68) {
                    GameUtils.RIGHT = false;
                }
            }
        });

        while (true){
            repaint();
            time++;
            try {
                Thread.sleep(40);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void paint(Graphics g){
        //懒加载初模式初始化对象
        offScreenImge = createImage(width,height);
        Graphics gImage = offScreenImge.getGraphics();

//        background.paintSelf(g);
//        g.drawImage(GameUtils.bgimg,0,0,null);
        switch (state){
            case 0:
                bg.paintSelf(gImage,myFish.level);
                break;
            case 1:
                bg.paintSelf(gImage,myFish.level);
                myFish.paintSelf(gImage); //绘制自身鱼
                logic();
                for (Enarry enarry:GameUtils.EnarryList) {
                    enarry.paintSelf(gImage);
                }
                if(isboos){
                    boos.x = boos.x+boos.dir*boos.speed;
                    boos.paintSelf(gImage);  //绘制boos鱼
                    if(boos.x<0){
                        gImage.setColor(Color.red);
                        gImage.fillRect(boos.x,boos.y,2400, 30);
//                        System.out.println("xdcfvgnj");
                    }
                }
                break;
            case 2:
                bg.paintSelf(gImage,myFish.level);
                myFish.paintSelf(gImage);
                for (Enarry enarry:GameUtils.EnarryList) {
                    enarry.paintSelf(gImage);
                }
                if (isboos){
                    boos.paintSelf(gImage);
                }
                break;
            case 3:
                bg.paintSelf(gImage,myFish.level);
                myFish.paintSelf(gImage);
                break;
            case 4:
                return ;
                default:
        }
        g.drawImage(offScreenImge,0,0,null);

    }

    //批量添加敌对小黑的方法
    void  logic(){
        //关卡难度
        if(GameUtils.count<5){
            GameUtils.level = 0;
            myFish.level = 1;
        }else if(GameUtils.count<=15){
            GameUtils.level = 1;
        }else if(GameUtils.count<=50){
            GameUtils.level = 2;
            myFish.level = 2;
        }else if(GameUtils.count<=100){
            GameUtils.level = 3;
            myFish.level = 3;
        }else if(GameUtils.count<=180){
            GameUtils.level = 4;
            myFish.level = 4;
        }else{
            state = 3;
        }
        random = Math.random();
        //敌方小黑生成
        switch (GameUtils.level){
            case 4:
                if (time%60==0) {
                    if (random > 0) {
                        boos = new Enarry_Boss();
                        isboos = true;
                    }
//                    GameUtils.EnarryList.add(boos);
                }
            case 3:
            case 2:
                if (time%30==0) {
                    if (random > 0.5) {
                        enarry = new Enarry_3_L();
                    } else {
                        enarry = new Enarry_3_R();
                    }
                    GameUtils.EnarryList.add(enarry);
                }
            case 1:
                if (time%20==0){
                    if (random>0.5){
                        enarry = new Enarry_2_L();
                    }
                    else{
                        enarry = new Enarry_2_R();
                    }
                    GameUtils.EnarryList.add(enarry);
                }
            case 0:
                if (time%10==0){
                    if (random>0.5){
                        enarry = new Enarry_1_L();
                    }
                    else{
                        enarry = new Enarry_1_R();
                    }
                    GameUtils.EnarryList.add(enarry);
                }
            default:
        }
        //移动方向
        for (Enarry enarry:GameUtils.EnarryList){
            enarry.x = enarry.x+enarry.dir*enarry.speed;
            if (isboos){
                //boos鱼吃掉小鱼
                if(boos.getRec().intersects(enarry.getRec())){
                    enarry.x = -200;
                    enarry.y = -200;
                }
                //boos吃掉我方鱼
                if (boos.getRec().intersects(myFish.getRec())){
//                    if(myFish.level>=boos.level){
//                        enarry.x=-200;
//                        enarry.y=-200;
//                        GameUtils.count = GameUtils.count +enarry.count;
//                    }else {
                        state = 2;
//                    }
                }
            }
            //我方小黑和敌方小黑碰撞检测  分数
            if(myFish.getRec().intersects(enarry.getRec())){
                if(myFish.level>=enarry.level){
                    enarry.x=-200;
                    enarry.y=-200;
                    GameUtils.count = GameUtils.count +enarry.count;
                }else{
                    state = 2;
                }

            }
        }
    }
    //重新开始  清空敌方小黑，重置我方与大小
    void reGame(){
        GameUtils.EnarryList.clear();//清空敌方小黑
        time = 0;
        myFish.level=1; //我方小黑重置等级
        GameUtils.count=0; //分数清空
        myFish.x = 700;
        myFish.y=500;
        myFish.width= 50;
        myFish.height = 50;
        boos=null;
        isboos = false;
    }
    public static void main(String[] args){
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }

}
