package zooinheritance;

public class Parrot extends Bird {

	private boolean ableToSimulateHumanVoice;

	public Parrot(boolean birthInPlace, String nameOfZoo, String color, int periodOfBreeding,
			boolean ableToSimulateHumanVoice) {
		super(birthInPlace, nameOfZoo, color, periodOfBreeding);
		this.ableToSimulateHumanVoice = ableToSimulateHumanVoice;
	}

	public boolean isAbleToSimulateHumanVoice() {
		return ableToSimulateHumanVoice;
	}

	@Override
	public String toString() {
		return "Parrot [ableToSimulateHumanVoice=" + ableToSimulateHumanVoice + ", nameOfZoo=" + nameOfZoo
				+ ", isAbleToSimulateHumanVoice()=" + isAbleToSimulateHumanVoice() + ", getColor()=" + getColor()
				+ ", getPeriodOfBreeding()=" + getPeriodOfBreeding() + ", toString()=" + super.toString()
				+ ", getNameOfZoo()=" + getNameOfZoo() + ", isBirthInPlace()=" + isBirthInPlace()
				+ ", getBirthInPlaceText()=" + getBirthInPlaceText() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
 }
 
 
}
