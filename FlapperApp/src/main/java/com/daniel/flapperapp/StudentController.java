package com.daniel.flapperapp;

import com.daniel.flapperapp.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class StudentController {


    @Autowired
    private ConfirmationTokenService confirmationTokenService;


    @Autowired
    private StudentService studentService;



    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/students")
    public void addStudent (Student student) {
        studentService.addStudent(student);

    }

    @GetMapping("/students/{id}")
    public Optional<Student> getStudentById(@PathVariable int id){
        return studentService.getStudent(id);
    }

    @PutMapping("/students/{id}")
    public void updateStudent (@PathVariable int id,@RequestBody Student student) {
        studentService.updateStudent(id, student);

    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }

    @GetMapping("/students/{phonenumber}")
    public Optional<Student> getByPhoneNumber(@PathVariable int phonenumber) {

        return studentService.getByPhoneNumber(phonenumber);

    }
    @GetMapping("/students/{gender}")
    public Optional<Student> getByGender(@PathVariable String gender) {
        return studentService.getByGender(gender);
    }

    @DeleteMapping("/students{phonenumber}")
    public Optional<Student> deleteByPhoneNumber(int phonenumber) {
        return studentService.deleteByPhoneNumber(phonenumber);
    }



 //   @GetMapping("/sign-up")
   // String signUp(){
//
  //      return "sign-up";
//
  //  }




    }



