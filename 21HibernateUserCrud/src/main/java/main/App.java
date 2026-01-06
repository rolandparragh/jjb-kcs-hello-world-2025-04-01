package main;

import dao.UserDao;

public class App {

	public static void main(String[] args) {
		//CRUD 
		UserDao userDao = new UserDao();
		
		
		
		//5. getAll() --- minden user lekérdezése 
		System.out.println(userDao.getAll());
		
		
		System.out.println(userDao.findById((long) 2));


	}

}
