module com.youmuu {
    requires javafx.controls;
    requires org.jsoup;
    exports com.youmuu;
    requires javafx.fxml;
    exports com.youmuu.controller;
    opens com.youmuu.controller to javafx.fxml;
    opens com.youmuu.core.util to javafx.base;
}