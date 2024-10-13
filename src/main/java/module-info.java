module es.ieslosmontecillos.democirculo {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.democirculo to javafx.fxml;
    exports es.ieslosmontecillos.democirculo;
}