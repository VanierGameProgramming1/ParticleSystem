import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class CannonBallAvatar extends CannonBall
{
    final static double JUMP_VELOCITY = 6.5;
    final static double WALK_TARGET_VELOCITY = 5.0;
    final static double MOVE_ACCELERATION = 6.0;
    
    public void act() 
    {
        super.act();
        controlAvatar();
        updateAvatarFeedback();
    }    
    
    public void updateAvatarFeedback()
    {
        if (feedback == null)
        {
            feedback = new AvatarFeedback(this);
            getWorld().addObject(feedback, 0, 0);
        }
        
        if (onPlatform)
        {
            feedback.setFeedback("");
        }
        else
        {
            feedback.setFeedback("Yippee!!!");            
        }
    }

    
    public void controlAvatar()
    {
        double dt = getSimulationWorld().getTimeStepDuration();
        
        if (Greenfoot.isKeyDown("d"))
        {
            velocity.setX(Math.min(velocity.getX() + MOVE_ACCELERATION * dt, WALK_TARGET_VELOCITY));
        }
        
        if (Greenfoot.isKeyDown("a"))
        {
            velocity.setX(Math.max(velocity.getX() - MOVE_ACCELERATION * dt, - WALK_TARGET_VELOCITY));
        }

        if (Greenfoot.isKeyDown("space") && onPlatform == true)
        {
            velocity.setY(JUMP_VELOCITY);
        }
        
    }
}
