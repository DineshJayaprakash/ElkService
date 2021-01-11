package com.elkService.ElkService.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.elkService.ElkService.Model.User;


@Repository
public interface UserOps extends JpaRepository<User, Long> {
	
	@Query("select u from User u where u.userId=?1")
	public User findByUserId(long id);

}
