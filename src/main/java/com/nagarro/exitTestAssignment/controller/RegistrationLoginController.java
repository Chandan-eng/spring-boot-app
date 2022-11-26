package com.nagarro.exitTestAssignment.controller;

import com.nagarro.exitTestAssignment.model.UserModel;
import com.nagarro.exitTestAssignment.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationLoginController {
    @Autowired
    private RegistrationService service;
    @PostMapping("/registeruser")
    @CrossOrigin(origins = "http://localhost:4200")
    public UserModel registerUser(@RequestBody UserModel user) throws Exception {

        String tempEmailId=user.getEmailId();
        if(tempEmailId!=null && !"".equals(tempEmailId)){
           UserModel user1= service.fetchUserByEmailId(tempEmailId);
           if(user1!=null){
               throw new Exception("User with "+tempEmailId+" is already exist");
           }
        }
        UserModel userObj=null;
        userObj=service.saveUser(user);
        return userObj;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public UserModel loginUser(@RequestBody UserModel userModel) throws Exception {
        String tempEmailId=userModel.getEmailId();
        String tempPassword=userModel.getPassword();
        UserModel userModel1=null;
        if(tempEmailId!=null && tempPassword!=null){
            userModel1=service.fetchUserByEmailIdAndPassword(tempEmailId,tempPassword);
        }
        if(userModel1==null){
            throw new Exception("Bad Credential");
        }
        return userModel1;
    }
}
