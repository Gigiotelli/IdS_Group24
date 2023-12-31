/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.ids.project;

import it.unisa.diem.ids.project.controller.CalculatorController;
import it.unisa.diem.ids.project.view.*;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene; 
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


/**
 *
 * @author Gigi
 */
public class Main extends Application {
    
    private double xOffset = 0;
    private double yOffset = 0;
    
    CalculatorController calController;
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/View.fxml"));

        Parent root = loader.load();
        
        // inizializzo il controller per poter successivamente passare le variabili
        CalculatorController controller1 = loader.getController();
        
        Scene scene = new Scene(root);
        
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
        
        scene.setFill(Color.TRANSPARENT);
        
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent event) {
               stage.setX(event.getScreenX() - xOffset);
               stage.setY(event.getScreenY() - yOffset);
           }
        });
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
