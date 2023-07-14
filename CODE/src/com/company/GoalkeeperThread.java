package com.company;
public class GoalkeeperThread extends Thread{
    GoolKeeper g;
    public GoalkeeperThread(GoolKeeper g)
    {
        this.g=g;
    }
    @Override
    public void run() {
        g.move();
    }
}
