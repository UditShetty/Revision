package Day2;

public class BlueCar extends Car {
	{
		System.out.print("4");
	}
	public BlueCar() {
		super("blue");
			System.out.print("5");
	}
	
	public static void main(String[] gears) {
		new BlueCar();
	}
	
//	Ans: 13245 is the answer because at first in the car static method will give priority than default then the constructor
//	and when we extend car in bluecar then it will first override the constructor which is present in the car class which is a 
//	parametrised constructor then default will print than inside the constructor 5 will print
}
