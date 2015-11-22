import greenfoot.*;

/**
 * Write a description of class SmallAsteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SmallAsteroid extends Actor
{
     int SPEED = 2;
    
    public SmallAsteroid()
    {
        int angle = Greenfoot.getRandomNumber(360);
        setRotation(angle);
    }
        
    
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(SPEED);
        
        if(getX() < 0)
        {
            setLocation(getWorld().getWidth(), getY());
        }
        if(getX() > getWorld().getWidth())
        {
            setLocation(0, getY());
        }
        
        if(getY() < 0)
        {
            setLocation(getX(), getWorld().getHeight());
        }
        if(getY() > getWorld().getWidth())
        {
            setLocation(getX(), 0);
        }
        
        Actor bullet = getOneIntersectingObject(Bullet.class);
        if(bullet != null)
        {
            Greenfoot.playSound("explosion.wav");
            getWorld().removeObject(bullet);
            ((Space_World)(getWorld())).score.add(100);
            getWorld().removeObject(this);
        }
    }    
}
