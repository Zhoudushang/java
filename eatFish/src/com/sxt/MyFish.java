package com.sxt;

import java.awt.*;

public class MyFish {
    //图片
    Image img = GameUtils.myFishimg_L;
    int x = 500;
    int y = 350;
    int width = 50;
    int height= 70;
    //定义移动速度
    int speed = 20;
    //定义等级
    int level = 1;

    void logic(){
        if(GameUtils.UP){
            y = y-speed;
        }
        if(GameUtils.DOWN){
            y = y+speed;

        }
        if(GameUtils.LEFT){
            x = x-speed;
            img = GameUtils.myFishimg_L;
        }
        if(GameUtils.RIGHT){
            x = x+speed;
            img = GameUtils.myFishimg_R;
        }
    }

    //绘制自身方法
    public void paintSelf(Graphics g){
        logic();
        g.drawImage(img,x,y,width+GameUtils.count,height+GameUtils.count,null);
    }
    //获取自身矩形用于获取经验
    public Rectangle getRec(){
        return new Rectangle(x,y,width+GameUtils.count,height+GameUtils.count);
    }
}
