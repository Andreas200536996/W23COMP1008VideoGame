package com.example.w23comp1008videogame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {
    //protected variables can be accessed by any class in the family
    //for example the ship class is a child of the sprite class
    protected int posX, posY, imageWidth, imageHeight, speed;
    private Image image;

    private boolean alive;

    public Sprite(int posX, int posY, int imageWidth, int imageHeight, int speed, Image image) {
        setPosX(posX);
        setPosY(posY);
        setImageWidth(imageWidth);
        setImageHeight(imageHeight);
        setSpeed(speed);
        this.image = image;
        alive = true;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        if(posX>=0 && posX <=1000)
            this.posX = posX;
        else
            throw new IllegalArgumentException("posX must be in the range of 0-1000");
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }


    public void draw(GraphicsContext gc) {
        gc.drawImage(image, posX, posY, imageWidth, imageHeight);
    }

    public boolean collidesWith(Sprite sprite)
    {
        //100 + 50 = 150 > 130   true                    100        130+30 = 160  true
        return ((posX + imageWidth/2 > sprite.posX) && (posX < sprite.posX + sprite.imageWidth/2) &&
                (posY + imageHeight/2 > sprite.posY) && (posY < sprite.posY + sprite.imageHeight/2));
        //100 + 50 = 150 > 110 true   &&             100 < 110+30=140   true
    }
}
