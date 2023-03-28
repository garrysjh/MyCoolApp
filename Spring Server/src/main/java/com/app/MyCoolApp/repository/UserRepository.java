package com.app.MyCoolApp.repository;

import com.app.MyCoolApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Transactional
    @Modifying
    @Query(value= "INSERT INTO USER(username, password, firstname, lastname, mobile) VALUES(:username, :password, :firstname, :lastname, :mobile)", nativeQuery = true)
        int registerNewUser(@Param("username") String username,
                            @Param("password") String password,
                            @Param("firstname") String firstname,
                            @Param("lastname") String lastname,
                            @Param("mobile") String mobile);
    }


