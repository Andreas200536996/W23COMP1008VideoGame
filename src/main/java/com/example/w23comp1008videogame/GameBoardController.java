package com.example.w23comp1008videogame;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

import java.util.HashSet;

public class GameBoardController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button startButton;

    //This variable is used to hold the keys that the game player is pressing
    private HashSet<KeyCode> activeKeys;
    @FXML
    void startGame(ActionEvent event) {
        startButton.setVisible(false);

        //store the keys pressed in the activeKeys set
        activeKeys = new HashSet<>();
        anchorPane.getScene().setOnKeyPressed(keyPressed -> activeKeys.add(keyPressed.getCode())
        );
        anchorPane.getScene().setOnKeyReleased(keyReleased -> activeKeys.remove(keyReleased.getCode()));

        Canvas canvas = new Canvas(1000,800);

        //gc could be paintbrush or pencil to better demonstrate its purpose.
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //get Image objects
        Image background = new Image(getClass().getResourceAsStream("images/space.png"));

        //Create a sprite that we can draw on our canvas
        Ship ship = new Ship(300, 500);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.drawImage(background,0,0,canvas.getWidth(),canvas.getHeight());
                userMovesShip(ship);
                ship.draw(gc);
            }
        };
        timer.start();
        anchorPane.getChildren().add(canvas);

    }

    private void userMovesShip(Ship ship) {
        if (activeKeys.contains(KeyCode.UP))
            ship.moveUp();
        if (activeKeys.contains(KeyCode.DOWN))
            ship.moveDown();
        if (activeKeys.contains(KeyCode.LEFT))
            ship.moveLeft();
        if (activeKeys.contains(KeyCode.RIGHT))
            ship.moveRight();
        if(activeKeys.contains(KeyCode.SPACE))
            ship.shootMissile();
    }

}
