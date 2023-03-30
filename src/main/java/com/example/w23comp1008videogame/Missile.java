package com.example.w23comp1008videogame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Missile extends Sprite{

    /**
     * We know the missile image, width, height and speed
     * @param posX
     * @param posY
     */
    public Missile(int posX, int posY) {
        super(posX, posY, 40, 20, 7,
                new Image(Missile.class.getResourceAsStream("images/missile.png")));
    }

    private void moveRight()
    {
        posX += speed;
    }

    public void draw(GraphicsContext gc)
    {
        super.draw(gc);
        moveRight();
    }
}
