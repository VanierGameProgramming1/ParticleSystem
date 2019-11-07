import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Particle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Particle extends SimulationActor
{
    protected ParticleEmitter source;
    protected double currentTime;
    protected int currentAngle;
    protected GreenfootImage bgImage;
    
    public Particle(ParticleEmitter source, GreenfootImage bgImage)
    {
        this.source = source;
        this.bgImage = bgImage;
        setImage(bgImage);
        currentTime = 0.0;
        currentAngle = Greenfoot.getRandomNumber(360);
        setRotation((int) currentAngle);
    }
    
    public void act() 
    {
        super.act();
        
        double dt = getSimulationWorld().getTimeStepDuration();
        double t  = currentTime / source.getLifeTime();

        // Update time, position, angle
        currentTime += dt;
        currentAngle += source.getAngularVelocity() * dt;
        setRotation((int) currentAngle);
        
        // Interpolate Values
        if (t < 1.0f)
        {
           getImage().setTransparency((int)source.getOpacity(t));
        }
        
        if (t >= 1.0)
        {
            getSimulationWorld().removeObject(this);
        }
    }    
    
    public double lerp(double minValue, double maxValue, double t)
    {
        return minValue + t * (maxValue - minValue);
    }
}
