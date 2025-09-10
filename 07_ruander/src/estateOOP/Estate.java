package estateOOP;


public class Estate {

	// megnevezés - szöveg, negyzetméter - egész szám,
	// iranyitó szám - egész szám, város - szöveg, cim - szöveg,
	// szobák száma - egész szám)!
	private String title;
	private int m2;
	private int postCode;
	private String cityName;
	private String address;
	private byte numberOfRooms;

	public Estate(String title, int m2, int postCode, String cityName, String address, byte numberOfRooms) {
		super();
		this.title = title;
		this.m2 = m2;
		this.postCode = postCode;
		this.cityName = cityName;
		this.address = address;
		this.numberOfRooms = numberOfRooms;
	}

	public String getTitle() {
		return title;
	}

	public int getM2() {
		return m2;
	}

	public int getPostCode() {
		return postCode;
	}

	public String getCityName() {
		return cityName;
	}

	public String getAddress() {
		return address;
	}

	public byte getNumberOfRooms() {
		return numberOfRooms;
	}

	@Override
	public String toString() {
		return "Estate [title=" + title + ", m2=" + m2 + ", postCode=" + postCode + ", cityName=" + cityName
				+ ", address=" + address + ", numberOfRooms=" + numberOfRooms + "]";
	}

	public String estateDetailsByDivider(char divider) {
		String estateDetails = "";
		estateDetails += "Megnevezés: " + getTitle();
		estateDetails += divider;
		estateDetails += "Négyzetméter: " + getM2();
		estateDetails += divider;
		estateDetails += "Irányitószám: " + getPostCode();
		estateDetails += divider;
		estateDetails += "Város: " + getCityName();
		estateDetails += divider;
		estateDetails += "Cím: " + getAddress();
		estateDetails += divider;
		estateDetails += "szobákSzáma: " + getNumberOfRooms();

		return estateDetails;
	}
	//e. Készítsünk metódust, ami kiírja, hogy Pesten vagy Budán van –e az ingatlan? (emelt szint)
	public static void getSideOfDanube(Estate estate) {
		int[] buda = { 1, 2, 3, 11, 12, 22 };
		int[] pest = { 4, 5, 6, 7, 8, 9, 10, 13, 14, 15, 16, 17, 18, 19, 20, 21, 23 };
		String districtHelper = "";
		districtHelper += Integer.toString(estate.postCode).charAt(1);
		districtHelper += Integer.toString(estate.postCode).charAt(2);
		int district = Integer.parseInt(districtHelper);
		if (estate.getCityName().equalsIgnoreCase("budapest")) {
			for (int i = 0; i < pest.length; i++) {
				if (district == pest[i]) {
					System.out.println("Az ingatlan Pesten található");
				}
			}
			for (int i = 0; i < buda.length; i++) {
				if (district == buda[i]) {
					System.out.println("Az ingatlan Budán található");
				}
			}
		} else {
			System.out.println("Az ingatlan nem Budapesten található, ezért a vizsgálat nem végezhető el");
		}
	}

}
