package com.uxpsystems.assignement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uxpsystems.assignement.model.User;

@Repository

public interface UserRepository extends JpaRepository<User,Long>{

}
