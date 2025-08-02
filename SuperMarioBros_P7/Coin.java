import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Scrolling
{
    int anime;
    public Coin() {
        anime = 0;
    }
    
    public void act()
    {
        animation();
        if (isTouching(Mario.class)) {
            Points.point++;
            Greenfoot.playSound("smb_coin.wav");
            getWorld().removeObject(this);
        }
    }
    
    public void animation() {
        anime++;
        if (anime<10) {
            setImage("obstacle_coin1.png");
        }
        else
        if (anime<20) {
            setImage("obstacle_coin2.png");
        }
        else
        if (anime<30) {
            setImage("obstacle_coin3.png");
        }
        else {
            anime = 0;
        }
    }
}
