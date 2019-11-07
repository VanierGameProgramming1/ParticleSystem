import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ParticleEmitter extends SimulationActor
{
    protected double timeUntilNewParticle = 0.0;
    protected double emissionRate;
    protected double lifetime;
    protected double angularVelocity;
    protected double initialSize, finalSize;
    protected double initialOpacity, finalOpacity;
    protected GreenfootImage bgImage;
    
    public ParticleEmitter( double emissionRate, double lifetime,double angularVelocity,
                            double initialSize, double finalSize, double initialOpacity, double finalOpacity, 
                            GreenfootImage bgImage )
    {
        this.emissionRate = emissionRate;
        this.lifetime = lifetime;
        this.angularVelocity = angularVelocity;
        this.initialSize = initialSize;
        this.finalSize = finalSize;
        this.initialOpacity = initialOpacity;
        this.finalOpacity = finalOpacity;
        this.bgImage = bgImage;
    }
    
    public void act() 
    {
        super.act();
        
        if (timeUntilNewParticle < 0.0)
        {
            Particle newParticle = new Particle(this, bgImage);
            
            getSimulationWorld().addObject(newParticle, getX(), getY());
            
            timeUntilNewParticle += 1.0f / emissionRate;
        }
    }    
    
    public double getLifeTime()
    {
        return lifetime;
    }
    
    public double getAngularVelocity()
    {
        return angularVelocity;
    }
    
    public double getOpacity(double t)
    {
        return lerp(initialOpacity, finalOpacity, t);
    }

    public double getSize(double t)
    {
        return lerp(initialSize, finalSize, t);
    }

    public double lerp(double minValue, double maxValue, double t)
    {
        return minValue + t * (maxValue - minValue);
    }

}
