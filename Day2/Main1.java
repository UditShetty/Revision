package Day2;

public class Main1 implements Question1{

	@Override
	public void multiply(int x, int y) {
		int mult= x*y;
		
		System.out.println(mult);
		
	}
	
	
	public static void main(String[] args) {
		
		Main1 m= new Main1();
		m.multiply(4,5);
	}

}
