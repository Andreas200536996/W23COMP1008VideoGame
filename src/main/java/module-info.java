module com.example.w23comp1008videogame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.w23comp1008videogame to javafx.fxml;
    exports com.example.w23comp1008videogame;
}