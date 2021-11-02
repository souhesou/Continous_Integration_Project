package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.User;

@Repository
public interface UserRepository extends  CrudRepository<User, Long> {


}
 




















//NOSONAR List<User> findByFirstName(String fname);
//NOSONAR List<User> findByLastName(String lname);
//NOSONAR List<User> findByIdGreaterThan(int lname);
	
//NOSONAR	@Query("SELECT MAX((e.id), 0) FROM User e") 
//NOSONAR	Long getMaxId(); 
	
//NOSONAR	// JPQL Update : 
//NOSONAR	@Modifying
//NOSONAR	@Query("update User u set u.role = :role where u.firstName = :fname")
//NOSONAR	int updateUserStatusForFirstName(@Param("role") Integer status, @Param("fname") String fname);

	//NOSONAR Native Update : 
//NOSONAR	@Modifying
//NOSONAR	@Query(value = "update User u set u.status = ? where u.name = ?", nativeQuery = true)
//NOSONAR	int updateUserStatusForFirstName1(Integer status, String name);
	
//NOSONAR	@Modifying
//NOSONAR	@Query(value = "insert into Users (firstName, lastName, role) values (:fn, :ln, :role)", nativeQuery = true)
//NOSONAR	void insertUser(@Param("fn") String fn, @Param("ln") Integer ln, @Param("role") Integer role);
