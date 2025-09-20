package dictionaryApp;

public class Dictionary {
	
	private String EngToHun;
	private String HunToEng;
	
	public Dictionary(String engToHun, String hunToEng) {

		EngToHun = engToHun;
		HunToEng = hunToEng;
	}

	public String getEngToHun() {
		return EngToHun;
	}

	public String getHunToEng() {
		return HunToEng;
	}

	@Override
	public String toString() {
		return "Dictionary [EngToHun=" + EngToHun + ", HunToEng=" + HunToEng + "]";
	}
	

}
