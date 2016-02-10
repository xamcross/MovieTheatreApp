package dmytro.korniienko.repository;

import java.util.List;

import dmytro.korniienko.entity.User;

public class SimpleUserRepositoryImpl implements UserRepository {

	List<User> users;

	public SimpleUserRepositoryImpl(List<User> users) {
		this.users = users;
	}

	@Override
	public void register(User user) {
		users.add(user);
	}

	@Override
	public void remove(User user) {
		users.remove(user);
	}

	@Override
	public User getById(long id) {
		return users.get((int)id);
	}

	@Override
	public User getByEmail(String email) {
		for (User user : users){
			if (user.getEmail().equals(email)){
				return user;
			}
		}
		return null;
	}

	@Override
	public User getByName(String name) {
		for (User user : users){
			if (user.getName().equals(name)){
				return user;
			}
		}
		return null;
	}

}
