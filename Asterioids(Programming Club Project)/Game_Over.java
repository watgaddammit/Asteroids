import greenfoot.*;
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class Game_Over here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game_Over extends Actor
{
   public Game_Over()
   {
       GreenfootImage img = new GreenfootImage(350, 50);
              
       img.setColor(Color.lightGray);
       Font fnt = new Font("Bodoni MT Black", Font.PLAIN, 60);
       img.setFont(fnt);
       img.drawString("Game Over", 20, 45);
       setImage(img);
   }
}
