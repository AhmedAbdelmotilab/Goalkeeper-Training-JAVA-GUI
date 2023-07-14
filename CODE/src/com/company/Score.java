package com.company;
import java.awt.*;
public class Score extends Rectangle {
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player1=0;
    int player2=0;
    int player3=0;
    int player4=0;
    int id;
    Score(int GAME_WIDTH,int GAME_HEIGHT,int id){
        Score.GAME_WIDTH=GAME_WIDTH;
        Score.GAME_HEIGHT=GAME_HEIGHT;
        this.id=id;
    }
    public void draw(Graphics g)
    {
        if(id == 1)
        {
            g.setColor(Color.CYAN);
            g.setFont(new Font("Consolas",Font.PLAIN,60));
            g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10),(GAME_WIDTH/2)-350,50);
        }
        if(id == 2)
        {
            g.setColor(Color.MAGENTA);
            g.setFont(new Font("Consolas",Font.PLAIN,60));
            g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10),(GAME_WIDTH/2)-150,50);
        }
        if(id == 3)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Consolas",Font.PLAIN,60));
            g.drawString(String.valueOf(player3/10)+String.valueOf(player3%10),(GAME_WIDTH/2),50);
        }
        if(id == 4)
        {
            g.setColor(Color.black);
            g.setFont(new Font("Consolas",Font.PLAIN,60));
            g.drawString(String.valueOf(player4/10)+String.valueOf(player4%10),(GAME_WIDTH/2)+150,50);
        }

    }
}
