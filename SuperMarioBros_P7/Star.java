import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Scrolling
{
    int anime;
    public Star() {
        anime = 0;
    }
    
    public void act()
    {
        animation();
        if (isTouching(Mario.class)) {
            Greenfoot.playSound("smb_1up.wav");
            getWorld().removeObject(this);
            Lives.live++;
        }
    }
    
    public void animation() {
        anime++;
        if (anime<10) {
            setImage("powerup_star1.png");
        }
        else
        if (anime<20) {
            setImage("powerup_star2.png");
        }
        else
        if (anime<30) {
            setImage("powerup_star3.png");
        }
        else
        if (anime<40) {
            setImage("powerup_star4.png");
        }
        else {
            anime = 0;
        }
    }
}
