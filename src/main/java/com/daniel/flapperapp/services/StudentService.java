package com.daniel.flapperapp.services;

import com.daniel.flapperapp.entities.ConfirmationToken;
import com.daniel.flapperapp.entities.Student;
import com.daniel.flapperapp.repositories.ConfirmationTokenRepository;
import com.daniel.flapperapp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @Autowired
    private EmailSenderService emailSenderService;

    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();

        studentRepository.findAll().forEach(students::add);
                return students;

    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public Optional<Student> getStudent (int id){
        return studentRepository.findById(id);
    }

    public void updateStudent (int id,Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(int id){

        studentRepository.deleteById(id);
    }

    public Optional<Student> getByPhoneNumber(int phonenumber) {

        return studentRepository.findByPhonenumber(phonenumber);

    }

    public Optional<Student> getByGender(String gender){
        return studentRepository.findByGender(gender);
    }

    public Optional<Student> deleteByPhoneNumber(int phonenumber){
       return studentRepository.deleteByPhonenumber(phonenumber);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Student> optionalStudent = studentRepository.findByEmail(email);

        if(optionalStudent.isPresent()){
            return optionalStudent.get();
        }

        else {
            throw new UsernameNotFoundException(MessageFormat.format("Student with email {0} cannot be found.",email));
        }

    }

    void signUpStudent(Student student){

        final String encryptedpassword = new BCryptPasswordEncoder().encode(student.getPassword());

        student.setPassword(encryptedpassword);

        final Student createdStudent = studentRepository.save(student);

        final ConfirmationToken confirmationToken = new ConfirmationToken(student);

        confirmationTokenService.saveConfirmationToken(confirmationToken );

    }

        public void deleteConfirmationToken(long id){

        confirmationTokenRepository.deleteById(id);

    }

    void confirmStudent(ConfirmationToken confirmationToken) {

    final Student student = confirmationToken.getStudent();

    student.setEnabled(true);

    studentRepository.save(student);

    deleteConfirmationToken(confirmationToken.getId());

    }

  //      public LocalDate date(LocalDate localDate){
 //          return LocalDate.now();
 //       }



    void sendConfirmationMail(String studentMail, String token){

        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(studentMail);
        mailMessage.setSubject("Mail Confirmatiom Link!");
        mailMessage.setFrom("<MAIL>");
        mailMessage.setSentDate(Date.from(Instant.now()));
        mailMessage.setText("Thanks for registering. Please clicl on the below link to activate your account." + "http://localhost:9000/sign-up/confirm?token=" + token);

        emailSenderService.sendEmail(mailMessage);
    }

}
