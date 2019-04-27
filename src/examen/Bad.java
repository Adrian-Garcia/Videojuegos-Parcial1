/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author adria
 */
public class Bad extends Item{

    private int width;
    private int height;
    private Game game;
    private int speed = 3;
    public boolean floor = false;
    private boolean side = false;
    private boolean direction;
    
    /**
     * Bad constructor
     * @param x
     * @param y
     * @param direction
     * @param width
     * @param height
     * @param game 
     */
    public Bad(int x, int y, int direction, int width, int height, boolean side, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        this.side = side;
        this.direction = true;
    }

    /**
     * Getter of width
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Getter of Height
     * @return height
     */
    public int getHeight() {
        return height;
    }
    
    public boolean getSide() {
        return side;
    }
    
    /**
     * Getter of Speed
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }
    
    /**
     * Getter of direction
     * @return direction
     */
    public boolean getDirection() {
        return direction;
    }
    
    /**
     * Setter of direction
     * @param direction 
     */
    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    /**
     * Setter of Width
     * @param width 
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Setter of Height
     * @param height 
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    /**
     * Setter of speed
     * @param speed 
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Control bad movement
     */
    @Override
    public void tick() {
        
        //Goes to the right if it is not in the screen
        if (getX() <= -10) {
            setX(getX() + 3);
        }
        
        //If it arrives to the screen, ten it cahnge its course
        else {
            
            //Calculate ranom number
            int azar = (int) (Math.random() * (5) + 2);
            int sideAzar = azar;
            
            //Decide the direction (up or down)
            if (getSide() == false) {
               sideAzar *= -1;
            }
            
            //Moves
            setX(getX() + azar);
            setY(getY() + sideAzar);

            // reset x position and y position if colision
            if (getX() + 60 >= game.getWidth()) {                   //Right
                setX(game.getWidth() - 60);
                floor = true;
            }
            if (getY() + 80 >= game.getHeight()) {                  //Down
                setY(game.getHeight() - 80);
                floor = true;
            }
            else if (getY() <= -20) {                               // Up
                setY(-20);
                floor = true;
            }
        }
    }
    
    /**
     * Get perimeter of bad for collisions
     * @return 
     */
    public Rectangle getPerimetro() {
        return new Rectangle (getX(), getY(), getWidth(), getHeight()-30);
    }
    
    /**
     * Render the image of bad (A Pokeball)
     * @param g 
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.pokeball, getX(), getY(), getWidth(), getHeight(), null);
    }
}
