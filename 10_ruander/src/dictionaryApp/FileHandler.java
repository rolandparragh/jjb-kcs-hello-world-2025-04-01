package dictionaryApp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {
	private String filePath = "dictionary_data/dictionary.csv";

	public Map<String, String> readEngToHun() {

		 Map<String,String> engToHunDic = new HashMap<>();
		 
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
			while (br.ready()) {
				String row = br.readLine();
				String[] rowData = row.split(";");
				engToHunDic.put(rowData[0], rowData[1]);
			}
			br.close();
		} catch (UnsupportedEncodingException e) {
			System.err.println("Nem támogatott fájlkódolás");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.err.println("A fájl nem található");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IO hiba történt...");
			e.printStackTrace();
		}

		return engToHunDic;
	}// End readEndToHun
	
	public Map<String, String> readHunToEng() {

		 Map<String,String> hunToEngDic = new HashMap<>();
		 
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
			while (br.ready()) {
				String row = br.readLine();
				String[] rowData = row.split(";");
				hunToEngDic.put(rowData[1], rowData[0]);
			}
			br.close();
		} catch (UnsupportedEncodingException e) {
			System.err.println("Nem támogatott fájlkódolás");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.err.println("A fájl nem található");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IO hiba történt...");
			e.printStackTrace();
		}

		return hunToEngDic;
	}// End readHunToEng
}


