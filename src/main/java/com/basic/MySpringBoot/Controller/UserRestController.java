package com.basic.MySpringBoot.Controller;

import com.basic.MySpringBoot.entity.User;
import com.basic.MySpringBoot.exception.BusinessException;
import com.basic.MySpringBoot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    //User 목록조회
    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    //Id로 User 조회
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User existUser = getExistUser(optionalUser);
        return existUser;
    }

    private static User getExistUser(Optional<User> optionalUser) {
        User existUser = optionalUser
                .orElseThrow(() -> new BusinessException("User Not Found", HttpStatus.NOT_FOUND));
        return existUser;
    }

    //Email 조회하고 수정하기
    @PatchMapping("/{email}/")
    public User updateUser(@PathVariable String email, @RequestBody User userDetail) {
        User existUser = getExistUser(userRepository.findByEmail(email));
        existUser.setName(userDetail.getName());
        return userRepository.save(existUser);
    }

    //User 삭제하기
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = getExistUser(optionalUser);
        userRepository.delete(user);
        //return ResponseEntity.ok(user);
        return ResponseEntity.ok("Id = " + id + "User가 삭제 되었습니다.");
    }


    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }
}
