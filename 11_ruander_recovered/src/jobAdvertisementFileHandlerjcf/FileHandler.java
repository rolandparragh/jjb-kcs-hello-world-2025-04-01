package jobAdvertisementFileHandlerjcf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

	@SuppressWarnings("unused")
	private static String header = "";

	private List<Job> readFile(String filePath) {
		List<Job> jobs = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			header = br.readLine();
			String line;
			while ((line = br.readLine()) != null) {
				String[] rowData = line.split(";");
				if (rowData.length == 6) {
					jobs.add(getJobFromRow(rowData));
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("A fájl nem található");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobs;

	}

	public List<Job> getJobsFromFile(String filePath) {
		return readFile(filePath);
	}

	private Job getJobFromRow(String[] rowData) {
		Job newJob = new Job(Integer.parseInt(rowData[0]), rowData[1], Integer.parseInt(rowData[2]),
				Integer.parseInt(rowData[3]), rowData[4].equals("1"), LocalDate.parse(rowData[5]));
		return newJob;
	}
}
