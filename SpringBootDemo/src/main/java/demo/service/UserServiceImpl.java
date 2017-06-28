package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.UserModel;
import demo.repository.Repository;


@Service 
public class UserServiceImpl implements UserService {
	
	
	private Repository repo;

	
	@Autowired
	public void setRepo(Repository repo) {
		this.repo = repo;
	}

	@Override
	public UserModel findById(Integer id) {
		return repo.findOne(id);
	}

	@Override
	public UserModel findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel saveUser(UserModel user) {
		
		return repo.save(user);
		
	}

	@Override
	public void updateUser(UserModel user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<UserModel> findAllUsers() {
		return  repo.findAll();
	}

	@Override
	public boolean isUserExist(UserModel user) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
