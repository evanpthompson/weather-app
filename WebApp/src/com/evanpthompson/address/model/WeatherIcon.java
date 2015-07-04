package com.evanpthompson.address.model;

import java.awt.*;  
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;  

import org.imgscalr.*;

/*
 * Class creates a JPanel and adds the buffered image to jpanel by way of jlabel. 
 * 
 */



@SuppressWarnings("serial") 
public class WeatherIcon { 
	
	private BufferedImage name; // name of buffered image to be added to the jlabel
	private int thumbSize;
	private int panelWidth;
	private int panelHeight;
	
	
	

	public WeatherIcon(BufferedImage name, int thumbSize, int panelWidth, int panelHeight) {
		super();
		this.name = name;
		this.thumbSize = thumbSize;
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;
	}
	
	

	public BufferedImage getImageName() {
		return name;
	}



	private void setImageName(BufferedImage name) {
		this.name = name;
	}



	public int getThumbSize() {
		return thumbSize;
	}



	private void setThumbSize(int thumbSize) {
		this.thumbSize = thumbSize;
	}



	public int getPanelWidth() {
		return panelWidth;
	}



	private void setPanelWidth(int panelWidth) {
		this.panelWidth = panelWidth;
	}



	public int getPanelHeight() {
		return panelHeight;
	}



	private void setPanelHeight(int panelHeight) {
		this.panelHeight = panelHeight;
	}



	public ImageIcon createIcon() { 
		 
		
		BufferedImage thumbnail = Scalr.resize(getImageName(), getThumbSize());

		ImageIcon icon = new ImageIcon(thumbnail);  
		return icon;
	} 


	
	 

}



