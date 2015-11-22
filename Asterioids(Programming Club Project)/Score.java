import greenfoot.*;
import java.awt.Color; 
import java.awt.Font;
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    int score = 0;
    
    public Score()
    {
        add(0);
    }
    
    public void add(int amount)
    {
        score = score + amount;
        
        GreenfootImage image = new GreenfootImage(100, 30);
        
        Color c = new Color (0, 255, 0, 175);
        image.setColor(c);
        image.fill();
        
        Font f = new Font("Arial", Font.BOLD, 12);
        image.setFont(f);
        
        image.setColor(Color.blue);
        image.drawString("Score: " + score, 10, 25);
        setImage(image);
        
    }
}
