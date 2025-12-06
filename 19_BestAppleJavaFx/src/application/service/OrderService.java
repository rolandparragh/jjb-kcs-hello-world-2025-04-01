package application.service;

import application.dao.OrderDao;
import application.dao.ProductDao;
import application.model.Order;
import application.model.Product;

public class OrderService {

	private final OrderDao orderDao;

	public OrderService(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	public Order createOrder(String name, String email, String phone, String postalCode, String city, String address,
			int amount, Product product, boolean reduced) {
		Order order = new Order(name, email, phone, postalCode, city, address, amount, amount, reduced);
		orderDao.save(order);
		return order;
	}
	
	public double calculateTotal(Order order) {
		Product product = new ProductDao().getById(order.getProductId());
		return order.getAmount()*product.getPrice()*(order.getReduced() ? 0.7 : 1.0);
	}
}
