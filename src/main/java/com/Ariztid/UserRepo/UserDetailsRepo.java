package com.Ariztid.UserRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Ariztid.Entity.userDetails;

@Repository
public interface UserDetailsRepo extends JpaRepository<userDetails, Integer> {

	 @Query("FROM userDetails WHERE (:email IS NULL OR email = :email)" )
	   List<userDetails> getuserdetailsemail(String email);
	
	   
	   @Query("SELECT ud FROM userDetails ud WHERE ud.user.userId = :userId")
	    List<userDetails> getUserDetailsByUserId(@Param("userId") String userId);
}
