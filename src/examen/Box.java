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
public class Box extends Item{

    private int direction;
    private int width;
    private int height;
    private Game game;
    public int speed;
    public int score = 0;
    
    /**
     * Box constructor
     * @param x
     * @param y
     * @param direction
     * @param width
     * @param height
     * @param game 
     */
    public Box(int x, int y, int direction, int width, int height, Game game) {
        super(x, y);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        this.speed = 1;
    }

    /**
     * Get the direction 
     * @return an <code>integer</code> with the direction value
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Get the Height
     * @return an <code>integer</code> with the Width value
     */
    public int getWidth() {
        return width;
    }

    /**
     * Get the Height
     * @return an <code>integer</code> with the Height value
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set the Direction
     * @param direction 
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * Set the Width
     * @param width 
     */
    public void setWidth(int width) {
        this.width = width;
    }
    
    /**
     * Set the Height
     * @param height 
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Control the player movement 
     */
    @Override
    public void tick() {
        // moving player depending on flags
        if (game.getKeyManager().up) {
           setY(getY() - 9);
        }
        if (game.getKeyManager().down) {
           setY(getY() + 9);
        }
        if (game.getKeyManager().left) {
           setX(getX() - 9);
        }
        if (game.getKeyManager().right) {
           setX(getX() + 9);
        }
        if (game.getKeyManager().u) {       //Up-Left
            setY(getY() - 9);
            setX(getX() - 9);
        }
        if (game.getKeyManager().o) {       //Up-Right
            setY(getY() - 9);
            setX(getX() + 9);
        }
        if (game.getKeyManager().j) {       //Down-Left
            setY(getY() + 9);
            setX(getX() - 9);
        }
        if (game.getKeyManager().l) {       //Down-Right
            setY(getY() + 9);
            setX(getX() + 9);
        }
        
        // reset x position and y position if colision
        if (getX() + 60 >= game.getWidth()) {
            setX(game.getWidth() - 60);
        }
        else if (getX() <= -30) {
            setX(-30);
        }
        if (getY() + 80 >= game.getHeight()) {
            setY(game.getHeight() - 80);
        }
        else if (getY() <= -20) {
            setY(-20);
        }
    }
    
    /**
     * Calculates the perimeter of the player according to the Width and
     * Height of it. 
     * @return Rectangle perimeter
     */
    public Rectangle getPerimetro() {
        return new Rectangle (getX(), getY(), getWidth(), getHeight());
    }
    
    
    /**
     * Validate if there was an intersection 
     * @param obj
     * @return intersection
     */
    public boolean intersecta(Object obj) {
                                                                //Castea
        return obj instanceof Bad && getPerimetro().intersects(((Bad) obj).getPerimetro());
    }

    /**
     * render the image of the player 
     * @param g 
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.box, getX(), getY(), getWidth(), getHeight(), null);
    }
}
