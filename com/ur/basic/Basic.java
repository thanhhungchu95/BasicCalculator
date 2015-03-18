package com.ur.basic;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.ur.common.Common;
import com.ur.main.Calc;
import com.ur.error.Error;

public class Basic implements ActionListener {
	// Number Button
	private JButton oneKey = new JButton("1");
	private JButton twoKey = new JButton("2");
	private JButton threeKey = new JButton("3");
	private JButton fourKey = new JButton("4");
	private JButton fiveKey = new JButton("5");
	private JButton sixKey = new JButton("6");
	private JButton sevenKey = new JButton("7");
	private JButton eightKey = new JButton("8");
	private JButton nineKey = new JButton("9");
	private JButton zeroKey = new JButton("0");
	
	// Function Button
	private JButton addKey = new JButton("+");
	private JButton subtractKey = new JButton("-");
	private JButton multipleKey = new JButton("*");
	private JButton divideKey = new JButton("/");
	private JButton equalKey = new JButton("=");
	private JButton dotKey = new JButton(".");
	
	// Panel
	private JPanel basicPanel = new JPanel();
	
	public Basic() {
		// Create Panel 4 x 4
		basicPanel.setLayout(new GridLayout(4, 4));
		
		// Add button
		basicPanel.add(sevenKey);
		basicPanel.add(eightKey);
		basicPanel.add(nineKey);
		basicPanel.add(divideKey);
		
		basicPanel.add(fourKey);
		basicPanel.add(fiveKey);
		basicPanel.add(sixKey);
		basicPanel.add(multipleKey);
		
		basicPanel.add(oneKey);
		basicPanel.add(twoKey);
		basicPanel.add(threeKey);
		basicPanel.add(subtractKey);
		
		basicPanel.add(zeroKey);
		basicPanel.add(dotKey);
		basicPanel.add(equalKey);
		basicPanel.add(addKey);
		
		// Set title
		basicPanel.setBorder(new TitledBorder("Basic"));
		
		// run private functions
		this.addAL();
	}
	
	public JPanel getBasicPanel() {
		return this.basicPanel;
	}
	
