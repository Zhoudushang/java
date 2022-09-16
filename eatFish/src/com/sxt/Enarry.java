package com.sxt;

import java.awt.*;

//敌对小黑的父类
public class Enarry {
    //定义图片
    Image img;
    //定义物体坐标
    int x;
    int y;
    int width;
    int height;
    //定义移动速度
    int speed;
    //定义移动方向  向左=1 向右=-1
    int dir = 1;
    //定义分值
    int level;
    int count;
    //绘制自身方法
    public void paintSelf(Graphics g){
        g.drawImage(img,x,y,width,height,null);
    }
    //获取自身矩形用于获取经验
    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }
}
//敌方小黑的左类
class  Enarry_1_L extends Enarry {
    //在工具类中获取小黑的图片
    Enarry_1_L() {
        this.x = -45;
        this.y = (int) (Math.random() * 700 + 100);//位置
        this.width = 30;
        this.height = 30;//宽高
        this.count = 1;//分值
        this.speed = 10;//速度
        this.dir = 1;//方向
        this.level =1;//等级
        this.img = GameUtils.Enarryl_img;
    }
}
//右方
class  Enarry_1_R extends Enarry_1_L{
    //在工具类中获取小黑的图片
    Enarry_1_R(){
        this.x = 1400;
        this.dir=-1;//方向
        this.img = GameUtils.Enarryr_img;
    }
}
//二级
class Enarry_2_L extends Enarry{
    Enarry_2_L(){
        this.x = -45;
        this.y = (int) (Math.random() * 700 + 100);//位置
        this.width = 40;
        this.height = 40;//宽高
        this.count = 2;//分值
        this.speed = 10;
        this.dir = 1;
        this.level=2;
        this.img = GameUtils.Enarry_2_l_img;
    }
}
class  Enarry_2_R extends Enarry_2_L{
    Enarry_2_R(){
        this.x = 1400;
        this.dir=-1;//方向
        this.img = GameUtils.Enarry_2_r_img;
    }
}
//三级
class Enarry_3_L extends Enarry{
    Enarry_3_L(){
        this.x = -45;
        this.y = (int) (Math.random() * 700 + 100);//位置
        this.width = 50;
        this.height = 50;//宽高
        this.count = 5;//分值
        this.speed = 10;
        this.dir = 1;
        this.level=3;
        this.img = GameUtils.Enarry_3_l_img;
    }
}
class  Enarry_3_R extends Enarry_3_L{
    Enarry_3_R(){
        this.x = 1400;
        this.dir=-1;//方向
        this.img = GameUtils.Enarry_3_r_img;
    }
}
//敌方boss类
class Enarry_Boss extends  Enarry{
    Enarry_Boss(){
        this.x = -1000;
        this.y = (int) (Math.random() * 700 + 100);//位置
        this.width = 340;
        this.height = 340;//宽高
        this.count = 0;//分值
        this.speed = 30;
        this.dir = 1;
        this.level=5;
        this.img = GameUtils.boosImg;
    }
}
