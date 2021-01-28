package com.leaptechstudio.app.ws.userservice;

import com.leaptechstudio.app.ws.ui.model.request.UserDetailsRequestModel;
import com.leaptechstudio.app.ws.ui.model.response.UserObjectRest;

public interface UserService {
	UserObjectRest createUser(UserDetailsRequestModel userObj);
}
