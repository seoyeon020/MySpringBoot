package com.basic.MySpringBoot.Controller;

import com.basic.MySpringBoot.entity.User;
import com.basic.MySpringBoot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserRestController {
    private final UserRepository userRepository;

    //Constructor Injection
//    public UserRestController(UserRepository userRepository) {
//        log.info("UserRepository 구현클래스명 = {}",userRepository.getClass().getName());
//        this.userRepository = userRepository;
//    }

    //User 등록
    @PostMapping
    public User create(@RequestBody User userDetail) {
        return userRepository.save(userDetail);
    }

    //user 목록조회
    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
