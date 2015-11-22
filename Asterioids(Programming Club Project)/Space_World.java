import greenfoot.*;

/**
 * Write a description of class Space_World here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space_World extends World
{
    int counter = 0;
    Score score;
    
    /**
     * Constructor for objects of class Space_World.
     * 
     */
    public Space_World()
    {    
        super(600, 600, 1, false); 
        Ship ship = new Ship();
        addObject(ship, getWidth()/2, getHeight()/2);
        
        score = new Score();
        addObject(score, 45, 15);
    }
    
    public void act()
    {
        counter++;
        if(counter >= 150)
        {
            Asteroid asteroid = new Asteroid();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(asteroid, x, y);
            counter = 0;
        }
    }
}
