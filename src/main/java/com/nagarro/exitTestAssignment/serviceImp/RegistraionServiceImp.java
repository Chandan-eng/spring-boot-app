package com.nagarro.exitTestAssignment.serviceImp;

import com.nagarro.exitTestAssignment.model.UserModel;
import com.nagarro.exitTestAssignment.repository.RegistrationRepository;
import com.nagarro.exitTestAssignment.services.RegistrationService;
import org.springframework.stereotype.Service;

@Service
public class RegistraionServiceImp implements RegistrationService {
    private final RegistrationRepository registrationRepository;

    public RegistraionServiceImp(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public UserModel saveUser(UserModel user) {
        return  registrationRepository.save(user);
    }

    @Override
    public UserModel fetchUserByEmailId(String email) {
        return registrationRepository.findByEmailId(email);
    }

    @Override
    public UserModel fetchUserByEmailIdAndPassword(String email, String password) {
        return registrationRepository.findByEmailIdAndPassword(email,password);
    }
}
