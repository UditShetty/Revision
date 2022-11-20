package Day2;

public class Question2 implements Intr1, Intr2{

		
	@Override
	public void run() {
			System.out.println("Intr1 and Intr2 method is running");
			
		}
	public static void main(String[] args) {
		Question2 q2= new Question2();
		q2.run();
	}
	/*
	 * 
	 * Ques 2: Implement 2 interfaces in a single class having same default methods and observe the catch there?
	 * Ans: only one time method override is use even we are using two interface with same method because when we implemented a 
	 * method it will check the method and if it is same for both the interface the auto generated id will use it only once 
	 */

	

		
	

}
