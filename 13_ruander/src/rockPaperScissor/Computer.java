package rockPaperScissor;

import java.util.Random;

public  class Computer implements Choosable {


	@Override
	public String chosen() {
		Random r = new Random();
		String choice = Choosable.options[r.nextInt(Choosable.options.length)];
		return choice;
	}

}