	// Add action for button
	private void addAL() {
		oneKey.addActionListener(this);
		twoKey.addActionListener(this);
		threeKey.addActionListener(this);
		fourKey.addActionListener(this);
		fiveKey.addActionListener(this);
		sixKey.addActionListener(this);
		sevenKey.addActionListener(this);
		eightKey.addActionListener(this);
		nineKey.addActionListener(this);
		zeroKey.addActionListener(this);
		
		addKey.addActionListener(this);
		subtractKey.addActionListener(this);
		multipleKey.addActionListener(this);
		divideKey.addActionListener(this);
		equalKey.addActionListener(this);
		dotKey.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Number and dot
		if (e.getSource() == oneKey) {
			if (Common.getText() == "0") Common.setText("1");
			else Common.setText(Common.getText() + "1");
			Calc.showResult();
			if (Error.getErrorField() != "No Error") Error.setErrorField("No error");
		}
		
		if (e.getSource() == twoKey) {
			if (Common.getText() == "0") Common.setText("2");
			else Common.setText(Common.getText() + "2");
			Calc.showResult();
			if (Error.getErrorField() != "No Error") Error.setErrorField("No error");
		}
		
		if (e.getSource() == threeKey) {
			if (Common.getText() == "0") Common.setText("3");
			else Common.setText(Common.getText() + "3");
			Calc.showResult();
			if (Error.getErrorField() != "No Error") Error.setErrorField("No error");
		}
		
		if (e.getSource() == fourKey) {
			if (Common.getText() == "0") Common.setText("4");
			else Common.setText(Common.getText() + "4");
			Calc.showResult();
			if (Error.getErrorField() != "No Error") Error.setErrorField("No error");
		}
		
		if (e.getSource() == fiveKey) {
			if (Common.getText() == "0") Common.setText("5");
			else Common.setText(Common.getText() + "5");
			Calc.showResult();
			if (Error.getErrorField() != "No Error") Error.setErrorField("No error");
		}
		
		if (e.getSource() == sixKey) {
			if (Common.getText() == "0") Common.setText("6");
			else Common.setText(Common.getText() + "6");
			Calc.showResult();
			if (Error.getErrorField() != "No Error") Error.setErrorField("No error");
		}
		
		if (e.getSource() == sevenKey) {
			if (Common.getText() == "0") Common.setText("7");
			else Common.setText(Common.getText() + "7");
			Calc.showResult();
			if (Error.getErrorField() != "No Error") Error.setErrorField("No error");
		}
		
		if (e.getSource() == eightKey) {
			if (Common.getText() == "0") Common.setText("8");
			else Common.setText(Common.getText() + "8");
			Calc.showResult();
			if (Error.getErrorField() != "No Error") Error.setErrorField("No error");
		}
		
		if (e.getSource() == nineKey) {
			if (Common.getText() == "0") Common.setText("9");
			else Common.setText(Common.getText() + "9");
			Calc.showResult();
			if (Error.getErrorField() != "No Error") Error.setErrorField("No error");
		}
		
		if (e.getSource() == zeroKey) {
			if (Common.getText() != "0") Common.setText(Common.getText() + "0");
			Calc.showResult();
			if (Error.getErrorField() != "No Error") Error.setErrorField("No error");
		}
		
		if (e.getSource() == dotKey) {
			boolean hasDot = false;
			for (int i = 0; i < Common.getText().length(); i++) {
				if (Common.getText().charAt(i) == '.') {
					Error.setErrorField("Syntas error");
					hasDot = true;
					break;
				}
			}
			if (!hasDot) {
				Common.setText(Common.getText() + ".");
			}
			Calc.showResult();
		}
		///////////////////////////////////////////////////////////////////
		
		// Other
		if (e.getSource() == addKey) {
			double _temp = Double.parseDouble(Common.getText());
			if (Common.state == 0) {
				Common.state = 1;
				Common.setText("0");
			}
			else {
				_temp = Common.func2var(_temp);
			}
			Common.setTemp(_temp);
			Common.setText(_temp);
			Calc.showResult();
			Common.setText("0");
			Common.state = 1;
		}
		
		if (e.getSource() == subtractKey) {
			double _temp = Double.parseDouble(Common.getText());
			if (Common.state == 0) {
				Common.state = 2;
				Common.setText("0");
			}
			else {
				_temp = Common.func2var(_temp);
			}
			Common.setTemp(_temp);
			Common.setText(_temp);
			Calc.showResult();
			Common.setText("0");
			Common.state = 2;
		}
		
		if (e.getSource() == multipleKey) {
			double _temp = Double.parseDouble(Common.getText());
			if (Common.state == 0) {
				Common.state = 3;
				Common.setText("0");
			}
			else {
				_temp = Common.func2var(_temp);
			}
			Common.setTemp(_temp);
			Common.setText(_temp);
			Calc.showResult();
			Common.setText("0");
			Common.state = 3;
		}
		
		if (e.getSource() == divideKey) {
			double _temp = Double.parseDouble(Common.getText());
			if (Common.state == 0) {
				Common.state = 4;
				Common.setText("0");
			}
			else {
				_temp = Common.func2var(_temp);
			}
			Common.setTemp(_temp);
			Common.setText(_temp);
			Calc.showResult();
			Common.setText("0");
			Common.state = 4;
		}
		
		if (e.getSource() == equalKey) {
			double _temp = Double.parseDouble(Common.getText());
			if (Common.state != 0)
				_temp = Common.func2var(_temp);
			Common.setTemp(_temp);
			Common.setText(_temp);
			Calc.showResult();
			Common.setText("0");
		}
	}
}
