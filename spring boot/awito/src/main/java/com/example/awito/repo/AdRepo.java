package com.example.awito.repo;

import com.example.awito.entity.Ad;
import com.example.awito.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface AdRepo extends CrudRepository<Ad, Integer>{


    Ad findByAuthor (User author);
    //Ad findByUser_Id (Long userId);
}


