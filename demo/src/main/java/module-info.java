module JavaFXApplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires javafx.base;
    requires java.sql;

    opens batalha_naval to javafx.fxml;
    opens batalha_naval.controller to javafx.fxml; 
    opens batalha_naval.Model to javafx.base;
    exports batalha_naval;
}
