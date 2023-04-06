package com.example.w23comp1008videogame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Explosion extends Sprite{
    private final int REFRESH_RATE = 5;
    private int delayCount;
    private int[] spriteStartX;
    private int explosionIndex;
    public Explosion(int posX, int posY) {
        super(posX, posY, 100, 100, 0, new Image(Explosion.class.getResourceAsStream("images/explosion.png")));
        spriteStartX = new int[]{0,170,330,520,710};
        explosionIndex = 0;
        delayCount = REFRESH_RATE;
    }

    public void draw(GraphicsContext gc)
    {
        if (delayCount-- < 0) {
            explosionIndex++;
            delayCount = REFRESH_RATE;
        }
        if(explosionIndex<spriteStartX.length)
            setAlive(false);
        //spriteStartX[explosionIndex] - the starting X coordinate of our cropped image
        //0 = starting y coordinate of our crop
        //sw and sh = width & height of the crop
        if (isAlive())
            gc.drawImage(getImage(), spriteStartX[explosionIndex], 0, 184, 368, posX, posY, imageWidth, imageHeight);





    }

}
