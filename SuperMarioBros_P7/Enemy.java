import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Scrolling
{
    int xSpeed, ySpeed;
    boolean alive;
    
    public void act()
    {
        // Add your action code here.
    }
    
    public boolean onGround() {
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        Actor BL = getOneObjectAtOffset(-w/4, h/2, Obstacle.class);
        Actor BR = getOneObjectAtOffset(w/4, h/2, Obstacle.class);
        if (BL!=null || BR!=null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void collision() {
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        
        Actor TL = getOneObjectAtOffset(-w/4, -h/2, Obstacle.class);
        Actor TR = getOneObjectAtOffset(w/4, -h/2, Obstacle.class);
        Actor BL = getOneObjectAtOffset(-w/4, h/2, Obstacle.class);
        Actor BR = getOneObjectAtOffset(w/4, h/2, Obstacle.class);
        Actor LT = getOneObjectAtOffset(-w/2, -h/4, Obstacle.class);
        Actor LB = getOneObjectAtOffset(-w/2, h/4, Obstacle.class);
        Actor RT = getOneObjectAtOffset(w/2, -h/4, Obstacle.class);
        Actor RB = getOneObjectAtOffset(w/2, h/4, Obstacle.class);
        //Bottom
        if(BR!=null) {
            ySpeed = 0;
            setLocation(getX(), BR.getY() - BR.getImage().getHeight()/2 - h/2);
        }
        if(BL!=null) {
            ySpeed = 0;
            setLocation(getX(), BL.getY() - BL.getImage().getHeight()/2 - h/2);
        }
    }
}
