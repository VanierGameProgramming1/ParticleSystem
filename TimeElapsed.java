import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TimeElapsed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimeElapsed extends Actor
{
    private double timeElapsed = 0.0;
    
    public void act() 
    {
        SimulationWorld world = (SimulationWorld) getWorld();
        timeElapsed += world.getTimeStepDuration();
        
        setImage(new GreenfootImage("Time: " + (int) timeElapsed, 20, Color.WHITE, new Color(0,0,0,0)));
    }    
}