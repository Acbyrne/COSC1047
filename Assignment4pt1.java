//COSC1047 Assignment# 4 part 1: Adam Byrne

package javaapplication;

import java.io.*;

public class Assignment4pt1 {
	public static void main(String [] args)throws IOException {
		
		File intFile = new File("integers.dat");
		
	//input & output streams
		DataInputStream input = new DataInputStream ((new FileInputStream(intFile)));
		DataOutputStream output = new DataOutputStream(new FileOutputStream(intFile));
			
	//generate numbers
		for(int i = 0; i <= 100; i++){
			int nums = (int)(Math.random() * 10);
			output.writeInt(nums);      
		}
		output.close();
		
	//Sum integers from file
		long sum = 0;
		while (input.available() > 0) {
			sum += input.readInt();
		}
		System.out.println("The sum of the generated numbers is " + sum);
	
		input.close();
	}//main
}//class