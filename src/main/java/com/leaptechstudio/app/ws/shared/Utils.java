package com.leaptechstudio.app.ws.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;
@Service   //To create the instance of utility class, we user Service annotation
public class Utils {

	public String generateUserId() {
		return UUID.randomUUID().toString();
	}
}
