package edu.isel.adeetc.poo.Model;

public class Arena {

    private Elements arena[][];
    private Player player;
    private Robots robot;


    public void arena(int limitRight, int limitDown) {
        arena = new Elements[limitRight][limitDown];
    }

    public void addElement(int posX, int posY, Elements elem){
        arena[posX][posY] = elem;
    }

    public void movePlayer (int iStart, int iEnd, int jStart, int jEnd, int changePosX, int changePosY){
        arena[player.getX()][player.getY()] = arena[player.getX()+changePosX][player.getY() + changePosY];
        arena[player.getX()][player.getY()] = null;
        player.posX += changePosX;
        player.posY += changePosY;
        moveRobots(iStart, iEnd, jStart, jEnd, changePosX, changePosY);
    }

    private void moveRobots(int iStart, int iEnd, int jStart, int jEnd, int changePosX, int changePosY) {

        for (int i = iStart ;;){
            if (( iStart < iEnd && i < iEnd) | (iEnd <= iStart && i >= iEnd)){
                for (int j = jStart; j<jEnd; ++j){
                    if(!isEmpty(i,j) && arena[i + changePosX][j + changePosY] instanceof Robots){
                        clashOfElements(i,j,i+changePosX,j+changePosY);
                    }else if (!isEmpty(i,j) && arena[i + changePosX][j + changePosY] instanceof Player){
                        gameOver();
                    }else if (!isEmpty(i,j) && arena[i + changePosX][j + changePosY] instanceof JunkPile){
                        //todo
                    }
                }
            }
        }
    }

    private void gameOver() {
        //todo
    }

    public void deleteElem (int posX, int posY){ arena[posX][posY] = null;}

    public boolean isEmpty(int posX, int posY){return arena[posX][posY] == null ? true : false;}

    public void clashOfElements(int i, int j, int changePosX, int changePosY){
        arena[i+changePosX][j+changePosY] = new JunkPile(i + changePosX,j + changePosY);
        arena[i][j] = null;
    }
}
