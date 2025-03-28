package com.leaptechstudio.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leaptechstudio.app.ws.exception.UserServiceException;
import com.leaptechstudio.app.ws.ui.model.request.UserDetailsRequestModel;
import com.leaptechstudio.app.ws.ui.model.request.updateUserDetailsRequestModel;
import com.leaptechstudio.app.ws.ui.model.response.UserObjectRest;
import com.leaptechstudio.app.ws.userservice.UserService;
import com.leaptechstudio.app.ws.userservice.impl.UserServiceImpl;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

//TO STORE User details in the Map
	Map<String, UserObjectRest> users;
	
	@Autowired
	UserService userService;

	@GetMapping()
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "40") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "getUser was called with page= " + page + " and limit= " + limit + " and sort= " + sort;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })

	public ResponseEntity<UserObjectRest> getUser(@PathVariable String userId) {
		
	
		if (users.containsKey(userId)) {
			return new ResponseEntity<UserObjectRest>(users.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<UserObjectRest>(HttpStatus.NO_CONTENT);
		}

	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })

	public ResponseEntity<UserObjectRest> createUser(@Valid @RequestBody UserDetailsRequestModel userObj) {

		UserObjectRest obj= userService.createUser(userObj);

		return new ResponseEntity<UserObjectRest>(obj, HttpStatus.ACCEPTED);
	}

	@PutMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UserObjectRest updateUser(@PathVariable String userId,
			@Valid @RequestBody updateUserDetailsRequestModel userObj) {
		UserObjectRest storedUserDetails = users.get(userId);
		storedUserDetails.setFirstName(userObj.getFirstName());
		storedUserDetails.setLastName(userObj.getLastName());
		users.put(userId, storedUserDetails);
		return storedUserDetails;
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		users.remove(id);
		return ResponseEntity.noContent().build();		
	}

}
