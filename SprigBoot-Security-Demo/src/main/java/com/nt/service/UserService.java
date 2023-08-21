package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.nt.module.User;

@Service

public class UserService {
	private List<User> userList = new ArrayList<>();

	public UserService() {
		userList.add(new User("rakesh", "rakesh123", "rakehs123@gamil.com"));
		userList.add(new User("suresh", "suresh123", "suresh123@gamil.com"));
		userList.add(new User("yogi", "yogi123", "yogi123@gamil.com"));
	}

	// get all user
	public List<User> getAlluser() {
		return this.userList;
	}

	// get single user
	public User fetchsingleUser(String username) {
		return this.userList.stream().filter(user -> user.getUsername().equals(username)).findAny().orElse(null);
	}

	// add user
	public User addUser(User user) {
		this.userList.add(user);
		return user;
	}

}
