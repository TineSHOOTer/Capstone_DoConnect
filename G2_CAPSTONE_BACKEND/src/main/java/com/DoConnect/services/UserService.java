package com.DoConnect.services;


import javax.validation.Valid;

import com.DoConnect.dto.Message;
import com.DoConnect.dto.SignupRequest;
import com.DoConnect.dto.UserDto;

public interface UserService {

     void createAdminAccount();

     UserDto createUser(SignupRequest signupRequest);

     Boolean hasUserWithEmail(String email);
     public Message sendMessage(@Valid Message message);
}
