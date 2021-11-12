package com.shcherbo.shop.users;

import com.shcherbo.shop.rest.dto.user.User;

public interface UserService {
    UserEntity  addUser(User user);
}