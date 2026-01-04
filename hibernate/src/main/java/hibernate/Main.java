package hibernate;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		Student s1 = new Student();
		s1.setRollNo(106);
		s1.setsAge(99);
		s1.setsName("Teszt Elek");

		// Create a Hibernate Configuration object
		// Configuration cfg = new Configuration();
		// Register the Student class as an annotated entity
		// cfg.addAnnotatedClass(Student.class);
		// Load Hibernate configuration from hibernate.cfg.xml
		// cfg.configure();
		// Build a SessionFactory from the configuration

		SessionFactory sf = new Configuration().addAnnotatedClass(Student.class).configure().buildSessionFactory(); // cfg.buildSessionFactory();
		// Open a new session (connection to the database)
		Session session = sf.openSession();
		// Begin a new transaction
		Transaction transaction = session.beginTransaction();
		// Persist (save) the Student object to the database
		// session.persist(s1);
		// Commit the transaction (finalize changes)
		// transaction.commit();
		session.close();
		sf.close();

		StudentDao studentDao = new StudentDao();
		// studentDao.findStundetById();

		SessionFactory sfAlien = new Configuration()
				.addAnnotatedClass(Alien.class)
				.addAnnotatedClass(Laptop.class)
				.configure()
				.buildSessionFactory();

		Session sessionAlien = sfAlien.openSession();
		Transaction transactionAlien = sessionAlien.beginTransaction();
		Laptop l1 = new Laptop();
		l1.setLid(501);
		l1.setBrand("Asus");
		l1.setModel("ROG");
		l1.setRam(32);

		Laptop l2 = new Laptop();
		l2.setLid(502);
		l2.setBrand("Dell");
		l2.setModel("XPS");
		l2.setRam(32);
		Alien a1 = new Alien();
		a1.setAid(104);
		a1.setAName("Alienke");
		a1.setTech("python");

		a1.setLaptops(Arrays.asList(l1, l2));
		l1.setAlien(a1);
		l2.setAlien(a1);
		sessionAlien.persist(l1);
		sessionAlien.persist(l2);
		sessionAlien.persist(a1);

		transactionAlien.commit();

		Alien a2 = sessionAlien.find(Alien.class, 101);
		System.out.println(a2);

		sessionAlien.close();
		sfAlien.close();
	}

}
