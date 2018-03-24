//COSC1047 Assignment# 4 part 2: Adam Byrne

package javaapplication;

import java.io.*;
import java.util.Scanner;

public class Assignment4pt2 {

	public static void main(String[] args) throws IOException {
	//scanner
		Scanner input = new Scanner(System.in);
		
	//txt file containing questions	
		File file = new File("questions.txt");
		File file2 = new File("scores.txt");
		
	//Reader & Writers
		FileReader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
		FileWriter writer = new FileWriter(file2, true);
		BufferedWriter bw = new BufferedWriter(writer);
		FileReader reader2 = new FileReader(file2);
		BufferedReader br2 = new BufferedReader(reader2);
		
	//variables	
		String line = null;
		int lineNum = 0;
		int ansPos = 0;
		int score = 0;
		String userAns = ""; 
		String ans = "";
		
		while((line = br.readLine()) != null) {
			
			System.out.println(line); //print questions until time for user choice
			
			
			if(lineNum == ansPos + 5) { //position of answer in file
				ans = line; //update answer
				ansPos += 5 + 1; //update position to next answer
				System.out.print("Choose your answer: ");
				userAns = input.nextLine();
				if(userAns.equals(ans)) {
					score++;
				}		
			}
			lineNum++;
		}//while
		
	//display score & gather user name to add to scores file 
		System.out.println("You scored " + score + "/5");
		System.out.print("Please enter your name: ");
		String user = input.nextLine();
		System.out.println("Thank you for your participation!");
		writer.write(user + " score: " + score + "/5\n");
		
		
	//print previous scores from score file	
		System.out.println("\nOther users results...");
		String scoresLine = null;
		while((scoresLine = br2.readLine()) != null) {
			System.out.println(scoresLine);
		}
		
	//close files
		input.close();
		br.close();
		bw.close();
		br2.close();

	}//main
}//class
