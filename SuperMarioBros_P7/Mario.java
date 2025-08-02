import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Mario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mario extends Actor
{
    int xSpeed, ySpeed;
    boolean onGround;
    int friction;
    int anime;
    String facing;
    public Mario() {
        onGround = false;
        friction = 0;
        anime = 0;
        facing = "R";
    }
    
    public void act()
    {
        friction++;
        //Ground
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        Actor BL = getOneObjectAtOffset(-w/4, h/2, Obstacle.class);
        Actor BR = getOneObjectAtOffset(w/4, h/2, Obstacle.class);
        collision();
        jumpOnEnemy();
        if (BL!=null || BR!=null) {
            ySpeed = 0; onGround = true;
        }
        else {
            ySpeed++; onGround = false;
        }
        
        //Movement
        if (Greenfoot.isKeyDown("LEFT")) {
            xSpeed--;
        }
        if (Greenfoot.isKeyDown("RIGHT")) {
            xSpeed++;
        }
        if (Greenfoot.isKeyDown("UP") && onGround) {
            ySpeed=-20;
            Greenfoot.playSound("smb_jump1.wav");
        }
        
        //Speed Limit
        if (xSpeed>10) {
            xSpeed = 10;
        }
        if (xSpeed<-10) {
            xSpeed = -10;
        }
        if (ySpeed<-20) {
            ySpeed = -20;
        }
        
        //Friction
        if (xSpeed>0 && friction%2==0) {
            xSpeed--;
        }
        if (xSpeed<0 && friction%2==0) {
            xSpeed++;
        }
        
        if (xSpeed>0 && onGround) {
            facing = "R";
            animation(facing);
        }
        if (xSpeed<0 && onGround) {
            facing = "L";
            animation(facing);
        }
        
        if (onGround==false) {
            if (facing.equals("L")==true) {
                setImage("marios_jumpL.png");
            }
            else {
                setImage("marios_jumpR.png");
            }
        }
        if (onGround==true && xSpeed==0) {
            if (facing.equals("L")==true) {
                setImage("marios_standL.png");
            }
            else {
                setImage("marios_standR.png");
            }
        }
        setLocation(getX()+xSpeed, getY()+ySpeed);
        
        if (getX()<getWorld().getWidth()*1/3-w/2) {
            int d = getX() - (getWorld().getWidth()*1/3-w/2);
            setLocation(getWorld().getWidth()*1/3-w/2, getY());
            muevelo(d);
        }
        
        if (getX()>getWorld().getWidth()*2/3+w/2) {
            int d = getX() - (getWorld().getWidth()*2/3+w/2);
            setLocation(getWorld().getWidth()*2/3+w/2, getY());
            muevelo(d);
        }
        
        if (isTouching(Flag.class)) {
            if (getWorld() instanceof World_1) {
                Greenfoot.setWorld(new World_2());
                Greenfoot.playSound("smb_stage_clear.wav");
            }
            if (getWorld() instanceof World_2) {
                Greenfoot.setWorld(new World_3());
                Greenfoot.playSound("smb_stage_clear.wav");
            }
            if (getWorld() instanceof World_3) {
                Greenfoot.setWorld(new Win());
                Greenfoot.playSound("smb_ending.mp3");
            }
        }
        
    }
    
    public void muevelo(int d) {
        List T = getWorld().getObjects(Scrolling.class);
        for ( int i=0; i<T.size(); i++) {
            Actor t = (Actor) T.get(i);
            t.setLocation(t.getX()-d, t.getY());
        }
    }
    
    public void jumpOnEnemy() {
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        Enemy BL = (Enemy) getOneObjectAtOffset(-w/4, h/2, Enemy.class);
        Enemy BR = (Enemy) getOneObjectAtOffset(w/4, h/2, Enemy.class);
        if (BL!=null || BR!=null) {
            ySpeed = -20;
            if(BL!=null) {
                BL.alive = false;
            }
            if(BR!=null) {
                BR.alive = false;
            }
        }
        else {
            if (isTouching(Enemy.class)) {
                Lives.live--;
                setLocation(500, 200);
                if (Lives.live==0) {
                    Greenfoot.setWorld(new GameOver());
                    Greenfoot.playSound("smb_gameover.mp3");
                }
                
            }
        }
    }
    
    public void animation(String f) {
        anime++;
        if (anime<5) {
            setImage("marios_walk1"+f+".png");
        }
        else
        if (anime<10) {
            setImage("marios_walk2"+f+".png");
        }
        else
        if (anime<15) {
            setImage("marios_walk3"+f+".png");
        }
        else {
            anime = 0;
        }
    }
    
    public void collision() {
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        
        Actor TL = getOneObjectAtOffset(-w/4, -h/2, Obstacle.class);
        Actor TR = getOneObjectAtOffset(w/4, -h/2, Obstacle.class);
        Actor BL = getOneObjectAtOffset(-w/4, h/2, Obstacle.class);
        Actor BR = getOneObjectAtOffset(w/4, h/2, Obstacle.class);
        Actor LT = getOneObjectAtOffset(-w/2, -h/4, Obstacle.class);
        Actor LB = getOneObjectAtOffset(-w/2, h/4, Obstacle.class);
        Actor RT = getOneObjectAtOffset(w/2, -h/4, Obstacle.class);
        Actor RB = getOneObjectAtOffset(w/2, h/4, Obstacle.class);
        
        //Top
        if (TL!=null) {
            ySpeed = 0;
            int oh = TL.getImage().getHeight();
            setLocation(getX(), TL.getY() + oh/2 + h/2);
        }
        if (TR!=null) {
            ySpeed = 0;
            int oh = TR.getImage().getHeight();
            setLocation(getX(), TR.getY() + oh/2 + h/2);
        }
        
        //Bottom
        if(BR!=null) {
            ySpeed = 0;
            setLocation(getX(), BR.getY() - BR.getImage().getHeight()/2 - h/2);
        }
        if(BL!=null) {
            ySpeed = 0;
            setLocation(getX(), BL.getY() - BL.getImage().getHeight()/2 - h/2);
        }
        
        //Left
        if (LT!=null) {
            xSpeed = 0;
            int ow = LT.getImage().getWidth();
            setLocation(LT.getX() + ow/2 + w/2, getY());
        }
        if (LB!=null) {
            xSpeed = 0;
            int ow = LB.getImage().getWidth();
            setLocation(LB.getX() + ow/2 + w/2, getY());
        }
        
        //Right
        if (RT!=null) {
            xSpeed = 0;
            int ow = RT.getImage().getWidth();
            setLocation(RT.getX() - ow/2 - w/2, getY());
        }
        if (RB!=null) {
            xSpeed = 0;
            int ow = RB.getImage().getWidth();
            setLocation(RB.getX() - ow/2 - w/2, getY());
        }
    }
}
