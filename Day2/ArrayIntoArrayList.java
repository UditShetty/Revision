package Day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayIntoArrayList {

	public static void main(String[] args) {
		List<String> fruitList = new ArrayList<>();  
        //adding String Objects to fruitsList ArrayList  
        fruitList.add("Mango");  
        fruitList.add("Banana");  
        fruitList.add("Apple");    
        
        System.out.println(fruitList);
        System.out.println("Converting ArrayList to Array" ); 
        
        String[] item = fruitList.toArray(new String[fruitList.size()]);  
        for(String s : item){  
            System.out.println(s);  
        }  
        System.out.println("Converting Array to ArrayList" );  
        List<String>l2 = new ArrayList<>();  
        l2 =  Arrays.asList(item);  
        System.out.println(l2); 
        
        
        

	}

}
