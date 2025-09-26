package jobAdvertisementFileHandlerjcf;

import java.time.LocalDate;

public class Job {

	private int id; // 0
	private String role; // 1
	private int netSalary; // 2
	private int expInYears;// 3
	private boolean remote;// 4
	private LocalDate dateOfPublication;// 5

	public Job(int id, String role, int netSalary, int expInYears, boolean remote, LocalDate dateOfPublication) {
		super();
		this.id = id;
		this.role = role;
		this.netSalary = netSalary;
		this.expInYears = expInYears;
		this.remote = remote;
		this.dateOfPublication = dateOfPublication;
	}

	public int getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	public int getNetSalary() {
		return netSalary;
	}

	public int getExpInYears() {
		return expInYears;
	}

	public boolean isRemote() {
		return remote;
	}

	public LocalDate getDateOfPublication() {
		return dateOfPublication;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", role=" + role + ", netSalary=" + netSalary + ", expInYears=" + expInYears
				+ ", remote=" + remote + ", dateOfPublication=" + dateOfPublication + "]";
	}

	public String getRemoteText() {
		return this.isRemote() ? "távmunka" : "nem távmunka";
	}

	public String formatJobString(char divider) {
		String formatJob = "";
		formatJob += this.id;
		formatJob += divider;
		formatJob += this.role;
		formatJob += divider;
		formatJob += this.netSalary;
		formatJob += divider;
		formatJob += this.expInYears;
		formatJob += divider;
		formatJob += this.getRemoteText();
		formatJob += divider;
		formatJob += this.dateOfPublication;
		return formatJob;

	}

}

//id;megnevezes;brutto_fizetes;elvart_tapasztalati_evek;tavmunka;publikacio_ideje