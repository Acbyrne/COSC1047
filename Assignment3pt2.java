//COSC1047 Assignment#2 - part1 : Adam Byrne 

package javaapplication;

import javax.swing.*;
import java.io.*;

import java.awt.*;
import java.awt.event.*;

public class Assignment3pt2 extends JFrame{
    private JButton loadB = new JButton("Load");
    private JButton saveB = new JButton("Save");
   
    private JLabel lable1 = new JLabel("   What is your name?:                                      ");
    private JLabel lable2 = new JLabel("   What is your quest?:                                     ");
    private JLabel lable3 = new JLabel("   What is your favorite color?:                            ");
    private JLabel lable4 = new JLabel("   What is the capital of Assyria?:                         ");
    private JLabel lable5 = new JLabel("   What is the air-speed velocity of an unladen swallow?:   ");
    private JTextField input1 = new JTextField();
    private JTextField input2 = new JTextField();
    private JTextField input3 = new JTextField();
    private JTextField input4 = new JTextField();
    private JTextField input5 = new JTextField();
    private int fileNum = 0;
    

    public Assignment3pt2(){
    	JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(5, 1));
		inputPanel.add(input1);
		inputPanel.add(input2);
		inputPanel.add(input3);
		inputPanel.add(input4);
		inputPanel.add(input5);
        add(inputPanel, BorderLayout.CENTER);
        
    	JPanel lablePanel = new JPanel();
		lablePanel.setLayout(new GridLayout(5, 1));
		lablePanel.add(lable1);		
		lablePanel.add(lable2);
		lablePanel.add(lable3);
		lablePanel.add(lable4);
		lablePanel.add(lable5);
		add(lablePanel,BorderLayout.WEST);

    	JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 4));
        buttonPanel.add(loadB);
        buttonPanel.add(saveB);
        add(buttonPanel, BorderLayout.SOUTH);
        
    	//JPanel fillerPanel = new JPanel();
        //add(fillerPanel, BorderLayout.EAST);


        //Listeners
        saveB.addActionListener(new saveListener());
        loadB.addActionListener(new loadListener());

    }
    //main
    public static void main(String[] args) {
    	System.out.println(new File("saves.txt").getAbsoluteFile());
    	JFrame frame = new Assignment3pt2();
    	frame.setTitle("Bridge of Death");
    	frame.setLocationRelativeTo(null);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(600, 200);
    	frame.setVisible(true);
    }
    
    //Write info the the save file
    class saveListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    	
   	        FileWriter fileWriter = null;
   	        BufferedWriter bufferedWriter = null;

   	        try {
   	        	fileWriter = new FileWriter("saves.txt");
   	            bufferedWriter = new BufferedWriter(fileWriter);
   	               	            
   	            fileWriter.write(input1.getText() + "\n");
   	            fileWriter.write(input2.getText() + "\n");
   	            fileWriter.write(input3.getText() + "\n");
   	            fileWriter.write(input4.getText() + "\n");
   	            fileWriter.write(input5.getText() + "\n");

   	        		                 
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

    class loadListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    	    
    		File file = new File("saves.txt");

 	        FileReader fileReader = new FileReader(file);
 	        BufferedReader bufferedReader = new BufferedReader(fileReader);
 	      
 	        try {
 	            String line = null;
 	            while ((line = bufferedReader.readLine()) != null) {
 	            	input1.setText(""+ line);
 	            	input2.setText(""+ line);
 	            	input3.setText(""+ line);
 	            	input4.setText(""+ line);
 	            	input5.setText(""+ line);  	             	
 	            } 
 	           	                  
 	        } catch (IOException ex) {
 	            ex.printStackTrace();
 	        } finally {
 	            try {
 	             
 	                if (fileReader != null) {
 	                    fileReader.close();

 	                }
 	              
 	                if (bufferedReader != null) {
 	                    bufferedReader.close();
 	                }

 	            } catch (IOException ex) {
 	                ex.printStackTrace();
 	            }
 	        }
    	}
    }

}

  

