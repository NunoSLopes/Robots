package edu.isel.adeetc.poo.Model;

public class Player extends Elements{

    protected Player(int posX, int posY) {
        super(posX, posY);
    }

    public void player (int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public int getY(){return posY;}

    public int getX(){return posX;}
}
