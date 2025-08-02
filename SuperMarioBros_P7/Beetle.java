import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Beetle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Beetle extends Enemy
{
    int anime;
    int countDeath;
    public Beetle() {
        anime = 0;
        xSpeed = -2;
        alive = true;
        countDeath = 0;
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
        }
        else {
            countDeath++;
            setImage("enemy_beetle3.png");
            if (countDeath>10) {
                Greenfoot.playSound("smb_stomp.wav");
                getWorld().removeObject(this);
            }
        }

    }

    public void smart() {
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        Actor BL = getOneObjectAtOffset(-w/4, h/2, Obstacle.class);
        Actor BR = getOneObjectAtOffset(w/4, h/2, Obstacle.class);
        Actor LT = getOneObjectAtOffset(-w/2, -h/4, Obstacle.class);
        Actor LB = getOneObjectAtOffset(-w/2, h/4, Obstacle.class);
        Actor RT = getOneObjectAtOffset(w/2, -h/4, Obstacle.class);
        Actor RB = getOneObjectAtOffset(w/2, h/4, Obstacle.class);
        if (BL==null || BR==null || LT!=null || RT!=null || LB!=null || RB!=null) {
            xSpeed = xSpeed * (-1);
            getImage().mirrorHorizontally();
        }
    }

    public void animation() {
        anime++;
        if (anime<5) {
            setImage("enemy_beetle1.png");
            if (xSpeed<0)
              getImage().mirrorHorizontally();
        }
        else
        if (anime<10) {
            setImage("enemy_beetle2.png");
            if (xSpeed<0)
              getImage().mirrorHorizontally();

        }
        else {
            anime = 0;
        }
    }
}
