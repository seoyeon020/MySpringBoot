package com.basic.MySpringBoot.Controller;

import com.basic.MySpringBoot.entity.User;
import com.basic.MySpringBoot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/thymeleaf")
    public String leaf(Model model) {
        model.addAttribute("name","스프링부트");
        return "leaf";
    }

    @GetMapping("/index")
    public ModelAndView index() {
        List<User> userList = userRepository.findAll();
        return new ModelAndView("index","users",userList);
    }
}
