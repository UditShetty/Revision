package Day1;

public abstract class Animal {

	String name;
	
	public abstract void makeNoise();
	
	public abstract void eat();
	
	public void sleep() {
		System.out.println(name+" is sleeping");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Animal(String name) {
		super();
		this.name = name;
	}

	public Animal() {
		super();
	}
	
	
}
