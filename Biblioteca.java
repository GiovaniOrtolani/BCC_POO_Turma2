package library;

//import java.util.*;
import java.io.*;
//import java.util.stream.*;

class Biblioteca {
	public Biblioteca() {
	}	

	public static void main(String []args) {
		System.out.println("Oi");
		//SaleReport sr = new SaleReport(args[0]);
		try {
			BufferedReader in = new BufferedReader(new FileReader("oi.csv"));
			//System.out.println("Oi");
			String csv=in.readLine();
			//Timestamp oi;
			if (csv.equals("")) {
				System.out.println("Arquivo vazio");
				System.exit(0);
			}
			do {
				System.out.println(csv);
			} while((csv = in.readLine()) != null);
				
		}
		catch(FileNotFoundException e) {
			System.out.println("Arquivo " + "sales.csv" + " was not found!");
		}
		catch(IOException e) {
			System.out.println("Error reading the file!");
		}
	}
}
