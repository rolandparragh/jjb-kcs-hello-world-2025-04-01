package flyInterfaceExample;

public class Machine {
	private String identifier;
	private double fuelLevel;

	public Machine(String identifier, double fuelLevel) {
		super();
		this.identifier = identifier;
		this.fuelLevel = fuelLevel;
	}

	public double getFuelLevel() {
		return fuelLevel;
	}

	public void setFuelLevel(double fuelLevel) {
		this.fuelLevel = fuelLevel;
	}

	public String getIdentifier() {
		return identifier;
	}

	@Override
	public String toString() {
		return "Machine [identifier=" + identifier + ", fuelLevel=" + fuelLevel + "]";
	}

	public void fillFuel(double value) {
		this.fuelLevel += value;
	}
}
