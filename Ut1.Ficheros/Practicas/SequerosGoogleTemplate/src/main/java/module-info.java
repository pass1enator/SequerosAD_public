module ies.pedro.sequerosgoogle {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens ies.pedro.sequerosgoogle to javafx.fxml;
    exports ies.pedro.sequerosgoogle;
}