package es.ieslosmontecillos.democirculo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/*
 * @author: Shangfeng Shan
 * @date:  ${date}
 * */
public class ControlCircle extends Application {

    //declara el radio de ciruclo
    private Circle circulo = new Circle(50);

    @Override
    public void start(Stage primaryStage) {
        //color de circulos
        circulo.setStroke(Color.BLACK);
        circulo.setFill(Color.WHITE);

        //los dos botones de agrandar y reducir
        Button btnAgrandar = new Button("Agrandar");
        Button btnReducir = new Button("Reducir");

        //añadimos manejadores de eventos usando clases anidadas
        btnAgrandar.setOnAction(new EnlargeHandler());
        btnReducir.setOnAction(new ShrinkHandler());

        //estilo de los dos botones
        HBox hbox = new HBox(20); //espacio entre los botones
        hbox.getChildren().addAll(btnAgrandar, btnReducir);
        hbox.centerShapeProperty();


        //crear un borderPane y posicionar los elementos
        BorderPane pane = new BorderPane();
        pane.setCenter(circulo);
        pane.setBottom(hbox);
        //configurar la escena y mostrar la ventana
        Scene scene = new Scene(pane, 600, 500);
        primaryStage.setTitle("Control Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //clase anidada para agrandar el círculo
    class EnlargeHandler implements javafx.event.EventHandler<javafx.event.ActionEvent> {
        @Override
        public void handle(javafx.event.ActionEvent e) {
            circulo.setRadius(circulo.getRadius() + 10);  //aumenta el radio en 10 unidades
        }
    }

    //clase anidada para reducir el círculo
    class ShrinkHandler implements javafx.event.EventHandler<javafx.event.ActionEvent> {
        @Override
        public void handle(javafx.event.ActionEvent e) {
            if (circulo.getRadius() > 10) {  //evitar que el círculo desaparezca
                circulo.setRadius(circulo.getRadius() - 10);  //reduce
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
