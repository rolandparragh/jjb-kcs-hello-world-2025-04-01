package estateOOP;

public class App {

	public static void main(String[] args) {
		ReadDataFromConsole readDataFromConsole = new ReadDataFromConsole();
		
		Estate estate = readDataFromConsole.getEstateObjectFromInput();

		
		TaskSolution taskSolution = new TaskSolution();
		//b. Készítsünk metódust, ami kiírja, az ingatlan minden adatát!
		System.out.println(estate.estateDetailsByDivider('\t'));
		//Készítsünk metódust, ami eldönti, hogy fővárosi –e az ingatlan (csak Magyarországi ingatlanokat kell kezelnie az alkalmazásnak)!
		taskSolution.displayIsEstateLocatedInBudapest(estate);
		//d. Készítsünk metódust ami, eldönti, hogy nagycsaládosok számára alkalmas –e (110nm felett már alkalmas)!
		taskSolution.displayIsSuitableForBiggerFamilies(estate);
		Estate.getSideOfDanube(estate);
	}
	

 

}



//e. Készítsünk metódust, ami kiírja, hogy Pesten vagy Budán van –e az ingatlan? (emelt szint)