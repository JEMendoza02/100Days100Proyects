module com.day3.day3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.day3.conversor to javafx.fxml;
    exports com.day3.conversor;
}