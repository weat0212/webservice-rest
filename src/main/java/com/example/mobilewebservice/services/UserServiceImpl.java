package com.example.mobilewebservice.services;

import com.example.mobilewebservice.api.UserDto;
import com.example.mobilewebservice.api.Utils;
import com.example.mobilewebservice.models.entity.UserEntity;
import com.example.mobilewebservice.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    Utils utils;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, Utils utils, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.utils = utils;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDto createUser(UserDto userDto) {

        if (userRepository.findByEmail(userDto.getEmail()) != null) throw new RuntimeException("Record already Exists");

        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);

        String publicUserId = utils.generateUserId(30);
        userEntity.setUserId(publicUserId);
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userEntity.setEmailVerificationToken("123");

        UserEntity storedUserDetails = userRepository.save(userEntity);
        UserDto returnValue = modelMapper.map(storedUserDetails, UserDto.class);

        return returnValue;
    }

    @Override
    public UserDto getUser(String userName) {

        ModelMapper modelMapper = new ModelMapper();;

        UserEntity userEntity = new UserEntity();
        userEntity = userRepository.findByEmail(userName);

        UserDto returnDto = new UserDto();
        returnDto = modelMapper.map(userEntity, UserDto.class);

        return returnDto;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);

        if (userEntity == null)
            throw new UsernameNotFoundException(email);

        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(),
                userEntity.getEmailVerificationStatus(),
                true, true,
                true, new ArrayList<>());
    }
}
