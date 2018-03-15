//COSC1047 Lab#7 pt 2 - Adam Byrne 


package javaapplication;


public class Lab7pt2 {

    public static void main(String[] args) {

        Integer[] list = new Integer[10];
        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }

        System.out.println("Max = " + max(list));
    }

    public static <E extends Comparable<E>> E max(E[] list) {
    	
        E max = list[0]; 
        for(int i = 1; i < list.length; i++) {
            if(list[i].compareTo(max) > 0 ) {
                max = list[i];
            }
        }
        return max;
    }
    
}
