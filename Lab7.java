//COSC1047 Lab#7 pt 1 - Adam Byrne 


package javaapplication;

import java.util.ArrayList;

public class Lab7 {

	public static void main(String[] args) {
		
		ArrayList<String> strings = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			strings.add("Hello");
		}
		
		strings = removeDuplicates(strings);
		for (String s : strings) {
			System.out.println(s);
		}
	}
	
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		
		ArrayList<E> list2 = new ArrayList<E>();
		
		for (E duplicate : list) {
			if (!list2.contains(duplicate)) {
				list2.add(duplicate);
			}
		}
		return list2;
				
	}
	
}
