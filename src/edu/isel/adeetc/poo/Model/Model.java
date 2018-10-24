package edu.isel.adeetc.poo.Model;

public class Model {

    Arena arena = new Arena();
    private final int robots = 7;
    public final int limitRight = 50, limitDown = 50;

    public void gameStart(){

        arena.arena(limitRight,limitDown);

        arena.addElement(limitRight/2,limitDown/2, new Player(limitRight/2,limitDown/2));

        for ( int count=0; count < robots; ++count){
            int posX = (int) (Math.random()*50);
            int posY = (int) (Math.random()*50);
            if (arena.isEmpty(posX,posY))
                arena.addElement(posX,posY,new Robots(posX,posY));
        }


    }

    public void movePlayer(){
        int iStart = 0, iEnd = 0, jStart = 0, jEnd = 0, changePosX = 0, changePosY = 0;

        arena.movePlayer(iStart, iEnd, jStart, jEnd, changePosX, changePosY);
    }


}
