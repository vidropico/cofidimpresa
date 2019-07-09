package it.cofidimpresa.dao;

import it.cofidimpresa.datamodel.UserModel;

public interface UserDAO {
	
	public void insert(UserModel customer);
	public UserModel findByUsername(String username);

}
