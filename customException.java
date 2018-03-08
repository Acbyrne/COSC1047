package javaapplication;

public class customException {
	public class InvalidStringException extends Exception{
		public InvalidStringException(String s) {
			super(s);
		}
	}
	public class stringGet{
		public String getString(String s) throws InvalidStringException {
			if(s != "ok") {
				System.out.println(s);
				return s;
			}
			else {
				throw new InvalidStringException("Invalid String: " + s);
			}
		}
	}
	
}
