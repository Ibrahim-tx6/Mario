import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Win here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Win extends World
{
    public Win()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false);
        GreenfootImage image = new GreenfootImage(1200, 800);
        image.setColor(Color.RED);
        image.fill();
        
        String text = "You Win!";
        image.setColor(Color.BLACK);
        Font font = new Font("Rockwell",true,false,50);
        image.setFont(font);
        image.drawString(text, 200, 200);

        setBackground(image);
    }
}
