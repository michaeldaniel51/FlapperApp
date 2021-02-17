package com.daniel.flapperapp;

import com.daniel.flapperapp.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/sign-up")
public class SignUpController {



    @Autowired
    private StudentService studentService;


    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @GetMapping
    String signUp() {

        return "sign-up";
    }


    @PostMapping("/sign-up")
    String signUp(Student student) {

        studentService.signUpStudent(student);

        return "redirect:/sign-up";

    }

    @GetMapping("/confirm")
    String confirmMail(@RequestParam("token") long token) {

        Optional<ConfirmationToken> optionalConfirmationToken = confirmationTokenService.findConfirmationTokenByToken(token);

        optionalConfirmationToken.ifPresent(studentService::confirmStudent);

        return "/sign-in";
    }
}