//COSC1047 Assignment 5 - Adam Byrne
//Ticket printer

//package javaapplication;

import javax.swing.*;
import javax.swing.JFileChooser;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Assignment5 extends JFrame {
	private JButton print = new JButton("Print Ticket!");

	private JLabel lable1 = new JLabel("   Number 1                     ");
	private JLabel lable2 = new JLabel("   Number 2                     ");
	private JLabel lable3 = new JLabel("   Number 3                     ");
	private JLabel lable4 = new JLabel("   Number 4                     ");
	private JLabel lable5 = new JLabel("   Number 5                     ");
	private JLabel lable6 = new JLabel("   Number 6                     ");

	private JTextField input1 = new JTextField();
	private JTextField input2 = new JTextField();
	private JTextField input3 = new JTextField();
	private JTextField input4 = new JTextField();
	private JTextField input5 = new JTextField();
	private JTextField input6 = new JTextField();
	private boolean exception = false;

	private int fileNum = 0;

	public Assignment5() {
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(6, 1));
		inputPanel.add(input1);
		inputPanel.add(input2);
		inputPanel.add(input3);
		inputPanel.add(input4);
		inputPanel.add(input5);
		inputPanel.add(input6);
		add(inputPanel, BorderLayout.CENTER);

		JPanel lablePanel = new JPanel();
		lablePanel.setLayout(new GridLayout(6, 1));
		lablePanel.add(lable1);
		lablePanel.add(lable2);
		lablePanel.add(lable3);
		lablePanel.add(lable4);
		lablePanel.add(lable5);
		lablePanel.add(lable6);
		add(lablePanel, BorderLayout.WEST);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 4));
		buttonPanel.add(print);
		add(buttonPanel, BorderLayout.SOUTH);

		 JPanel fillerPanel = new JPanel();
		 add(fillerPanel, BorderLayout.EAST);

		// Listeners
		print.addActionListener(new printListener());

	}
	
	/** Custom Exceptions */
	public class emptyFieldsException extends Exception{
		public emptyFieldsException(String s) {
			super(s);
		}
	}
	public class invalidFileException extends Exception{
		public invalidFileException(String s) {
			super(s);
		}
	}

	// main
	public static void main(String[] args) {
		//System.out.println(new File("saves.txt").getAbsoluteFile());
		JFrame frame = new Assignment5();
		frame.setTitle("Ticket");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 200);
		frame.setVisible(true);
	}

	// Write info the the save file
	class printListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			print.setBackground(null);
			
			String in1 = input1.getText();
			String in2 = input2.getText();
			String in3 = input3.getText();
			String in4 = input4.getText();
			String in5 = input5.getText();
			String in6 = input6.getText();
			//Find unfilled fields
			try {
				
				if(in1.equals("") || in2.equals("") || 
				   in3.equals("") || in4.equals("") || 
				   in5.equals("") || in6.equals("")) {
					
					//input1
					if(in1.equals ("") || in1.equals(in2) || in1.equals(in3) || in1.equals(in4) || in2.equals(in5) || in1.equals(in6)) {
						input1.setBackground(Color.RED);
					}
					else if(in1 != ("")) {
						input1.setBackground(Color.WHITE);
					}
					//input2
					if(in2.equals("") || in2.equals(in1) || in2.equals(in3) || in2.equals(in4) || in2.equals(in5) || in2.equals(in6)) {
						input2.setBackground(Color.RED);
					}
					else if(in2 != ("")) {
						input2.setBackground(Color.WHITE);
					}
					//input3
					if(in3.equals("") || in3.equals(in2) || in3.equals(in1) || in3.equals(in4) || in3.equals(in5) || in3.equals(in6)) {
						input3.setBackground(Color.RED);
					}
					else if(in3 != ("")) {
						input3.setBackground(Color.WHITE);
					}
					//input4
					if(in4.equals("") || in4.equals(in2) || in4.equals(in3) || in4.equals(in1) || in4.equals(in5) || in4.equals(in6)) {
						input4.setBackground(Color.RED);
					}
					else if(in4 != ("")) {
						input4.setBackground(Color.WHITE);
					}
					//input 5
					if(in5.equals("") || in5.equals(in2) || in5.equals(in3) || in5.equals(in4) || in5.equals(in1) || in5.equals(in6)) {
						input5.setBackground(Color.RED);
					}
					else if(in5 != ("")) {
						input5.setBackground(Color.WHITE);
					}
					//input 6
					if(in6.equals("") || in6.equals(in2) || in6.equals(in3) || in6.equals(in4) || in6.equals(in5) || in6.equals(in1)) {
						input6.setBackground(Color.RED);
					}
					else if(in6 != ("")) {
						input6.setBackground(Color.WHITE);
					}
					throw new emptyFieldsException("Not all fields are filled");
				} 
					
			}

			catch (emptyFieldsException ex) {	
				System.out.println("All fields must be filled before printing: " + ex);	
				exception = true;
			}
				
			//Make new file and fill with text
			FileWriter fileWriter = null;
			BufferedWriter bufferedWriter = null;

			try {
				if(exception = false) {
					
				fileWriter = new FileWriter("ticket.txt");
				bufferedWriter = new BufferedWriter(fileWriter);

				fileWriter.write(in1 + "\n");
				fileWriter.write(in2 + "\n");
				fileWriter.write(in3 + "\n");
				fileWriter.write(in4 + "\n");
				fileWriter.write(in5 + "\n");
				fileWriter.write(in6 + "\n");
				}

			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				try {
					if (bufferedWriter != null) {
						bufferedWriter.close();
					}

					if (fileWriter != null) {
						fileWriter.close();
					}

				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
