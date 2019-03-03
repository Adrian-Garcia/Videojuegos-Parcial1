/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.awt.image.BufferedImage;

/**
 *
 * @author adria
 */
public class Assets {
    public static BufferedImage background; // to store background image
    public static BufferedImage player;     // to store the player image
    public static BufferedImage bad;        // to store the bad image
    public static BufferedImage pokeball;   // to store the pokemon image
    public static BufferedImage box;        // to store collision sprite
    public static BufferedImage gameOver;   // to store gameOver image 
    public static SoundClip bomb;           // to store the sound of fall
    public static SoundClip coin;           // to store the sound of catch
    

    /**
     * initializing the images of the game
     */
    public static void init() {
        background = ImageLoader.loadImage("/images/Background.png");
        player = ImageLoader.loadImage("/images/Squirtle.png");
        bad = ImageLoader.loadImage("/images/pikachu.png");
        pokeball = ImageLoader.loadImage("/images/pokeball.png");
        box = ImageLoader.loadImage("/images/Empty.png");
        gameOver = ImageLoader.loadImage("/images/hastaLaVistaBaby.jpg");
//        box = ImageLoader.loadImage("/images/box.png");
        bomb = new SoundClip("/sounds/Metal.wav");
        coin = new SoundClip("/sounds/Coin.wav");
    }
    
}
