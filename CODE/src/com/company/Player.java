package com.company;
import java.awt.*;
public class Player extends Rectangle {
    int id;
    Player(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id)
    {
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
        this.id=id;
    }
    public void draw(Graphics g)
    {
        if(id==1)
        {
            g.setColor(Color.CYAN);
        }
        if(id==2)
        {
            g.setColor(Color.MAGENTA);
        }
        if(id==3)
        {
            g.setColor(Color.BLUE);
        }
        if(id==4)
        {
            g.setColor(Color.black);
        }
        g.fillRect(x,y,width,height);
    }
}
