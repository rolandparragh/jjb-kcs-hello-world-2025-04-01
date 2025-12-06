package application.model;

public class Product {

	private Integer id;
	private String name;
	private Integer price;
	private Boolean status;
	
	public Product(Integer id, String name, Integer price, Boolean status) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Integer getPrice() {
		return price;
	}
	public Boolean getStatus() {
		return status;
	}
	
	@Override
	public String toString() {
		return this.getName() + " - "+this.getPrice();
	}
}
