package com.evanpthompson.address;
	
import java.io.IOException;

import com.evanpthompson.address.view.WebAppController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class MainApp extends Application {
	
	private Stage primaryStage;
	private AnchorPane displayOut;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;

	        
			
			AnchorPane root = new AnchorPane();
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			showDisplayOut();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showDisplayOut() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/DisplayOut.fxml"));
            displayOut = (AnchorPane) loader.load();
            
            WebAppController controller = loader.getController();
            

            // Show the scene containing the root layout.
            Scene scene = new Scene(displayOut);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public Stage getPrimaryStage() {
        return primaryStage;
    }
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
