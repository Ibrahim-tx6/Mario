import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lives here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lives extends Actor
{
    public static int live;
    
    public Lives() {
        live = 3;
    }
    public void act()
    {
        String text = "Lives "+live;
        GreenfootImage image = new GreenfootImage(text, 30, Color.WHITE, new Color(0, 0, 0, 0));
        setImage(image);
    }
}
