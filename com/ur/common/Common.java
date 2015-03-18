package com.ur.common;

import com.ur.error.Error;

public abstract class Common {
	private static String text = "0";
	private static double temp = 0;
	
	public static int state = 0;
	
	private static boolean isTemp = false;
	
	public static void setText(String _text) {
		text = _text;
	}
	
	public static void setText(double value) {
		text = String.valueOf(value);
	}
	
	public static String getText() {
		return text;
	}
	
	public static void setTemp(double _temp) {
		temp = _temp;
		isTemp = true;
	}
	
	public static void setTemp(String text) {
		if (text.charAt(text.length() - 1) == '.') temp = Double.parseDouble(text + "0");
		else temp = Double.parseDouble(text);
		isTemp = true;
	}
	
	public static boolean getIsTemp() {
		return isTemp;
	}
	
	public static void resetIsTemp() {
		isTemp = false;
	}
	
	public static double getTemp() {
		return temp;
	}
	
	public static double func2var(double _temp) {
		switch (state) {
			case 1: temp += _temp; break;
			case 2: temp -= _temp; break;
			case 3: temp *= _temp; break;
			case 4: {
				if (_temp != 0) temp /= _temp;
				else Error.setErrorField("Error: divide by zero");
			} break;
			case 5: temp = Math.pow(temp, _temp); break;
			default: break;
		}
		//state = 0;
		return temp;
	}
}
