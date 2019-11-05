
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Skeleton extends PlatformActor
{
    protected static final SpriteSheet spriteSheet = new SpriteSheet("skeleton.png", 4, 9);
    protected static final double SPRITE_FRAMES_DURATION = 0.1;
    protected static final double SKELETON_VELOCITY = 1.6;
    protected int currentRow;
    protected int currentColumn;
    protected double currentFrameTime;
    
    public Skeleton()
    {
        super(null, new Vector2D(0,0), new Vector2D(0, GRAVITY));
        currentRow = 2;
        currentColumn = 0;
        currentFrameTime = 0.0;
        
        GreenfootImage sprite = spriteSheet.getSprite(currentRow,currentColumn);
        setImage(sprite);
    }
    
    public void act() 
    {
        super.act();
        
        moveOnPlatform();
        updateFrame();
    }    
    
    public void moveOnPlatform()
    {
        if (onPlatform == true)
        {
            if (velocity.getX() == 0)
            {
                velocity.setX(SKELETON_VELOCITY);
                currentRow = 3;
            }
        }
        else
        {
            velocity.setX(-velocity.getX());
            
            if (velocity.getX() > 0.0)
            {
                currentRow = 3;
            }
            else
            {
                currentRow = 1;
            }           
        }
    }
    
    public void moveFromKeyboard()
    {
        if (Greenfoot.isKeyDown("a"))
        {
            // Moving left in the second row in the spritesheet
            currentRow = 1;
        }
        if (Greenfoot.isKeyDown("s"))
        {
            // Moving down in the second row in the spritesheet
            currentRow = 2;
        }
        if (Greenfoot.isKeyDown("d"))
        {
            // Moving left in the second row in the spritesheet
            currentRow = 3;
        }
        if (Greenfoot.isKeyDown("w"))
        {
            // Moving up in the second row in the spritesheet
            currentRow = 0;
        }
    }
    
    public void updateFrame()
    {
        currentFrameTime += getSimulationWorld().getTimeStepDuration();
        if (currentFrameTime > SPRITE_FRAMES_DURATION)
        {
            currentColumn = (currentColumn + 1) % spriteSheet.getColumns();
            currentFrameTime -= SPRITE_FRAMES_DURATION;
        }
        
        setImage(spriteSheet.getSprite(currentRow, currentColumn));
    }
}
