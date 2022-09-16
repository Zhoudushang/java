package com.sxt;

import java.awt.*;

public class Bg {
    void  paintSelf(Graphics g,int fishLevel){
        //游戏的背景
        g.drawImage(GameUtils.bgimg,0,0,null);
        switch (GameWin.state){
            case 0:
                GameUtils.drawWord(g,"开始",Color.red,80,500,300);
                break;
            case 4:
            case 1:
                GameUtils.drawWord(g,"分数:"+GameUtils.count,Color.red,30,100,120);
                GameUtils.drawWord(g,"难度:"+GameUtils.level,Color.red,30,250,120);
                GameUtils.drawWord(g,"等级:"+fishLevel,Color.red,30,400,120);
                break;
            case 2:
                GameUtils.drawWord(g,"失败了!",Color.red,80,400,500);
                break;
            case 3:
                GameUtils.drawWord(g,"分数:"+GameUtils.count,Color.red,40,500,200);
                GameUtils.drawWord(g,"难度:"+GameUtils.level,Color.red,40,500,300);
                GameUtils.drawWord(g,"等级:"+fishLevel,Color.red,40,500,400);
                GameUtils.drawWord(g,"胜利!",Color.red,40,500,500);
                break;
            default:
        }
    }
}
