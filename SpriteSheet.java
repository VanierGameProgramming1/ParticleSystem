import greenfoot.*;
import java.awt.*; 
import java.awt.image.*; 
import java.io.File;
import javax.imageio.ImageIO;

public class SpriteSheet {
    private BufferedImage spriteSheet;
    private int rows;
    private int columns;

    public SpriteSheet(String filename, int rows, int columns) {
        File input = new File(filename);
        if (input.canRead() == false)
        {
            input = new File("images/" + filename);
        }
        
        try {
            spriteSheet = ImageIO.read(input);            
        } catch (Exception e) {
            System.err.println("Can't read spritesheet: " + filename);
        }
        
        this.rows = rows;
        this.columns = columns;
    }
    
    public int getRows()
    {
        return rows;
    }
    
    public int getColumns()
    {
        return columns;
    }
    
    public GreenfootImage getSprite(int row, int column)
    {
        BufferedImage spriteImg = getSpriteImage(row, column);
        GreenfootImage sprite = new GreenfootImage(spriteImg.getWidth(), spriteImg.getHeight());

        Graphics2D graphics = (Graphics2D) sprite.getAwtImage().getGraphics();
        graphics.drawImage(spriteImg, null, 0, 0);
        graphics.dispose();
        
        return sprite;
    }
    
    private BufferedImage getSpriteImage(int row, int column)
    {
        int spriteWidth = spriteSheet.getWidth() / columns;
        int spriteHeight = spriteSheet.getHeight() / rows;
        
        return spriteSheet.getSubimage(column * spriteWidth, row * spriteHeight,
                                       spriteWidth, spriteHeight);
    }    
    
}
