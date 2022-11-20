package Day2;

abstract class Car {
	static {
		System.out.print("1");
	}
	public Car(String name) {
		super();
			System.out.print("2");
	}
	{
		System.out.print("3");
	}
}

