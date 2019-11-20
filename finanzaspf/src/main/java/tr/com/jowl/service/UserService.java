package tr.com.jowl.service;

import tr.com.jowl.model.User;

import java.util.Collection;
import java.util.List;

public interface UserService {

	User save(User user);

	Boolean delete(int id);

	User update(User user);

	List<User> listar();

	User findById(int id);

	User findByUserName(String username);

	User findByEmail(String email);

	Collection<User> findAll();
}
