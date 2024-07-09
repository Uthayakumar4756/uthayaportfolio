package com.Ariztid.Controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Ariztid.Entity.User;
import com.Ariztid.Entity.userDetails;
import com.Ariztid.Service.userService;
import com.Ariztid.Service.userServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


@Controller
public class UserController {

	@Autowired
	private userService service;
	

	@RequestMapping("/")
	@CrossOrigin(origins = "http://localhost:9098", methods = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	 @PostMapping(value="/userList")
	 @CrossOrigin(origins = "http://localhost:9098", methods = {RequestMethod.POST})
	 public ResponseEntity<List<userDetails>> userLoginData(@RequestBody String local) {
		    //    ModelAndView model = new ModelAndView("userLogin"); 
		 
	        List<userDetails> details = service.getuserdetailsemail(local);
	        List<userDetails> login = service.getUserDetailsUser(local);
	        return ResponseEntity.ok().body(login);
	    }

	@PostMapping(value="/userLogins")
	@CrossOrigin(origins = "http://localhost:9098", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
	public ResponseEntity<String> userLogin(@RequestBody User user) {
	    List<User> allData = service.getdataall(user.getUserId(),user.getPassword());
	    if (allData.isEmpty()) {
	    	return new ResponseEntity<String>("signup",HttpStatus.UNAUTHORIZED); // Login success
	    } else {
	        for (User userData : allData) {
	            if (user.getUserId().equalsIgnoreCase(userData.getUserId())) {
	            	if (user.getPassword().equals(userData.getPassword())) {
	            		return new ResponseEntity<String>("success",HttpStatus.OK); // Login success
	                }
	            } else {
	            	return new ResponseEntity<String>("error",HttpStatus.UNAUTHORIZED); // Invalid password
	                }
	        }
	    }
	    return new ResponseEntity<String>("not found",HttpStatus.NOT_FOUND); // User not found
	}
	
	@PostMapping(value="/signup")
	@CrossOrigin(origins = "http://localhost:9098", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
	public ResponseEntity<String> SignUp(@RequestBody userDetails user) {
		service.saveuserdetails(user);
		User userdata = new User();
		userdata.setUserId(user.getEmail());
		userdata.setPassword(user.getPassword());
		service.saveuser(userdata);
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}


}
