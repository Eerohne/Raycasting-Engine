/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Editor.View.Menu.Entity;

import Editor.Controller.SignalController;
import Editor.Model.SignalModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author linuo
 */
public class SignalStage{

    public SignalStage(Stage stage) {
        Stage newSignal = new Stage();
        newSignal.initOwner(stage);
        newSignal.initModality(Modality.WINDOW_MODAL);
        
        SignalView sv = new SignalView();
        SignalController sc = new SignalController(new SignalModel(), sv);
        
        Scene s = new Scene(sv, 500, 300);
        newSignal.setTitle("create signal");
        newSignal.setScene(s);
        newSignal.show();
        
    }

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        Stage newSignal = new Stage();
//        newSignal.initOwner(primaryStage);
//        newSignal.initModality(Modality.WINDOW_MODAL);
//        
//        SignalView sv = new SignalView();
//        SignalController sc = new SignalController(new SignalModel(), sv);
//        
//        Scene s = new Scene(sv, 500, 300);
//        newSignal.setTitle("create signal");
//        newSignal.setScene(s);
//        newSignal.show();
//    }
//    
//    public static void main(String [] args){
//        launch(args);
//    }
    
}