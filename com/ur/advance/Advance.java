package com.ur.advance;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.ur.common.Common;
import com.ur.main.Calc;
import com.ur.error.Error;

public class Advance implements ActionListener {
	// Trigonometry Button
	private JButton sinKey = new JButton("sin");
	private JButton cosKey = new JButton("cos");
	private JButton tanKey = new JButton("tan");
	
	// Power Button
	private JButton squareKey = new JButton("x^2");
	private JButton powKey = new JButton("x^n");
	private JButton squareRootKey = new JButton("sqrt");
	private JButton inverseKey = new JButton("1/x");
	
	// Other Button
	private JButton signumKey = new JButton("+/-");
	private JButton percenKey = new JButton("%");
	private JButton delKey = new JButton("DEL");
	private JButton piKey = new JButton("PI");
	private JButton clearKey = new JButton("AC");
	
	// Panel
	private JPanel advancePanel = new JPanel();
	
	public Advance() {
		// Create Panel 4 x 3
		advancePanel.setLayout(new GridLayout(4, 3));
		
		// Add Button
		advancePanel.add(sinKey);
		advancePanel.add(cosKey);
		advancePanel.add(tanKey);
		
		advancePanel.add(squareKey);
		advancePanel.add(powKey);
		advancePanel.add(inverseKey);
		
		advancePanel.add(signumKey);
		advancePanel.add(percenKey);
		advancePanel.add(delKey);
		
		advancePanel.add(squareRootKey);
		advancePanel.add(piKey);
		advancePanel.add(clearKey);
		
		// Set title
		advancePanel.setBorder(new TitledBorder("Advance"));
		
		// Run private functions
		this.addAL();
	}
	
	public JPanel getAdvancePanel() {
		return this.advancePanel;
	}
	
	// Add action for button
	private void addAL() {
		sinKey.addActionListener(this);
		cosKey.addActionListener(this);
		tanKey.addActionListener(this);
		
		squareKey.addActionListener(this);
		powKey.addActionListener(this);
		inverseKey.addActionListener(this);
		squareRootKey.addActionListener(this);
		
		percenKey.addActionListener(this);
		delKey.addActionListener(this);
		signumKey.addActionListener(this);
		piKey.addActionListener(this);
		clearKey.addActionListener(this);
	}
	
	public void setAdvanceEnable() {
		advancePanel.setVisible(true);
	}
	
	public void setAdvanceDisable() {
		advancePanel.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Eraser
		if (e.getSource() == delKey) {
			if (Common.getText().length() == 1) Common.setText("0");
			else Common.setText(Common.getText().substring(0, Common.getText().length() - 1));
			Calc.showResult();
		}
		
		if (e.getSource() == clearKey) {
			Common.setText("0");
			Common.setTemp(0);
			Calc.showResult();
			Common.resetIsTemp();
			Common.state = 0;
		}
		
		//////////////////////////////////////
		
		// Trigonometry 
		if (e.getSource() == sinKey) {
			if (Common.getText() != "0") 
				Common.setTemp(Common.getText());
			double _temp = Common.getTemp();
			_temp = Math.sin(_temp * Math.PI / 180);
			Common.setTemp(_temp);
			Common.setText(_temp);
			Calc.showResult();
			Common.setText("0");
		}
		
		if (e.getSource() == cosKey) {
			if (Common.getText() != "0") 
				Common.setTemp(Common.getText());
			double _temp = Common.getTemp();
			_temp = Math.cos(_temp * Math.PI / 180);
			Common.setTemp(_temp);
			Common.setText(_temp);
			Calc.showResult();
			Common.setText("0");
		}
		
		if (e.getSource() == tanKey) {
			if (Common.getText() != "0") 
				Common.setTemp(Common.getText());
			double _temp = Common.getTemp();
			if ((int)_temp % 90 == 0 && (int)_temp / 90 != 2) 
				Error.setErrorField("Error: parameter is invalid");
			else _temp = Math.tan(_temp * Math.PI / 180);
			Common.setTemp(_temp);
			Common.setText(_temp);
			Calc.showResult();
			Common.setText("0");
		}
		
		//////////////////////////////////////
		
		// Power 
		if (e.getSource() == squareKey) {
			if (Common.getText() != "0") 
				Common.setTemp(Common.getText());
			double _temp = Common.getTemp();
			_temp *= _temp;
			Common.setTemp(_temp);
			Common.setText(_temp);
			Calc.showResult();
			Common.setText("0");
		}
		
		if (e.getSource() == squareRootKey) {
			if (Common.getText() != "0") 
				Common.setTemp(Common.getText());
			double _temp = Common.getTemp();
			if (_temp >= 0) _temp = Math.sqrt(_temp);
			else Error.setErrorField("Error: can't be the square root of negative");
			Common.setTemp(_temp);
			Common.setText(_temp);
			Calc.showResult();
			Common.setText("0");
		}
		
		if (e.getSource() == inverseKey) {
			if (Common.getText() != "0") 
				Common.setTemp(Common.getText());
			double _temp = Common.getTemp();
			if (_temp != 0) _temp = 1 / _temp;
			else Error.setErrorField("Error: divide by zero");
			Common.setTemp(_temp);
			Common.setText(_temp);
			Calc.showResult();
			Common.setText("0");
		}
		
		if (e.getSource() == powKey) {
			double _temp = Double.parseDouble(Common.getText());
			if (Common.state == 0) {
				Common.state = 5;
				Common.setText("0");
			}
			else {
				_temp = Common.func2var(_temp);
			}
			Common.setTemp(_temp);
			Common.setText(_temp);
			Calc.showResult();
			Common.setText("0");
			Common.state = 5;
		}
		
		/////////////////////////////////////////
		
		// Other
		if (e.getSource() == piKey) {
			Common.setTemp(Math.PI);
			Common.setText(Math.PI);
			Calc.showResult();
			Common.setText("0");
		}
		
		if (e.getSource() == percenKey) {
			if (Common.getText() != "0") 
				Common.setTemp(Common.getText());
			double _temp = Common.getTemp();
			_temp /= 100;
			Common.setTemp(_temp);
			Common.setText(_temp);
			Calc.showResult();
			Common.setText("0");
		}
		
		if (e.getSource() == signumKey) {
			if (Common.getText() != "0") 
				Common.setTemp(Common.getText());
			double _temp = Common.getTemp();
			_temp = -(_temp);
			Common.setTemp(_temp);
			Common.setText(_temp);
			Calc.showResult();
			Common.setText("0");
		}
	}
}
