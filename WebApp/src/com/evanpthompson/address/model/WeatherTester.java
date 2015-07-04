package com.evanpthompson.address.model;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Test class for Weather class, works
 * 
 */

public class WeatherTester {

	public static void main(String[] args) throws IOException {
		
		Weather w = new Weather();
		
		System.out.print(w.toString());
		
	}

}
