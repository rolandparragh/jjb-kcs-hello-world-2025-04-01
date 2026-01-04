package hu.ruander.employeeManagementSystem.model.dao;

import java.util.List;

/*Generikus interface 
 * Bármelyik DAO osztályunk ami implementálja ezt az interface-t, kötelező 
 * ezeket a funkciókat megvalósítania.
 * Generikus / általános
 * T - típus paraméter bármilyen object lehet, pl EmployeeDto, EmployeeCategoryDto
 * 
 */

public interface ICrudDao<T> {
// i interfacere utal 
	public List<T> getAll();

	public void save(T entity);

	public T getById(int id);

	public void update(T entity);

	public void softDelete(T entity);
	// softDelete: logikai törlés, nem fizikai törlés az adatbázisból, inkább update
	// az adatbázisban egy "deleted" mezőt állítunk true-ra
	// a getAll és egyéb lekérdezések figyelembe veszik ezt a mezőt
	public T getObjectFromResultSet();
	
}
