package com.example.springbootJpa.Repository;

import com.example.springbootJpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    boolean findByEmail(String email);

//    @Modifying
//    @Query("update User u set u.name = ?1, u.email = ?2, u.address = ?3 where u.id = ?4")
//    void updateUser();
}
