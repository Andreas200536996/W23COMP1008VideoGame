package com.example.w23comp1008videogame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Alien extends Sprite{
    /**
     *
     * @param posX
     * @param posY
     */
    public Alien(int posX, int posY) {
        super(posX, posY, 60, 60, 1,
                new Image(Alien.class.getResourceAsStream("images/alien.png")));
    }

    private void moveLeft()
    {
        posX -= speed;

        if (posX < 0)
            posX=1000;
    }

    public void draw(GraphicsContext gc)
    {
        super.draw(gc);
        moveLeft();
    }
}
