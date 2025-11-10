package bicycleShop;

import java.time.LocalDate;

public class Bicycle {

	private Integer partNumber;
	private String name;
	private String type;
	private Integer price;
	private boolean used;
	private Byte categoryId;
	private LocalDate createdDate;

	public Bicycle(Integer partNumber, String name, String type, Integer price, boolean used, Byte categoryId,
			LocalDate createdDate) {
		super();
		this.partNumber = partNumber;
		this.name = name;
		this.type = type;
		this.price = price;
		this.used = used;
		this.categoryId = categoryId;
		this.createdDate = createdDate;
	}

	public Integer getPartNumber() {
		return partNumber;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public Integer getPrice() {
		return price;
	}

	public boolean isUsed() {
		return used;
	}

	public Byte getCategoryId() {
		return categoryId;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	@Override
	public String toString() {
		return "Bicycle [partNumber=" + partNumber + ", name=" + name + ", type=" + type + ", price=" + price
				+ ", used=" + used + ", categoryId=" + categoryId + ", createdDate=" + createdDate + "]";
	}

	public String getCategoryText() {
		String categoryText = null;
		switch (this.categoryId) {
		case 1:
			categoryText = "férfi";
			break;
		case 2:
			categoryText = "női";
			break;
		case 3:
			categoryText = "gyermek";
			break;
		default:
			categoryText = " hibás adat";
			break;
		}
		return categoryText;
	}
	public String getUsedText() {
		return this.isUsed() ? "használt" : "új";
	
	}
}
