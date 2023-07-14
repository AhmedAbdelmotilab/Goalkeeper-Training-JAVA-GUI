package com.company;
import javax.swing.JFrame;
import java.awt.*;
public class GameFrame extends JFrame
{
    GamePanel panel;
    GameFrame(){
        panel=new GamePanel();
        this.add(panel);
        this.setTitle("Goalkeeper Training");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(Color.PINK);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}