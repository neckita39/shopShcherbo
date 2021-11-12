package com.shcherbo.shop.users;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<UserEntity,Long> {
    boolean existsByNumber(String number);
    UserEntity findUserEntityByNumber(String number);
}