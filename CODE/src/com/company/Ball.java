package com.company;
import java.awt.*;
import java.util.Random;
public class Ball extends Rectangle{
    Random random;
    int id;
    int xVelocity;
    int speed=9;
    Ball(int x,int y,int widht,int height,int id){
        super(x,y,widht,height);
        this.id=id;
        random=new Random();
        int randomXDirection= random.nextInt(1);
        if(randomXDirection==0)
            randomXDirection++;
        setXDirection(randomXDirection*speed);
    }
    public void setXDirection(int randomXDirection)
    {
        xVelocity=randomXDirection;
    }
    public void move()
    {
        x+=xVelocity;
    }
    public void draw (Graphics g)
    {
        if(id==1)
        {
            g.setColor(Color.CYAN);
        }
        else if(id==2)
        {
            g.setColor(Color.MAGENTA);
        }
        else if(id==3)
        {
            g.setColor(Color.BLUE);
        }
        else if(id==4)
        {
            g.setColor(Color.BLACK);
        }
        else if(id==5)
        {
            g.setColor(Color.GRAY);
        }
        g.fillOval(x,y,width,height);
    }

}
