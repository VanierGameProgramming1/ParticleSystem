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
    protected GreenfootImage bgImage;
    protected int initialImageSize;
    protected double currentTime;
    protected double currentAngle;
    
    public Particle(ParticleEmitter source, GreenfootImage bgImage)
    {
        super();
        this.source = source;
        this.bgImage = bgImage;
        
        initialImageSize = (bgImage == null) ? 1 : bgImage.getWidth();
        
        setImage(bgImage);
        getImage().setTransparency(0);
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

        // Interpolate transparency and size
        if (t < 1.0f)
        {
           double size = source.getSize(t);
           scaleImage(size / initialImageSize);
           getImage().setTransparency((int) source.getOpacity(t));
        }
        else
        {
            getSimulationWorld().removeObject(this);
        }
    }    
}
