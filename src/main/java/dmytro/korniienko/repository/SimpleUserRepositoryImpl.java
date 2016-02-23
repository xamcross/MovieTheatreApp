package dmytro.korniienko.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import dmytro.korniienko.entity.User;

public class SimpleUserRepositoryImpl implements UserRepository {
	
	@Autowired
	Map<String, User> users;

	@Override
	public void register(User user) {
		users.put(user.getName(), user);
	}

	@Override
	public void remove(User user) {
		users.remove(user);
	}

	@Override
	public User getByEmail(String email) {
		for (User user : users.values()) {
			if (user.getEmail().equals(email)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User getByName(String name) {
		for (User user : users.values()) {
			if (user.getName().equals(name)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User getUserById(Long id) {
		for (User user : users.values()){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}

}
