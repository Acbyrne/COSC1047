
package javaapplication;

import java.io.*;

class Assignment3pt1 {

	 public static void main(String[] args) throws IOException{
	        File file = new File("input.txt");

	        FileReader fileReader = new FileReader(file);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        FileWriter fileWriter = null;
	        BufferedWriter bufferedWriter = null;

	        try {
	        	fileWriter = new FileWriter("output.txt");
	            bufferedWriter = new BufferedWriter(fileWriter);
	            
	            
	            String line = null;
	            while ((line = bufferedReader.readLine()) != null) {
	            	 
	            	 String line2 ="";
	            	    for(int i = line.length() - 1; i >= 0; i--) {
	            	        line2 = line2 + line.charAt(i);
	            	    }
	            	    System.out.println(line2);
	            	    fileWriter.write(line2 + "\n");
	            } 
	           	             
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (bufferedWriter != null) {
	                    bufferedWriter.close();
	                }
	                if (fileReader != null) {
	                    fileReader.close();

	                }
	                if (fileWriter != null) {
	                    fileWriter.close();
	                }
	                if (bufferedReader != null) {
	                    bufferedReader.close();
	                }

	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }

	    }
	}