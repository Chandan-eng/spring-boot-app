package com.nagarro.exitTestAssignment.services;

import com.nagarro.exitTestAssignment.model.UserModel;
import com.nagarro.exitTestAssignment.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public interface RegistrationService {
//    @Autowired
//     RegistrationRepository registrationRepository;
//    public UserModel saveUser(UserModel user){
//        return  registrationRepository.save(user);
//    }
//
//    public UserModel fetchUserByEmailId(String email){
//        return registrationRepository.findByEmailId(email);
//    }
//
//    public UserModel fetchUserByEmailIdAndPassword(String email,String password){
//        return registrationRepository.findByEmailIdAndPassword(email,password);
//    }

    public UserModel saveUser(UserModel user);
    public UserModel fetchUserByEmailId(String email);
    public UserModel fetchUserByEmailIdAndPassword(String email,String password);
}
