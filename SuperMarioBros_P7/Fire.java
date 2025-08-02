import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fire extends Enemy
{
    int xSpeed;
    public Fire(boolean rotate) {
        if (rotate==true)
            xSpeed = 5;
        else
            xSpeed = -5;
    }

    public void act()
    {
        setLocation(getX()+xSpeed, getY());
        if (isTouching(Mario.class)) {
            getWorld().removeObject(this);
            Lives.live--;
            if (Lives.live==0) {
                    Greenfoot.setWorld(new GameOver());
            }
        }

        
    }
}
