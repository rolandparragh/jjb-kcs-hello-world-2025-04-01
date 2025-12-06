package dogWalkerPlanner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class FileHandler {

	private String header = "";

	private List<Dog> readDogDataFromFile(String filePath) {

		List<Dog> dogs = new ArrayList<Dog>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			header = br.readLine();
			String[] headerSplit = header.split(",");
			while (br.ready()) {
				String row = br.readLine();
				String[] rowData = row.split(",");
				if (headerSplit.length == rowData.length) {
					dogs.add(getDogsFromRow(rowData));
				}
			}

		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {

		}

		return dogs;
	}

	public List<Dog> getDogsFromFile(String filePath) {
		return readDogDataFromFile(filePath);
	}

	private Dog getDogsFromRow(String[] rowData) {
		Dog newDog = new Dog(Integer.parseInt(rowData[0]), rowData[1], Integer.parseInt(rowData[2]),
				Integer.parseInt(rowData[3]));

		return newDog;
	}

	private List<WalkEntry> readWalkDataFromFile(String filePath) {

		List<WalkEntry> walkEntry = new ArrayList<WalkEntry>();
		WalkEntry we = new WalkEntry(0, null, 0);

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			header = br.readLine();
			String[] headerSplit = header.split(",");
			String row = "";
			int rowCounter=0;
			while ((row = br.readLine()) !=null) {
				String[] rowData = row.split(",");
				if (headerSplit.length == rowData.length && rowData[0].equals(we.getId()) && rowData[1].equals(we.getDate())&& rowData[2].equals(we.getDailyWalkInMinutes())) {
					
					walkEntry.add(getWalksFromRow(rowData));
				}
				else {
					System.out.println("A sorban szintaktikai hiba van");
				}
				rowCounter++;
			}


		} catch (FileNotFoundException e) {
			System.err.println("A fájl nem található");
			e.printStackTrace();
		}
		catch (ClassCastException e) {
			System.out.println("Ez a sor nem olvasható be.");
		} 
		catch (Exception e) {
			System.out.println("Error");
		}

		return walkEntry;
	}

	private WalkEntry getWalksFromRow(String[] rowData) {
		
		WalkEntry newWalkEntry = new WalkEntry(Integer.parseInt(rowData[0]),
				LocalDate.parse(rowData[1], DateTimeFormatter.ofPattern("yyyy-MM-dd")), Integer.parseInt(rowData[2]));

		return newWalkEntry;
	}
	public Boolean CheckingType() {
		
		
	 Boolean isTypeCorrect = false;
	 
	 
	 return isTypeCorrect;
	}

	public List<WalkEntry> getWalksfromFile(String filePath) {
		return readWalkDataFromFile(filePath);
	}
}
