package com.ur.main;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ur.advance.Advance;
import com.ur.basic.Basic;
import com.ur.common.Common;
import com.ur.error.Error;

public class Calc extends JFrame implements ActionListener {
	private static final long serialVersionUID = 100;
	
	// Menu 
	private JMenuBar menu = new JMenuBar();
	private JMenu modeMenu = new JMenu("Mode");
	private JMenu helpMenu = new JMenu("Help");
	private JMenu fileMenu = new JMenu("File");
	private Font menuFont = new Font("Monospace", Font.BOLD, 15);
	
	// Menu File
	private JMenuItem exit = new JMenuItem("Exit");
	
	// Menu Mode
	private JMenuItem basic = new JMenuItem("Basic");
	private JMenuItem advance = new JMenuItem("Advance");
	
	// Menu Help
	private JMenuItem guide = new JMenuItem("Guide");
	private JMenuItem about = new JMenuItem("About"); 
	
	// Display
	private static JTextField field = new JTextField("0");
	private Font displayFont = new Font("SansSerif", Font.BOLD, 25);
	
	// Add advance panel
	private Advance _advance = new Advance();
	
	public Calc() {
		
		// Set up Main Frame
		this.setTitle("Calculator - build by 'You Are'");
		this.setVisible(true);
		this.setSize(370, 250);
		this.setLocation(400, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add menu and display
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.add(menu, "North");
		panel.add(field, 1);
		this.getContentPane().add(panel, "North");
		
		// Add basic panel
		Basic _basic = new Basic();
		this.getContentPane().add(_basic.getBasicPanel(), "Center");
				
		// Add and hide advance panel
		this.getContentPane().add(_advance.getAdvancePanel(), "West");
		_advance.setAdvanceDisable();
		
		// Add error field
		Error error = new Error();
		this.add(error.getField(), "South");
		
		// Add menu and menu item
		menu.add(fileMenu);
		menu.add(modeMenu);
		menu.add(helpMenu);
		
		fileMenu.add(exit);
		
		modeMenu.add(basic);
		modeMenu.add(advance);
		
		helpMenu.add(guide);
		helpMenu.add(about);
		
		// Set font for display
		field.setFont(displayFont);
		
		// Set font for menu
		fileMenu.setFont(menuFont);
		modeMenu.setFont(menuFont);
		helpMenu.setFont(menuFont);
		exit.setFont(menuFont);
		basic.setFont(menuFont);
		advance.setFont(menuFont);
		guide.setFont(menuFont);
		about.setFont(menuFont);
		
		// Set up Text Field
		field.setHorizontalAlignment(JTextField.RIGHT);
		field.setEditable(false);
		
		// Set key for menu
		fileMenu.setMnemonic(KeyEvent.VK_F);
		modeMenu.setMnemonic(KeyEvent.VK_M);
		helpMenu.setMnemonic(KeyEvent.VK_H);
		
		exit.setMnemonic(KeyEvent.VK_E);
		
		basic.setMnemonic(KeyEvent.VK_B);
		advance.setMnemonic(KeyEvent.VK_A);
		
		guide.setMnemonic(KeyEvent.VK_G);
		about.setMnemonic(KeyEvent.VK_T);
		
		// Add action
		exit.addActionListener(this);
		basic.addActionListener(this);
		advance.addActionListener(this);
		guide.addActionListener(this);
		about.addActionListener(this);
	}
	
	public static void main(String[] args) {
		Calc c = new Calc();
		c.setResizable(false);
		Common.setTemp(0);
	}
	
	public static String getField() {
		return field.getText();
	}
	
	public static void setField(String text) {
		field.setText(text);
	}
	
	public static void showResult() {
		field.setText(Common.getText());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {
			System.exit(0);
		}
		
		if (e.getSource() == basic) {
			_advance.setAdvanceDisable();
		}
		
		if (e.getSource() == advance) {
			_advance.setAdvanceEnable();
		}
		
		if (e.getSource() == guide) {
			JOptionPane.showMessageDialog(
					this, 
					"Click buttons by mouse.",
					"How to use",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
		if (e.getSource() == about) {
			JOptionPane.showMessageDialog(
					this,
					"Basic Calculator ver 2.2\nBuild by 'You Are' - GOS",
					"About", 
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
