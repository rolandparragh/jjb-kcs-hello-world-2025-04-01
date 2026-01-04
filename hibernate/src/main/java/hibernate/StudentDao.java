package hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class StudentDao {

	public void findStundetById() {
	
		
		//For update and delete and save you need transaction, for get you don't
		
		Student s2 = null;

		SessionFactory sf = new Configuration().addAnnotatedClass(Student.class).configure().buildSessionFactory();

		Session session = sf.openSession();

	//	s2 = session.find(Student.class, 102);

		// it only returns whatever behind the id, if the id is not there then it will
		// run into error
		// exception handling

		List<Student> students = new ArrayList<>();
		students = session.createQuery("from Student", Student.class).getResultList();

		

		System.out.println(s2.toString());
		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i));
		}
		
		
		//this returns all 
		
		
		
		//************* Update ******************************************/
		
		Student s3 = new Student();
		s3.setsName("Ketica");
		s3.setRollNo(110);
		s3.setsAge(99);
		
		
		Transaction transaction = session.beginTransaction();
		session.merge(s3);	
		// if the id is not there, it will insert it 
		
		
		
		// ********************Deletion ***************************//
		Student s4 = session.find(Student.class,110);
		session.remove(s4);
		transaction.commit();
		session.close();
		sf.close();
	}
}
