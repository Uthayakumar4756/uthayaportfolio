package com.Ariztid.Service;

import java.util.List;

import com.Ariztid.Entity.User;
import com.Ariztid.Entity.userDetails;

public interface userService {

	public void saveuserdetails(userDetails user);
	
	public List<User> alldata();
	
	public List<userDetails> getuserdetailsemail(String email);
	
	public List<User> getdataall(String string, String string2);
	
	public User saveuser(User user);

	public List<userDetails> getUserDetailsUser(String local);
}
