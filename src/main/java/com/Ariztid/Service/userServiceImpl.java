package com.Ariztid.Service;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ariztid.Entity.User;
import com.Ariztid.Entity.userDetails;
import com.Ariztid.UserRepo.UserDetailsRepo;
import com.Ariztid.UserRepo.UserRepo;


@Service
public class userServiceImpl implements userService{

	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private UserDetailsRepo userDetailrepo;

	
//	 @Autowired
//	    private PasswordEncoder passwordEncoder;
	
	
	public User saveuser(User user) {
//		 user.setPassword(passwordEncoder.encode(user.getPassword()));
		  return repo.save(user);
	}
	public List<User> getdataall(String string, String string2){
		return repo.getdataall(string,string2);
	}
	
	public void saveuserdetails(userDetails user) {
		userDetailrepo.save(user);
	}
	
	public List<User> alldata() {
		return repo.alldata();
	}
	@Override
	public List<userDetails> getuserdetailsemail(String email) {
		
		return userDetailrepo.getuserdetailsemail(email);
	}
	@Override
	public List<userDetails> getUserDetailsUser(String local) {
		return userDetailrepo.getUserDetailsByUserId(local);
	}
	
	

}
