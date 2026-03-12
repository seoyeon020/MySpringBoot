package com.basic.MySpringBoot.security.userinfo;

import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserInfoRepository extends ListCrudRepository<UserInfo, Long> {
    Optional<UserInfo> findByEmail(String email);
}