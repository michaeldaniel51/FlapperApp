package com.daniel.flapperapp.entities;


import com.daniel.flapperapp.entities.Student;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String confirmationToken;

    private LocalDate createdDate;

    @OneToOne(targetEntity = Student.class,fetch = FetchType.EAGER)
    @JoinColumn(nullable = false,name="student_id")
    private Student student;


   public ConfirmationToken(Student student){
        this.student = student;
        this.createdDate=LocalDate.now();
        this.confirmationToken= UUID.randomUUID().toString();

    }
}
