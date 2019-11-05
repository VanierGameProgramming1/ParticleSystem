import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EnemyCannon extends Cannon
{
    protected final static double TIME_BEFORE_SHOOTING = 2.0;
    protected double timeUntilShooting;
    
    public EnemyCannon()
    {
        super();

        timeUntilShooting = TIME_BEFORE_SHOOTING;
        alignWithVector(new Vector2D(-1, 0));
        
    }
    
    public void act() 
    {
        super.act();
        alignWithVector(new Vector2D(-1, 0));
        
        double dt = getSimulationWorld().getTimeStepDuration();
        timeUntilShooting -= dt;
        
        if (timeUntilShooting < 0.0)
        {
            Vector2D ballVelocity = new Vector2D(-1 * CANNON_BALL_VELOCITY, 0.0);
            shoot(ballVelocity);
            timeUntilShooting += TIME_BEFORE_SHOOTING;
        }
            
    }    
}





