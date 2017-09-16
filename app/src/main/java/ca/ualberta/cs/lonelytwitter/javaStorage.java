package ca.ualberta.cs.lonelytwitter;
 
import java.io.*;

public class javaStorage {
	public static void main(String[] args){
		String filename = "student.txt";	
		javaStorage demo = new javaStorage();
		demo.writeFile(filename);
		demo.readFile(filename);
	}

	private void writeFile(String filename){
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(new File(filename), true));
			//BufferedWriter out= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));
			out.write("StudentA\tstudenta@cs.ualberta.ca\n");
			out.write("StudentB\tstudentb@cs.ualberta.ca\n");
			out.write("StudentC\tstudentc@cs.ualberta.ca\n");
			out.close();
		} catch (IOException ex){
			ex.printStackTrace();
		} 
	}

	private void readFile(String filename){
		try{
			BufferedReader in= new BufferedReader(new FileReader(new File(filename)));
			//BufferedReader in= new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String next;
			while(true) {
				next = in.readLine();
				if(next == null) break;
				System.out.println(next);
			}
			in.close();
		}catch (IOException ex){
			ex.printStackTrace();
		} 
	}

}
