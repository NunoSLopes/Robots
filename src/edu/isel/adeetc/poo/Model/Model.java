package edu.isel.adeetc.poo.Model;

public class Model {

    Arena arena = new Arena();

    public void gameStart(){

        arena.arena(50,50);

        arena.addElement(25,25, new Player(25,25));

        for ( int count=0; count < 7; ++count){
            int posX = (int) (Math.random()*50);
            int posY = (int) (Math.random()*50);
            /*if (checkEmpty(posX,posY))
                arena.addElement(posX,posY,new Robots(posX,posY));*/
        }


    }

    /*private boolean checkEmpty(int posX, int posY) {
        return (arena.isEmpty(posX, posY) == null)? true : false;
    }*/

    public void movePlayer(){

    }


}
