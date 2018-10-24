package edu.isel.adeetc.poo.Model;

public class Arena {

    private Elements arena[][];
    private Player player;
    private Robots robot;
    private Model model;


    public void arena(int limitRight, int limitDown) {
        arena = new Elements[limitRight][limitDown];
    }

    public void addElement(int posX, int posY, Elements elem){
        arena[posX][posY] = elem;
    }

    public void movePlayer (int iStart, int iEnd, int jStart, int jEnd, int changePosX, int changePosY){
        arena[player.posX][player.posY] = arena[player.posX+changePosX][player.posY + changePosY];
        arena[player.posX][player.posY] = null;
        player.posX += changePosX;
        player.posY += changePosY;
        moveRobots();
    }

    private void moveRobots() {
        int robotNewX= 0 , robotNewY = 0;
        for ( int i = 0 ; i < arena.length; ++i){
            for ( int j = 0 ; j < arena[i].length; ++j){
                if ( arena[i][j] instanceof Robots){
                    if( robot.posX > player.posX)
                        robotNewX = robot.posX --;
                    else if ( robot.posX < player.posX)
                        robotNewX = robot.posX ++;
                    if (robot.posY > player.posY)
                        robotNewY = robot.posY --;
                    else if (robot.posY < player.posY)
                        robotNewY = robot.posY ++;
                }
                if ( arena[robotNewX][robotNewY] instanceof JunkPile){
                    clashOfElements(robotNewX,robotNewY);
                    deleteElem(robot.posX,robotNewY);
                }else if( arena[robotNewX][robotNewY] instanceof Player){
                    deleteElem(robot.posX,robot.posY);
                    gameOver();
                }else if(arena[robotNewX][robotNewY] instanceof Robots){
                    clashOfElements(robotNewX,robotNewY);
                    deleteElem(robot.posX,robot.posY);
                }else if(arena[robotNewX][robotNewY] == null) {
                    robot.posY = robotNewY;
                    robot.posX = robotNewX;
                }
            }
        }

    }

    private void gameOver() {
        //todo
    }

    public void deleteElem (int posX, int posY){ arena[posX][posY] = null;}

    public boolean isEmpty(int posX, int posY){return arena[posX][posY] == null ? true : false;}

    public void clashOfElements(int changePosX, int changePosY){
        arena[changePosX][changePosY] = new JunkPile(changePosX,changePosY);
    }

    public void SafeTeleport(){
        int newPosX = 0;
        int newPosY = 0;
        do{
            newPosX = RandomPositionX();
            newPosY = RandomPositionY();

        }while (arena[newPosX][newPosY] != null);

        deleteElem(player.posX,player.posY);

        addElement(newPosX,newPosY, new Player(newPosX,newPosY));

    }

    public void DangerousTeleport(){

    }

    public int RandomPositionX(){
        return (int)(Math.random()*model.limitRight);
    }

    public int RandomPositionY(){
        return (int)(Math.random()*model.limitRight);
    }
}
