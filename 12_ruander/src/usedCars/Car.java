package usedCars;

import java.time.LocalDate;

public class Car {
	private String id;
	private String manufacturer;
	private String model;
	private int engineDisplacement;
	private int seats;
	private LocalDate productionYear;
	private int netPrice;
	private int milage;
	private String fuel;
	public Car(String id, String manufacturer, String model, int engineDisplacement, int seats,
			LocalDate productionYear, int netPrice, int milage, String fuel) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.engineDisplacement = engineDisplacement;
		this.seats = seats;
		this.productionYear = productionYear;
		this.netPrice = netPrice;
		this.milage = milage;
		this.fuel = fuel;
	}
	public String getId() {
		return id;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public String getModel() {
		return model;
	}
	public int getEngineDisplacement() {
		return engineDisplacement;
	}
	public int getSeats() {
		return seats;
	}
	public LocalDate getProductionYear() {
		return productionYear;
	}
	public int getNetPrice() {
		return netPrice;
	}
	public int getMilage() {
		return milage;
	}
	public String getFuel() {
		return fuel;
	}

	
	public String formattedCarString (char divider) {
		String formatCar ="";
		formatCar +=this.id ;
		formatCar +=divider;
		formatCar +=this.manufacturer ;
		formatCar +=divider;
		formatCar +=this.model ;
		formatCar +=divider;
		formatCar +=this.engineDisplacement ;
		formatCar +=divider;
		formatCar +=this.seats ;
		formatCar +=divider;
		formatCar +=this.productionYear;
		formatCar +=divider;
		formatCar +=this.netPrice ;
		formatCar +=divider;
		formatCar +=this.milage ;
		formatCar +=divider;
		formatCar +=this.fuel;
		return formatCar;
	}
	
	
	
}

