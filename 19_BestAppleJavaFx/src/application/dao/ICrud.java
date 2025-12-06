package application.dao;

import java.sql.ResultSet;
import java.util.List;

public interface ICrud<T> {
	
	public List<T> getAll();
	public T getById(Integer id);
	public T getObjectFromRs(ResultSet rs);

}
