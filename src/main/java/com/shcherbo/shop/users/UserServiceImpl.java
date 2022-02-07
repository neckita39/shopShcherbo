package com.shcherbo.shop.users;

import com.shcherbo.shop.rest.dto.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserEntity addUser(User user) {
        if (!userRepository.existsByNumber(user.getNumber())){
            UserEntity userEntity = new UserEntity();
            userEntity.setId(user.getId());
            userEntity.setNumber(user.getNumber());
            userEntity.setName(user.getName());
            userRepository.saveAndFlush(userEntity);
        }
        return userRepository.findUserEntityByNumber(user.getNumber());
    }
}