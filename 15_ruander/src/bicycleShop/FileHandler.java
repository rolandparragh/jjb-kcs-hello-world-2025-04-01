package bicycleShop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

	private static String header = "";

	private List<Bicycle> readFile(String filePath) {
		List<Bicycle> bicycles = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			header = br.readLine();
			String[] headerSplit = header.split(";");
			String line;
			while ((line = br.readLine()) != null) {
				String[] rowData = line.split(";");
				if (rowData.length == headerSplit.length) {
					bicycles.add(getBicycleFromRow(rowData));
				}
			}

		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error happened");
			e.printStackTrace();
		}
		return bicycles;

	}

	public List<Bicycle> getBicycleFromFile(String filePath) {
		return readFile(filePath);
	}

	private Bicycle getBicycleFromRow(String[] rowData) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		Bicycle newBicycle = new Bicycle(Integer.valueOf(rowData[0]), rowData[1], rowData[2],
				Integer.valueOf(rowData[3]), rowData[4].equals("1"), Byte.parseByte(rowData[5]),
				LocalDate.parse(rowData[6],formatter));

		return newBicycle;
	}
	
	public void writeBicycleFile(List<Bicycle> bicycle, String filePath, char divider) {
		try {
			FileWriter fw = new FileWriter(filePath, Charset.forName("UTF-8"),false);
			//fw.write("Cikkszám ; Név ; Típus ; Ár ; Használt ; Kategória ; Rögzítés dátuma;\r\n");
			fw.write(header);
			fw.write("\n");
			
			for (Bicycle bicycles : bicycle) {
				if (bicycles.getType().equalsIgnoreCase("trekking") && bicycles.getCategoryId()==1) {
					fw.write(bicycles.getPartNumber().toString());
					fw.write(divider);
					fw.write(bicycles.getType());
					fw.write(divider);
					fw.write(bicycles.getPrice().toString());
					fw.write(divider);
					fw.write(bicycles.isUsed() ? "1" :"0");
					fw.write(divider);
					fw.write(bicycles.getCategoryId().toString());
					fw.write(divider);
					fw.write(bicycles.getCreatedDate().toString().replace("-","."));
					fw.write("\n");
				}
			}
			fw.close();
		}catch(IOException e ) {
			
		}

	}

}
