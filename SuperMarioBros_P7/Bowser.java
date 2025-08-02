import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Bowser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bowser extends Enemy
{
    int anime;
    int countDeath;
    boolean rotate;
    int time;
    public Bowser() {
        anime = 0;
        xSpeed = -2;
        alive = true;
        countDeath = 0;
        rotate = true;
        time = 0;
    }
    
    public void act()
    {
        if (alive==true) {
                if (onGround()==true) {
                ySpeed = 0;
            }
                else {
                ySpeed++;
            }
            animation();
            smart();
            collision();
            setLocation(getX()+xSpeed, getY()+ySpeed);
            
            ///Blow your brain!
            List A = getWorld().getObjects(Mario.class);
            Actor a = (Actor) A.get(0);
            if (a.getX()>getX()) 
              rotate = true;
            else
              rotate = false;
            
        }
        else {
            countDeath++;
            if (countDeath>10) {
                getWorld().removeObject(this);
            }
        }
        time++;
        if (time%80==0) {
            getWorld().addObject(new Fire(rotate), getX(), getY());
        }
        if (getX()>getWorld().getWidth()+getImage().getWidth()) {
            getWorld().removeObject(this);
        }
    }
    
    public void smart() {
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        Actor BL = getOneObjectAtOffset(-w/4, h/2, Obstacle.class);
        Actor BR = getOneObjectAtOffset(w/4, h/2, Obstacle.class);
        Actor LT = getOneObjectAtOffset(-w/2, -h/4, Obstacle.class);
        Actor RT = getOneObjectAtOffset(w/2, -h/4, Obstacle.class);
        if (BL==null || BR==null || LT!=null || RT!=null) {
            xSpeed = xSpeed * (-1);
           // rotate(180);
        }
    }
    
    public void animation() {
        anime++;
        if (anime<5) {
            setImage("enemy_bowser1.png");
            if (rotate==false)
              getImage().mirrorHorizontally();
        }
        else
        if (anime<10) {
            setImage("enemy_bowser2.png");
            if (rotate==false)
              getImage().mirrorHorizontally();
        }
        else
        if (anime<15) {
            setImage("enemy_bowser3.png");
            if (rotate==false)
              getImage().mirrorHorizontally();
        }
        else
        if (anime<20) {
            setImage("enemy_bowser4.png");
            if (rotate==false)
              getImage().mirrorHorizontally();
        }
        else {
            anime = 0;
        }
    }
}
