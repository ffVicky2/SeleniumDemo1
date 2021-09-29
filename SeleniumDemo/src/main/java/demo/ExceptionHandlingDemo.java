package demo;

public class ExceptionHandlingDemo {
	
	public static void main(String[] args) {
		try {
			demo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void demo() throws Exception {
				
		System.out.print(".... Hello World......!\n");
		throw new ArithmeticException("Not valid operation");
		//int i = 1/0;		
		//System.out.println(".... Completed");
			
				
	}

}
