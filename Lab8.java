//COSC1047 Lab8 JUnit Test - Adam Byrne

package javaapplication;

public class Lab8 {

		private int oneS = 0;
		private int twoS = 0;
		private int threeS = 0;
			
		public Lab8(int[] stars) {
			
			for(int i = 0; i < stars.length; i++){
				if(stars[i] == 1) {
					oneS++;
				}
				else if(stars[i] == 2) {
					twoS++;
				}
				else if(stars[i] == 3) {
					threeS++;
				}
			}//loop
			
		}//starRating


		public boolean mostlyPositive() {
			return ((threeS > twoS) && (threeS > oneS) || (threeS > oneS) && (twoS > oneS)); 
		}
		public boolean mostlyNegative() {
			return ((oneS > threeS) && (oneS > twoS) || (oneS > threeS) && (twoS > threeS)); 
		}
		public boolean mixed() {
			return ((threeS == twoS) && (threeS == oneS)); 
		}
		
	}

