package Day1;

public class Dog extends Animal{

	String breed;
	
	@Override
	public void makeNoise() {
		System.out.println("Dog is making Noise");
		
	}

	@Override
	public void eat() {
		System.out.println("Dog is eating");
		
	}
	
	public void play() {
		System.out.println(" Dog is playing");
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Dog(String name, String breed) {
		super(name);
		this.breed = breed;
	}

	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dog(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	

	
}
