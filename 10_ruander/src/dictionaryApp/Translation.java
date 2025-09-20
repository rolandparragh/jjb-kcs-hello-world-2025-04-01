package dictionaryApp;

import java.util.HashMap;
import java.util.Map;

public class Translation {

	FileHandler fh = new FileHandler();
	ReadUserInput rui = new ReadUserInput();
	Map<String, String> usedFictionary = new HashMap<>();
	private static final int HUN_TO_ENG = 1;
	private static final int ENG_TO_HUN = 2;

	public Map<String, String> useDictionary() {
		int userDecision = 0;
		Map<String, String> usedDictionary = new HashMap<>();
		do {
			System.out.println("A szám nem 1 vagy 2... ");
			userDecision = rui.selectLanguage();
		} while (userDecision != HUN_TO_ENG && userDecision != ENG_TO_HUN);

		if (userDecision == HUN_TO_ENG) {
			usedDictionary = fh.readHunToEng();
		} else {
			usedDictionary = fh.readEngToHun();
		}
		return usedDictionary;
	}
	
	
	public void translateWord() {
		Map<String, String> usedDictionary = new HashMap<>();
		usedDictionary = useDictionary();
		String wordToTranslate = "";
		do {
			System.out.println("A megadott szó nem található meg a szótárban...");
			wordToTranslate = rui.getWordFromUser();
			
		}while(!usedDictionary.containsKey(wordToTranslate));
		System.out.println("A megadott szó fordítása:");
		System.out.println(usedDictionary.get(wordToTranslate));
	}
}
