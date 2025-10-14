package usedCars;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
	@SuppressWarnings("unused")
	private static String header = "";

	private List<Car> readFile(String filePath) {
		List<Car> cars = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			header = br.readLine();
			String line;
			while ((line = br.readLine()) != null) {
				String[] rowData = line.split("\t");
				if (rowData.length == 9) {
					cars.add(getCarFromRow(rowData));
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("A fájl nem található");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cars;

	}

	public List<Car> getCarsFromFile(String filePath) {
		return readFile(filePath);
	}

	private Car getCarFromRow(String[] rowData) {
		DateTimeFormatter format = new DateTimeFormatterBuilder()
			     .appendPattern("yyyy")
			     .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
			     .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
			     .toFormatter();

			LocalDate.parse("2008", format);
		Car newCar = new Car(rowData[0], rowData[1], rowData[2], Integer.parseInt(rowData[3]),
				Integer.parseInt(rowData[4]), LocalDate.parse(rowData[5],format), Integer.parseInt(rowData[6]),
				Integer.parseInt(rowData[7]), rowData[8]);
		return newCar;
	}
}
