package edu.isel.adeetc.poo.Model;

public class JunkPile extends Elements  {

    protected JunkPile(int posX, int posY) {
        super(posX, posY);
    }

    public void junkPile (int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }
}
