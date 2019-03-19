package com.fdmgroup.DAO;

import java.util.List;

import com.fdmgroup.model.IUser;

public interface IUserDAO {
	
	IUser create(IUser user);
	void delete(IUser user);
	List<IUser> getAllTrainees();
	List<IUser> getAllConsultants();
	List<IUser> getAllAdmins();

}
