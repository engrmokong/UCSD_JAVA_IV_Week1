import java.io.*;


public class Employee implements Serializable{
	
	private String name;
	
	public Employee(String n) {
		
		name = n;
		
	}
	
	public String getName()
	{
		return name;
	}

}
