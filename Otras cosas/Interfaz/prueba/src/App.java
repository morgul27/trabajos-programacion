import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Academia dos Devs");
        Button boton = new Button("clique aqui");
        boton.setOnAction(new EventHandler<ActionEvent>(){

            public void handle(ActionEvent event){
                System.out.println("clique no!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().addAll(boton);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}