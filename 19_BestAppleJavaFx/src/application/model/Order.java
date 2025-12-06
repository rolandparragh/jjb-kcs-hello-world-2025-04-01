package application.model;

public class Order {

	private Long id;
	private String name;
	private String email;
	private String phone;
	private String postalCode;
	private String city;
	private String address;
	private int amount;
	private int productId;
	private Boolean reduced;
	
	public Order(Long id, String name, String email, String phone, String postalCode, String city, String address,
			int amount, int productId, Boolean reduced) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.postalCode = postalCode;
		this.city = city;
		this.address = address;
		this.amount = amount;
		this.productId = productId;
		this.reduced = reduced;
	}
	
	public Order(String name, String email, String phone, String postalCode, String city, String address,
			int amount, int productId, Boolean reduced) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.postalCode = postalCode;
		this.city = city;
		this.address = address;
		this.amount = amount;
		this.productId = productId;
		this.reduced = reduced;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCity() {
		return city;
	}

	public String getAddress() {
		return address;
	}

	public int getAmount() {
		return amount;
	}

	public int getProductId() {
		return productId;
	}

	public Boolean getReduced() {
		return reduced;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", postalCode="
				+ postalCode + ", city=" + city + ", address=" + address + ", amount=" + amount + ", productId="
				+ productId + ", reduced=" + reduced + "]";
	}
}
