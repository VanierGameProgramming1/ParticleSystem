import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SmokeEmitter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SmokeEmitter extends ParticleEmitter
{
    public SmokeEmitter(SimulationActor parent)
    {
        super(parent, 25.0, 5.0, new Vector2D(0.0, 1.0f), 0.5, 25.0, 5.0, 128.0, 125.0, 0.0, new GreenfootImage("smoke.png"));
    }
        
    public void act() 
    {
        super.act();
    }    
}
