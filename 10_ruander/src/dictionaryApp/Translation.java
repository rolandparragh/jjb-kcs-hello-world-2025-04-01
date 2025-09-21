package dictionaryApp;

import java.util.Map;

public class Translation {

	ReadUserInput rui = new ReadUserInput();

	public void translateWord(Map<String, String> Dictionary) {

		String wordToTranslate = rui.getWordFromUser();
		 if(Dictionary.containsKey(wordToTranslate)) {
		System.out.println("A megadott szó fordítása:");
		System.out.println(Dictionary.get(wordToTranslate));
		}
		else {
			System.out.println("A megadott szó nem található meg a szótárban...");
			System.out.println("A program futása véget ért.... ");
		}
	}
}

/*
public void translateWord(Map<String, String> Dictionary) {

String wordToTranslate = "";
do {

	wordToTranslate = rui.getWordFromUser();

} while (!Dictionary.containsKey(wordToTranslate));
System.out.println("A megadott szó fordítása:");
System.out.println(Dictionary.get(wordToTranslate));

else {
	System.out.println("A megadott szó nem található meg a szótárban...");
	System.out.println("A program futása véget ért.... ");
}
}
}*/