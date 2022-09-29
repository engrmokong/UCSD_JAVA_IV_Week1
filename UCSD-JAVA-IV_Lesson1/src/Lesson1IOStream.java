import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.nio.*;
import java.nio.charset.StandardCharsets;

public class Lesson1IOStream {

	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException{
		

		System.out.println("Java Help Display");

		String working_dir = System.getProperty("user.dir");
		System.out.println(working_dir);

		
		Employee marcus = new Employee("Marcus Limon");
		Employee mark = new Employee("Mark Limon");
		Employee jacq = new Employee("Jacq Limon");

		//String  [] employee = {"Marcus", "Mark", "Jacq"};

		//writing and reading an object
		System.out.println("Reading and Writing Objects");
		Employee[] staff = new Employee[3];
		staff[0] = marcus;
		staff[1] = mark;
		staff[2] = jacq;
		String objfilename = "employees.dat";
		try (ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream(objfilename))) {
			oos.writeObject(staff);
		}
		try (ObjectInputStream ois =new ObjectInputStream(new FileInputStream(objfilename))) {
			// Read array
			Employee[] newStaff = (Employee[]) ois.readObject();
			
			// Display all records
			for (Employee e : newStaff) {
				System.out.println(e);
			}
		}


		//Writing text to file
		System.out.println("");
				System.out.println("Writes/Read Text");
		//writes data to a file
		String  [] employee = {"Marcus", "Mark", "Jacq"};
		String filename = "Employee.txt";
		PrintWriter nm = new PrintWriter(filename);

		//writing data text to a file
		for (String e:employee) {
			nm.println(e);

		}
		nm.close();

		//read text data to a file
		String employeeName = "Employee.txt";
		File file = new File(employeeName);

		BufferedReader fN = new BufferedReader(new FileReader(file));


		//reading each name from the file until no more are left
		String eName;
		while((eName = fN.readLine()) != null)
		{

			//display names
			System.out.println(eName);

		}

		fN.close();

		//Reading and writing binary file

		//DataInputStream in = new DataInputStream(new FileInputStream("Employee.dat"));
		//Writing
		//String str = "UCSD Java";
		//DataOutputStream out = new DataOutputStream(new FileOutputStream("output.dat"));
		//out.write();

		//getting using the Path class
		try {
			
			Path path = Paths.get("D:/Documents/Java_Workspace/UCSD-JAVA-IV_Lesson1", "Employee.txt");
			//reading the file content in bytes
			byte[] bytes = Files.readAllBytes(path);

			//
			String str = new String(bytes,StandardCharsets.UTF_8 );
			System.out.println("");
			System.out.println("Displaying the bytes");
			System.out.println(str);

			List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			//displaying output using for each
			System.out.println("Displaying the bytes using List<>");
			for(String line: lines) {
				System.out.println(line);
			}

			//writing a bytes
			Files.write(path, str.getBytes(StandardCharsets.UTF_8));


		}
		catch(IOException e){
			
			System.out.println("Error");

		}
	}

}
