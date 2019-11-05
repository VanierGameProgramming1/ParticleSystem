import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Platform extends SimulationActor
{
    public void act() 
    {
        super.act();
    }    
    
    public int getWidth()
    {
        if (getImage() != null)
        {
            return getImage().getWidth();
        }
        else
        {
            return 0;
        }            
    }

    public int getHeight()
    {
        if (getImage() != null)
        {
            return getImage().getHeight();
        }
        else
        {
            return 0;
        }            
    }
}
