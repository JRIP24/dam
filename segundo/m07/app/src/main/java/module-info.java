module org.github.ronald.app {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.github.ronald.app to javafx.fxml;
    exports org.github.ronald.app;
}