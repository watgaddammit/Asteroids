import greenfoot.*;

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Actor
{
    double dx;
    double dy;
    double SPEED = 0.5;
    int FIRE_SPEED = 20;
    int counter = 0;
    
    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        counter++;
        
        if(Greenfoot.isKeyDown("left") == true)
        {
            turn(-5);
        }
        else if(Greenfoot.isKeyDown("right") == true)
        {
            turn(5);
        }
        
        if(Greenfoot.isKeyDown("up") == true)
        {
            speedUp();
        }
        else if(Greenfoot.isKeyDown("down") == true)
        {
            slowDown();
        }
        
        if(counter >= FIRE_SPEED)
        { 
            if(Greenfoot.isKeyDown("space") == true)
            {
                Greenfoot.playSound("bullet.wav");
            
                Bullet bullet = new Bullet(getRotation());
                getWorld().addObject(bullet, getX(), getY());
                counter = 0;
            }
        }
        setLocation((int)(getX() + dx), (int)(getY() + dy));
        
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
        
        Actor test1 = getOneIntersectingObject(Asteroid.class);
        Actor test2 = getOneIntersectingObject(SmallAsteroid.class);
        
        if(test1 != null || test2 != null)
        {
            Greenfoot.playSound("game_over.mp3");
            Game_Over gameover = new Game_Over();
            getWorld().addObject(gameover, getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }   
    // Place these helper functions in your Ship code.  They use trigonometry
    // to break the speed and direction of the ship into separate dx and dy vectors.

    private void slowDown() {
        dx -= SPEED * Math.cos(Math.PI/180*getRotation());
        dy -= SPEED * Math.sin(Math.PI/180*getRotation());
    }

    private void speedUp() {
        dx += SPEED * Math.cos(Math.PI/180*getRotation());
        dy += SPEED * Math.sin(Math.PI/180*getRotation());        
    }
}
