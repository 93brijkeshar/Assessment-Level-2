package com.assessment.poc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assessment.poc.entities.UserRegistration;

@Repository
public interface UserRegistrationRepo extends JpaRepository<UserRegistration, Long>{
	
	/*@Query("select u from UserRegistration u where u.email= :email")
	public UserRegistration getUserByEmail(@Param("email") String email);*/
	
	public UserRegistration findByUsername(String username);
	
	@Query(value="select * from UserRegistration where user_id =:uid",nativeQuery=true)
	 UserRegistration getUserRegistrationDetailById(@Param("uid") Long userId);
}
