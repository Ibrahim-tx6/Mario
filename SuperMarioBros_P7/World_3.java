import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World_3 extends World
{
    Mario mario;
    String [] IhateArrays;
    Lives lives;
    Points points;
    public World_3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false); 
        setBackground("background_ma.png");
        
        mario = new Mario();
        addObject(mario, 200, 200);
        IhateArrays = new String[16];
        IhateArrays[0] = "";
        IhateArrays[1] = "";
        IhateArrays[2] = "";
        IhateArrays[3] = "";
        IhateArrays[4] = "BBBBBBBI";
        IhateArrays[5] = "";
        IhateArrays[6] = "          I";
        IhateArrays[7] = "";
        IhateArrays[8] = "             BBBBB";
        IhateArrays[9] = "                                   BBB            F";
        IhateArrays[10] = "     BB                                BBB";
        IhateArrays[11] = "    BBBIBBB                   BBB";
        IhateArrays[12] = "                                           BBBBB";
        IhateArrays[13] = "               O         O";
        IhateArrays[14] = "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB";
        IhateArrays[15] = "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB";
        
        lives = new Lives();
        addObject(lives, 100, 50);
        points = new Points();
        addObject(points, 200, 50);
        
        mario_maker();
    }
    
    public void mario_maker() {
        for (int i=0; i<IhateArrays.length; i++) {
            for (int j=0; j<IhateArrays[i].length(); j++) {
                if (IhateArrays[i].substring(j, j+1).equals("B")) {
                    addObject(new Block(), j*50, i*50+25);
                }
                if (IhateArrays[i].substring(j, j+1).equals("G")) {
                    addObject(new Goomba(), j*50, i*50+25);
                }
                if (IhateArrays[i].substring(j, j+1).equals("I")) {
                    addObject(new Item(), j*50, i*50+25);
                }
                if (IhateArrays[i].substring(j, j+1).equals("C")) {
                    addObject(new Coin(), j*50, i*50+25);
                }
                if (IhateArrays[i].substring(j, j+1).equals("F")) {
                    addObject(new Flag(), j*50, i*50);
                }
                if (IhateArrays[i].substring(j, j+1).equals("O")) {
                    addObject(new Bowser(), j*50, i*50+25);
                }
                if (IhateArrays[i].substring(j, j+1).equals("W")) {
                    addObject(new Beetle(), j*50, i*50+25);
                }
            }
        }
    }
}
