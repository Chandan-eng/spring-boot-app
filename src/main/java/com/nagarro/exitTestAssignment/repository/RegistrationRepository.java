package com.nagarro.exitTestAssignment.repository;

import com.nagarro.exitTestAssignment.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<UserModel,Integer> {
    public UserModel findByEmailId(String emailId);
    public UserModel findByEmailIdAndPassword(String emailId,String password);
}
