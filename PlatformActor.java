import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class PlatformActor extends SimulationActor
{
    protected boolean onPlatform;    
    
    public PlatformActor()
    {
        super();
        onPlatform = false;
    }
    
    public PlatformActor(Point2D position, Vector2D velocity, Vector2D acceleration)
    {
        super(position, velocity, acceleration);
        onPlatform = false;
    }
    
    public void act() 
    {
        super.act();
        landOnPlatform();
    } 
    
    public void landOnPlatform()
    {
        Platform p1 = (Platform) getOneObjectAtOffset(-getRadius()/2, getRadius() + 1, Platform.class);
        Platform p2 = (Platform) getOneObjectAtOffset( getRadius()/2, getRadius() + 1, Platform.class);
        Platform p = (p1 == null) ? p2 : p1;
        
        if (p != null  && velocity.getY() <= p.getVelocity().getY())
        {
            // Update position to lie on the platform
            Point2D newPosition = new Point2D(getX(), p.getY() - p.getHeight() / 2 - getRadius());
            position = windowToWorld(newPosition);

            // Update the velocity to stop falling / match the platform for moving platform
            velocity.setY(p.getVelocity().getY());

            onPlatform = true;
        }
        else
        {
            onPlatform = false;
        }        
    }    
}
