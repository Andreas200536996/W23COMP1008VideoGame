package com.example.w23comp1008videogame;

import javafx.scene.image.Image;

public class Ship extends Sprite {

    /**
     * The ship image is known, so we do not need to pass that in as an argument
     * @param posX
     * @param posY
     */
    public Ship(int posX, int posY) {
        super(posX, posY, 100, 60, 7,
                new Image(Ship.class.getResourceAsStream("images/ship.png")));
    }

    public void moveRight()
    {
        int furthestRight = 1000-imageWidth;
        posX += speed;

        if (posX > furthestRight)
            posX = furthestRight;

    }

    public void moveLeft()
    {
        posX -= speed;

        if (posX<0)
            posX = 0;
    }

    public void moveUp(){
        posY -= speed;

        if (posY < 0)
            posY = 0;
    }

    public void moveDown() {
        int furthestDown = 800-imageHeight;
        posY += speed;

        if (posY > furthestDown)
            posY = furthestDown;
    }
}
