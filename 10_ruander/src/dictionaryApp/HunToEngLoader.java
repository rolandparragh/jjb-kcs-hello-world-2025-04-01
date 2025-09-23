package dictionaryApp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class HunToEngLoader implements DictionaryLoader {

	@Override
	public Dictionary load(String filePath) {

		Map<String, String> words = new HashMap<>();

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
			while (br.ready()) {
				String row = br.readLine();
				String[] rowData = row.split(";");

				words.put(rowData[1], rowData[0]);

			}
			br.close();
		} catch (UnsupportedEncodingException e) {
			System.err.println("Nem támogatott fájlkódolás...");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.err.println("A fájl nem található...");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error reading dictionary: " + e.getMessage());
		}

		return new Dictionary(words);
	}

}
