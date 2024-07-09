package com.Ariztid.UserRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Ariztid.Entity.User;
import com.Ariztid.Entity.userDetails;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	@Query("select u from User u")
	List<User> alldata();

	

	 @Query("SELECT u FROM User u WHERE u.userId = :username AND u.password = :password")
	    List<User> getdataall(String username, String password);

}
