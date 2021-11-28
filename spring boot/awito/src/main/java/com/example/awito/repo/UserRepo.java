package com.example.awito.repo;

import com.example.awito.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer>{

    User findByUsername (String username);

    User findById (Long UserId);

    User findByActivationCode(String code);
}


