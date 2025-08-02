import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Points here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Points extends Actor
{
    public static int point;
    
    public Points() {
        point = 0;
    }
    public void act()
    {
        String text = "Points "+point;
        GreenfootImage image = new GreenfootImage(text, 30, Color.WHITE, new Color(0, 0, 0, 0));
        setImage(image);
    }
}
