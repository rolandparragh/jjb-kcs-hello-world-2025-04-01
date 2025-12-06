package dogWalkerPlanner;

import java.time.LocalDate;

public class WalkEntry {
	
	private int id;
	private LocalDate date;
	private int dailyWalkInMinutes;

	public int getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public int getDailyWalkInMinutes() {
		return dailyWalkInMinutes;
	}

	public WalkEntry(int id, LocalDate date, int dailyWalkInMinutes) {
		super();
		this.id = id;
		this.date = date;
		this.dailyWalkInMinutes = dailyWalkInMinutes;
	}

	public String getWalksByDivider(char divider) {
		String result ="";
		result += this.id;
		result += divider;
		result += this.date;
		result += divider;
		result += this.dailyWalkInMinutes;

		
		return result;
	}

}
