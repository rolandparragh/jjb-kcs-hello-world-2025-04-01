package application.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import application.dto.UserDto;

public class UserDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("companyDb");
	EntityManager entityManager = factory.createEntityManager();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Boolean validateUser(String userName, String password) {
		Boolean result = false;
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<UserDto> from = criteriaQuery.from(UserDto.class);
		
		CriteriaQuery<Long> canLogin = criteriaQuery.
				select(criteriaBuilder.count(from)).where(criteriaBuilder.and(criteriaBuilder.equal(from.get("userName"),userName),
						criteriaBuilder.equal(from.get("password"),password)));
		TypedQuery<Long> typedQuery = entityManager.createQuery(canLogin);
		// Ha a lekérdezés eredménye nem 0, akkor beléphet
		Long resultLong = typedQuery.getSingleResult();
		// Ha a lekérdezés eredménye 0, akkor nem lehet belépni
		if (resultLong>0) {
			result = true;
		}
		return result;
	}
	
	

}
