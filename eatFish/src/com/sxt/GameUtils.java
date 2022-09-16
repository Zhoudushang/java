package com.sxt;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {
    //方向
    static boolean UP = false;
    static boolean DOWN = false;
    static boolean LEFT = false;
    static boolean RIGHT = false;

    static  int level;
    //分数
    static int count = 0;

    //敌方小黑集合
    public static List<Enarry> EnarryList = new ArrayList<>();

    //背景图
    public static Image bgimg = Toolkit.getDefaultToolkit().getImage("images/bg.jpeg");
    //小黑图片
    //一级
    public static Image Enarryl_img = Toolkit.getDefaultToolkit().getImage("images/b1.png");
    public static Image Enarryr_img = Toolkit.getDefaultToolkit().getImage("images/b1.png");
    //二级
    public static Image Enarry_2_l_img = Toolkit.getDefaultToolkit().getImage("images/b2.png");
    public static Image Enarry_2_r_img = Toolkit.getDefaultToolkit().getImage("images/b2.png");
    //三级
    public static Image Enarry_3_l_img = Toolkit.getDefaultToolkit().getImage("images/b3.png");
    public static Image Enarry_3_r_img = Toolkit.getDefaultToolkit().getImage("images/b3.png");
    //我方小黑
    public  static Image myFishimg_L = Toolkit.getDefaultToolkit().getImage("images/my.png");
    public  static Image myFishimg_R = Toolkit.getDefaultToolkit().getImage("images/my.png");
    //敌方boss图片
    public  static Image boosImg = Toolkit.getDefaultToolkit().getImage("images/boos.png");
    //绘制文字工具类
    public  static void  drawWord(Graphics g,String str,Color color,int size,int x,int y){
        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(str,x,y);

    }

}
