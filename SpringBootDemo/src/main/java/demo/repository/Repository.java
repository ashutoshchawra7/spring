package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import demo.model.UserModel;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<UserModel, Integer> {
	
	public UserModel findByLNameAndEmail(String lname, String email);

}
