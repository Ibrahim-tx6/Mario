import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item extends Obstacle
{
    int anime;
    boolean onoff;
    int points;
    public Item() {
        anime = 0;
        onoff = true;
    }
    
    public void act()
    {
        Actor Mario = getOneObjectAtOffset(0, 26, Mario.class);
        if (onoff==true && Mario!=null) {
            //Add Points
            Greenfoot.playSound("smb_bump.wav");
            getWorld().addObject(new Star(), getX(), getY()-50);
            onoff = false;
        }
        
        if (onoff==true) {
            animation();
        }
        else {
            setImage("obstacle_item4.png");
        }
    }
    
    public void animation() {
        anime++;
        if (anime<10) {
            setImage("obstacle_item1.png");
        }
        else
        if (anime<20) {
            setImage("obstacle_item2.png");
        }
        else
        if (anime<30) {
            setImage("obstacle_item3.png");
        }
        else {
            anime = 0;
        }
    }
}
