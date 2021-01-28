package com.leaptechstudio.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leaptechstudio.app.ws.shared.Utils;
import com.leaptechstudio.app.ws.ui.model.request.UserDetailsRequestModel;
import com.leaptechstudio.app.ws.ui.model.response.UserObjectRest;
import com.leaptechstudio.app.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService {
	// TO STORE User details in the Map
	Map<String, UserObjectRest> users;
	Utils utils;

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public UserServiceImpl(Utils utils) {
		// TODO Auto-generated constructor stub
		this.utils = utils;
	}

	@Override
	public UserObjectRest createUser(UserDetailsRequestModel userObj) {
		// TODO Auto-generated method stub

		UserObjectRest obj = new UserObjectRest();
		obj.setEmail(userObj.getEmail());
		obj.setFirstName(userObj.getFirstName());
		obj.setLastName(userObj.getLastName());

		if (users == null)
			users = new HashMap<>();

		String userId = utils.generateUserId();
		obj.setUserId(userId);
		users.put(userId, obj);
		return obj;
	}

}
