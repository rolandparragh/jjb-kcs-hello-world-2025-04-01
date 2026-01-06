package dao;

import java.util.List;

import dto.User;

public interface ICrud {
	
	public List <User> getAll();
	public User findById(Long id);
	public void save(User user);
	public void updateById(Long id);
	public void deleteById(Long id);
	
	

}
