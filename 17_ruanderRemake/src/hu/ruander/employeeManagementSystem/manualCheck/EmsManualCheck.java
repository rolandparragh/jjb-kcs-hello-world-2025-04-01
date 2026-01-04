package hu.ruander.employeeManagementSystem.manualCheck;

public class EmsManualCheck {
	
	public void doCheck() {
		
		System.out.println("****Adatbázis kapcsolódás*****");
	DatabaseConnectionCheck databaseConnectionCheck = new DatabaseConnectionCheck();
	databaseConnectionCheck.printIsDatabaseConnectEstablished();
	System.out.println(databaseConnectionCheck.isDatabaseConnectionEstablished());
	
	System.out.println("*****EmployeeDao Műveletek*****");
	EmployeeDaoCheck employeeDaoCheck = new EmployeeDaoCheck();
	employeeDaoCheck.printGetAll();
	
	
	//employeeDaoCheck.save();
	employeeDaoCheck.getById();
	//employeeDaoCheck.update();
	//employeeDaoCheck.delete();
	
	System.out.println("*****EmployeeCategoryDao Műveletek*****");
	EmployeeCategoryCheck employeeCategoryCheck = new EmployeeCategoryCheck();
	
	employeeCategoryCheck.printGetAll();
	//employeeCategoryCheck.save();
	//employeeCategoryCheck.update();
	//employeeCategoryCheck.delete();
	employeeCategoryCheck.getByid();
	}
	
	

}
