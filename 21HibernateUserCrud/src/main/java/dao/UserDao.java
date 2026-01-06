package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dto.User;

public class UserDao implements ICrud {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernateUserCrud");
	EntityManager entityManager = factory.createEntityManager();

	@Override
	public List<User> getAll() {
		// 1. megoldás: SQL --> HQL-t használ

		List<User> users = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();

		return users;
	}

	@Override
	public User findById(Long id) {
		User users = (User) entityManager.createQuery("SELECT u FROM User u WHERE id='" + id + "'").getSingleResult();
		
		return users;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

}
