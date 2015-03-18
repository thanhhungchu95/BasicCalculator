package com.ur.error;

import java.awt.Font;

import javax.swing.JTextField;

public class Error {
	private static JTextField errorField = new JTextField("No error");
	private Font errorFont = new Font("Monospace", Font.ITALIC, 15);
	
	public Error() {
		errorField.setEditable(false);
		errorField.setFont(errorFont);
	}
	
	public JTextField getField() {
		return errorField;
	}
	
	public static String getErrorField() {
		return errorField.getText();
	}
	
	public static void setErrorField(String _text) {
		errorField.setText(_text);
	}
}
