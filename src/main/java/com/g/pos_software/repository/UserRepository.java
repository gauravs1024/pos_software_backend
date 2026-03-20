package com.g.pos_software.repository;

import com.g.pos_software.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {



    User findByEmail(String email);

}
