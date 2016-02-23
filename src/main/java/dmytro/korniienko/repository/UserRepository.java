package dmytro.korniienko.repository;

import dmytro.korniienko.entity.User;

public interface UserRepository {

	void register(User user);

	void remove(User user);

	User getByEmail(String email);

	User getByName(String name);
	
	User getUserById(Long id);

}
