module com.mycompany.biblioteca1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.biblioteca1 to javafx.fxml;
    exports com.mycompany.biblioteca1;
}
