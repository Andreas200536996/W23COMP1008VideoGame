package com.example.w23comp1008videogame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Ship extends Sprite {

    private ArrayList<Missile> missilesReleased;
    private final int REFRESH_RATE = 5;
    private int refreshCounter;

    /**
     * The ship image is known, so we do not need to pass that in as an argument
     * @param posX
     * @param posY
     */
    public Ship(int posX, int posY) {
        super(posX, posY, 100, 60, 4,
                new Image(Ship.class.getResourceAsStream("images/ship.png")));
        missilesReleased = new ArrayList<>();
        refreshCounter = 0;
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

    public void shootMissile()
    {
        if (refreshCounter<=0) {
            Missile newMissile = new Missile(posX + imageWidth, posY + imageHeight / 2);
            missilesReleased.add(newMissile);
            refreshCounter = REFRESH_RATE;
        }
    }


    //only release a missile every 5th time you draw the ship
    public void draw(GraphicsContext gc)
    {
        super.draw(gc);

        refreshCounter --;
        if (refreshCounter<0)
            refreshCounter = 0;

        missilesReleased.removeIf(missile -> !missile.isAlive());

        for (Missile missile : missilesReleased)
            missile.draw(gc);
    }


}
