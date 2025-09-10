package estateOOP;

public class TaskSolution {

//	Estate estate = readDataFromConsole.getEstateObjectFromInput();

	public boolean isEstateLocatedInBudapest(Estate estate) {
		boolean isLocatedInBudapest = false;
		if (estate.getCityName().equalsIgnoreCase("budapest")) {
			isLocatedInBudapest = true;
		}
		return isLocatedInBudapest;
	}

//c. Készítsünk metódust, ami eldönti, hogy fővárosi –e az ingatlan (csak Magyarországi ingatlanokat kell kezelnie az alkalmazásnak)!
	public void displayIsEstateLocatedInBudapest(Estate estate) {
		boolean isBudapest = isEstateLocatedInBudapest(estate);

		if (isBudapest) {
			System.out.println("Az ingatlan a fővárosban található");
		} else {
			System.out.println("Az ingatlan nem fővárosi");
		}
	}
	public boolean isSuitableForBiggerFamilies ( Estate estate) {
		boolean isSuitableForBiggerFamilies = false;
		if ( estate.getM2() > 110) {
			isSuitableForBiggerFamilies = true;
		}
		return isSuitableForBiggerFamilies;
	}
	public void displayIsSuitableForBiggerFamilies(Estate estate) {
		boolean isSuitable = isSuitableForBiggerFamilies(estate);
		if (isSuitable) {
			System.out.println("Az ingatlan alkalmas nagycsaládosoknak");
		} else {
			System.out.println("Az ingatlan nem alkalmas nagycsaládosoknak");
		}
	}

}
