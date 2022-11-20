package Day2;

public class InfiniteMath extends ComplexMath {
	public final double secret = 8;
	
	public static void main(String[] numbers) {
		Math math = new InfiniteMath();
		
		System.out.print(math.secret);
	}
	
//	Ans: as we given public field as final and we overirde and a method as extending a class still it will not changing their property and 
//	and the value present in the Math class i.e final variable secret as 2 it will same in the all the class who is extending the Math class 
}
