package Day2;

public class Circle extends Shape { 
	 protected void display() {
		System.out.println("Display-derived");
	}
	 
	 public static void main(String[] args) {
		Circle c1= new Circle();
		
		c1.display();
	}
	 
	 /*
	  * 
	  * → Write which modifier can be used in above written code
snippet..
a. Only protected can be used.
B. public and protected both can be used.
C. public, protected, and private can be used.
d. Only public can be used.

Ans: public and protected both can be used as we have given only same access modifier or higher than the given modifier
	  */
}
