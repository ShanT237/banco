module project.co {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens project.co to javafx.fxml;
    opens project.co.GUI to javafx.fxml;
    exports project.co;
    exports project.co.GUI;
    
}
