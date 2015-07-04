package com.evanpthompson.address.view;

import com.evanpthompson.address.MainApp;
import com.evanpthompson.address.model.Weather;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


public class WebAppController {
	
	@FXML
	Label currentTemp;
	
	@FXML
	Label currentOutlook;	
	
	@FXML
	ImageView weatherIcon;
	
	@FXML
	Label firstOutlookTitle;
	
	@FXML
	Label secondOutlookTitle;
	
	@FXML
	Label thirdOutlookTitle;
	
	@FXML
	Label firstTemp;
	
	@FXML
	Label secondTemp;
	
	@FXML
	Label thirdTemp;
    

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public WebAppController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	Weather w = new Weather();
    	
    	String tempString = w.getcurrentTemp() + "° F";
    	
        // updates the datafields
    	currentTemp.setText(tempString);
    	currentOutlook.setText(w.getcurrentOutlook());
    	firstOutlookTitle.setText(w.getFirstOutlookTitle());
    	secondOutlookTitle.setText(w.getSecondOutlookTitle());
    	thirdOutlookTitle.setText(w.getThirdOutlookTitle());
    	firstTemp.setText(w.getFirstOutlook());
    	secondTemp.setText(w.getSecondOutlook());
    	thirdTemp.setText(w.getThirdOutlook());
    	weatherIcon = w.getCurrentConditionIcon();
    	weatherIcon.setFitWidth(75);
    	weatherIcon.setPreserveRatio(true);
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        
        
    }
	
}


    
