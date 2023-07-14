package com.company;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.*;
import javax.swing.JPanel;
public class GamePanel extends JPanel implements Runnable {
    static final int GAME_WIDTH=1200;
    static final int GAME_HEIGHT=(int)(GAME_WIDTH*(0.5555));
    static final  Dimension SCREEN_SIZE=new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIAMTER=20;
    static final int PADDLE_WIDTH=25;
    static final int PADDLE_HEIGHT=100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Player player1;
    Player player2;
    Player player3;
    Player player4;
    GoolKeeper GoolKeeper;
    GoalkeeperThread goal;
    Ball ball1;
    Ball ball2;
    Ball ball3;
    Ball ball4;
    Score score1;
    Score score2;
    Score score3;
    Score score4;
    GamePanel()
    {
        newPaddle();
        newBall();
        score1=new Score(GAME_WIDTH,GAME_HEIGHT,1);
        score2=new Score(GAME_WIDTH,GAME_HEIGHT,2);
        score3=new Score(GAME_WIDTH,GAME_HEIGHT,3);
        score4=new Score(GAME_WIDTH,GAME_HEIGHT,4);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);
        gameThread=new Thread(this);
        gameThread.start();
    }
    public void newBall()
    {
        ball1=new Ball(10,(GAME_HEIGHT/2)-(BALL_DIAMTER-290),BALL_DIAMTER,BALL_DIAMTER,1);//player1
        ball2=new Ball(-1200,(GAME_HEIGHT/2)-(BALL_DIAMTER-110),BALL_DIAMTER,BALL_DIAMTER,2);//player2
        ball3=new Ball(-2500,(GAME_HEIGHT/2)-(BALL_DIAMTER+70),BALL_DIAMTER,BALL_DIAMTER,3);//player3
        ball4=new Ball(-3700,(GAME_HEIGHT/2)-(BALL_DIAMTER+230),BALL_DIAMTER,BALL_DIAMTER,4);//player4
    }
    public void newPaddle()
    {
        player1 =new Player(0,(GAME_HEIGHT)-(PADDLE_HEIGHT+10),PADDLE_WIDTH,PADDLE_HEIGHT,1);//player1
        player2 =new Player(0,(GAME_HEIGHT/2)-((PADDLE_HEIGHT/2)-100),PADDLE_WIDTH,PADDLE_HEIGHT,2);//player2
        player3 =new Player(0,(GAME_HEIGHT/5)-((PADDLE_HEIGHT/2)-120),PADDLE_WIDTH,PADDLE_HEIGHT,3);//player3
        player4 =new Player(0,(GAME_HEIGHT/7)-((PADDLE_HEIGHT/2)),PADDLE_WIDTH,PADDLE_HEIGHT,4);//player4
        GoolKeeper =new GoolKeeper(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT+30/2),PADDLE_WIDTH,PADDLE_HEIGHT,5);//COMP
    }
    public void paint(Graphics g)
    {
        image=createImage(getWidth(),getHeight());
        graphics=image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }
    public void draw(Graphics g)
    {
        player1.draw(g);
        player2.draw(g);
        player3.draw(g);
        player4.draw(g);
        GoolKeeper.draw(g);
        ball1.draw(g);
        ball2.draw(g);
        ball3.draw(g);
        ball4.draw(g);
        score1.draw(g);
        score2.draw(g);
        score3.draw(g);
        score4.draw(g);
    }
    public void move()
    {

        goal=new GoalkeeperThread(GoolKeeper);
        goal.start();
        ball1.move();
        ball2.move();
        ball3.move();
        ball4.move();
    }
    public void checkcollision()
    {
        if(GoolKeeper.y<=0)
        {
            GoolKeeper.y=0;
        }
       else if(GoolKeeper.y>=(GAME_HEIGHT-PADDLE_HEIGHT))
        {
            GoolKeeper.y=GAME_HEIGHT-PADDLE_HEIGHT;
        }
        while(ball1.x>=GAME_WIDTH-BALL_DIAMTER&ball2.x>=GAME_WIDTH-BALL_DIAMTER&ball3.x>=GAME_WIDTH-BALL_DIAMTER&ball4.x>=GAME_WIDTH-BALL_DIAMTER)
        {
            score1.player1=score1.player1+5;
            score2.player2=score2.player2+5;
            score3.player3=score3.player3+5;
            score4.player4=score4.player4+5;
            if(ball4.intersects(GoolKeeper))
            {
                score4.player4=score4.player4-5;
            }
            newPaddle();
            newBall();
        }
        if(ball1.intersects(GoolKeeper))
        {
            score1.player1=score1.player1-1;
        }
        if(ball2.intersects(GoolKeeper))
        {
            score2.player2=score2.player2-1;
        }
        if(ball3.intersects(GoolKeeper))
        {
            score3.player3=score3.player3-1;
        }
    }
    public void run()
    {
        long lastTime=System.nanoTime();
        double amountOfTicks=60.0;
        double ns=1000000000/amountOfTicks;
        double delta=0;
        while (true)
        {
            long now=System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime=now;
            if(delta>=1)
            {
                move();
                checkcollision();
                repaint();
                delta--;
            }
        }
    }
    public class AL extends KeyAdapter{

        public void keyPressed(KeyEvent e)
        {
            GoolKeeper.keyPressed(e);
        }
        public void keyReleased(KeyEvent e)
        {
            GoolKeeper.keyReleased(e);
        }
    }

}
