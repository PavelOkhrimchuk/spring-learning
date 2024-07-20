package com.ohrim.spring.http.controller;

import com.ohrim.spring.database.entity.Role;
import com.ohrim.spring.dto.UserReadDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api/v1")
@SessionAttributes({"user"})
public class GreetingController {

    @ModelAttribute("roles")
    public List<Role> roles() {
        return Arrays.asList(Role.values());
    }

    @GetMapping(value = "/hello")
    public String hello(Model model, HttpServletRequest request, @ModelAttribute("userReadDto") UserReadDto userReadDto) {

        model.addAttribute("user", userReadDto);

        return "greeting/hello";
    }

    @GetMapping(value = "/hello/{id}")
    public ModelAndView hello2(ModelAndView modelAndView, HttpServletRequest request,
                              @RequestParam  Integer age,
                              @RequestHeader String accept,
                              @CookieValue("JSESSIONID") String jssesionId,
                              @PathVariable Integer id) {
        var ageParamValue = request.getParameter("age");
        var acceptHeader = request.getHeader("accept");
        var cookies = request.getCookies();

        modelAndView.setViewName("greeting/hello");

        return modelAndView;
    }

    @GetMapping(value = "/bye")
    public String bye(@SessionAttribute("user") UserReadDto user, Model model) {

        return "greeting/bye";
    }
}
