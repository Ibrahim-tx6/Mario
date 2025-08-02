import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Welcome here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Welcome extends World
{
    
    public Welcome()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false);
        GreenfootImage image = new GreenfootImage(1200, 800);
        image.setColor(Color.BLUE);
        image.fill();
        
        String text = "Super Mario";
        image.setColor(Color.BLACK);
        Font font = new Font("Rockwell",true,false,40);
        image.setFont(font);
        image.drawString(text, 200, 100);
        
        text = "created by Ibrahim Mohammed";
        image.setColor(Color.RED);
        font = new Font("Futura",false,true,20);
        image.setFont(font);
        image.drawString(text, 200, 200);

        text = "Press SPACE to start";
        image.setColor(Color.RED);
        font = new Font("Baskerville",false,true,30);
        image.setFont(font);
        image.drawString(text, 200, 280);
        
        setBackground(image);
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("SPACE")) {
            Greenfoot.setWorld(new World_1());
        }
    }
}