package Day1;

public class Cat extends Animal{

	String nickName;
	@Override
	public void makeNoise() {
		System.out.println(nickName+" is making noise");
		
	}

	@Override
	public void eat() {
		System.out.println(nickName+" is eating ");
		
	}
	
	public void play() {
		System.out.println(nickName+" is playing");
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Cat(String name, String nickName) {
		super(name);
		this.nickName = nickName;
	}

	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cat(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	

	

	
}
