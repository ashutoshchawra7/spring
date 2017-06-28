package demo.service;

import java.util.List;

import demo.model.UserModel;
import demo.repository.Repository;

public interface  UserService {
	
	 UserModel findById(Integer id);
	 
	    UserModel findByName(String name);
	 
	    UserModel saveUser(UserModel user);
	 
	    void updateUser(UserModel user);
	 
	    void deleteUserById(Long id);
	 
	    void deleteAllUsers();
	 
	    Iterable<UserModel> findAllUsers();
	 
	    boolean isUserExist(UserModel user);

		void setRepo(Repository repository);

}
