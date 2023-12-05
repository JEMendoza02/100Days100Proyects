module com.day4.day4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.day4.day4 to javafx.fxml;
    exports com.day4.day4;
}