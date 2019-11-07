import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ParticleEmitter extends SimulationActor
{
    SimulationActor parent;
    protected double timeUntilNewParticle = 0.0;
    protected double emissionRate;
    protected double lifetime;
    protected double angularVelocity;
    protected double initialSize, finalSize;
    protected double initialOpacity, finalOpacity;
    protected Vector2D initialVelocity;
    protected double initialVelocityVariation;
    
    protected GreenfootImage bgImage;
    
    public ParticleEmitter( SimulationActor parent, double emissionRate, double lifetime, Vector2D initialVelocity, double initialVelocityVariation, 
                            double angularVelocity, double initialSize, double finalSize, double initialOpacity, double finalOpacity, 
                            GreenfootImage bgImage)
    {
        this.parent = parent;
        this.emissionRate = emissionRate;
        this.lifetime = lifetime;
        this.initialVelocity = initialVelocity;
        this.initialVelocityVariation = initialVelocityVariation;
        this.angularVelocity = angularVelocity;
        this.initialSize = initialSize;
        this.finalSize = finalSize;
        this.initialOpacity = initialOpacity;
        this.finalOpacity = finalOpacity;
        this.bgImage = bgImage;

        setImage((GreenfootImage)null);
    }
    
    public void act() 
    {
        super.act();
        
        timeUntilNewParticle -= getSimulationWorld().getTimeStepDuration();
        
        if (timeUntilNewParticle < 0.0)
        {
            Particle newParticle = new Particle(this, bgImage);
            Vector2D vel = new Vector2D(initialVelocity.getX() + (Math.random() - 0.5) * initialVelocityVariation,
                                        initialVelocity.getY() + (Math.random() - 0.5) * initialVelocityVariation);
            newParticle.setVelocity(vel);
            
            if (parent!=null)
            {
                getSimulationWorld().addObject(newParticle, parent.getX(), parent.getY());                
            }
            else
            {
                getSimulationWorld().addObject(newParticle, getX(), getY());
            }
            
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
        return (1.0 - t) * minValue + t * maxValue;
    }

}
