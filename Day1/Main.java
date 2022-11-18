package Day1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal animal= new Cat();
		animal.setName("cat");
		animal.eat();
		animal.makeNoise();
		animal.sleep();
//		this will show us only animal class object method which is overriding in the the cat 
//		if we want to add cat class then we will downcast the animal class
		
		Cat c=(Cat)animal;
		c.setNickName("Kitty");
		c.setName("Cat");
		c.eat();
		c.makeNoise();
		c.play();
		c.sleep();
		

	}

}
