import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AvatarFeedback here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AvatarFeedback extends Actor
{
    private Actor avatar;
    
    public AvatarFeedback(Actor parent)
    {
        avatar = parent;
    }
    
    public void act() 
    {
        setLocation(avatar.getX(), avatar.getY() - avatar.getImage().getHeight() / 2 - 20);
    }    
    
    public void setFeedback(String msg)
    {
        setImage(new GreenfootImage(msg, 20, Color.YELLOW, new Color(0,0,0,0)));
    }
}