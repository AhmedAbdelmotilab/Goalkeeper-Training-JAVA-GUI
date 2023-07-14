package com.company;
import java.awt.*;
import java.awt.event.KeyEvent;
public class GoolKeeper extends Rectangle {
    int id;
     int yVelocity;
    int speed=10;
    GoolKeeper(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id)
    {
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
        this.id=id;
    }
    public void keyPressed(KeyEvent e)
    {
        switch (id){
            case 5:
                if(e.getKeyCode()==KeyEvent.VK_W){
                    setYDirection(-speed);
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    setYDirection(speed);
                }
                break;

        }
    }
    public void keyReleased(KeyEvent e)
    {
        switch (id){
            case 5:
                if(e.getKeyCode()==KeyEvent.VK_W){
                    setYDirection(0);
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    setYDirection(0);
                }
                break;
        }
    }
    public void setYDirection(int yDirection)
    {
        yVelocity=yDirection;
    }
    public  void move()
    {
        y=y+yVelocity;
    }
    public void draw(Graphics g)
    {
        if(id==5)
        {
            g.setColor(Color.RED);
        }
        g.fillRect(x,y,width,height);
    }

}
