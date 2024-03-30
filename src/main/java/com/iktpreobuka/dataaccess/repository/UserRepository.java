package com.iktpreobuka.dataaccess.repository;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.dataaccess.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
