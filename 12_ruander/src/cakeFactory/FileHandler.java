package cakeFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

	@SuppressWarnings("unused")
	private static String header ="";
	private List<Cake> readFile(String filePath){
		List<Cake> cakes = new ArrayList<>();
		try( BufferedReader br = new BufferedReader(new FileReader(filePath))){
			header = br.readLine();
			String line;
			while((line = br.readLine()) !=null) {
				String[] rowData = line.split(";");
				if ( rowData.length == 7) {
					cakes.add(getCakeFromRow(rowData));}
				}
			
		} catch (FileNotFoundException e) {
			System.err.println("A fájl nem található");
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return cakes;
	}
	
	public List<Cake> getCakesFromFile(String filePath){
		return readFile(filePath);
	}
	
	private Cake getCakeFromRow(String[] rowData) {
		Cake newCake = new Cake(rowData[0],
				rowData[1],
				Integer.parseInt(rowData[2]),
				Integer.parseInt(rowData[3]), rowData[4].equals("1"), rowData[5].equals("1"), rowData[6].equals("1"));
				return newCake;
	}
	
}
