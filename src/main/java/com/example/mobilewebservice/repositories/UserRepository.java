package com.example.mobilewebservice.repositories;

import com.example.mobilewebservice.models.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <UserEntity, Long> {

}
