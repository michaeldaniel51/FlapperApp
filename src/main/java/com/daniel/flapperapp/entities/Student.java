package com.daniel.flapperapp.entities;


import com.daniel.flapperapp.enums.UserRole;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Entity(name="STUDENTS")
@Data
public class Student implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int id;

    @NotNull(message = "Name Field Cannot Be Null")
    @Column(name = "FULL_NAME")
    private String name;

    @NotNull(message = "Gender Field Cannot Be Null")
    @Column(name= "GENDER")
    private String gender;

    @NotNull(message = "Please Enter Your Username")
    @Column(name= "USERNAME")
    private String username;

    @NotNull(message = "Please Enter Password")
    @Column(name = "PASSWORD")
    private String password;

    @NotNull(message = "Please Enter a Valid Phonenumber")
    @Column(name= "PHONENUMBER")
    private int phonenumber;

    @NotNull(message = "Please Enter a Valid Email")
    @Column(name= "EMAIL")
    private String email;


    @NotNull(message = "Please Enter Your State of Origin")
    @Column(name="STATE")
    private String state_of_origin;

    @NotNull(message = "Please Enter Local Government Of Origin")
    @Column(name = "LOCAL_GOVERNMENT_AREA")
    private String lga;

    @Column(name= "BALANCE")
    private int balance;

    @OneToMany
    private List<Transaction> transactions;

    public String getLga() {
        return lga;
    }

    public void setLga(String lga) {
        this.lga = lga;
    }

    public String getState_of_origin() {
        return state_of_origin;
    }

    public void setState_of_origin(String state_of_origin) {
        this.state_of_origin = state_of_origin;
    }


    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


    @Builder.Default
    private UserRole userRole= UserRole.USER;

    @Builder.Default
    private Boolean locked = false;

    @Builder.Default
    private Boolean enabled =false;


    public Student(int id, @NotNull(message = "Name Field Cannot Be Null") String name, @NotNull(message = "Gender Field Cannot Be Null") String gender, @NotNull(message = "Please Enter Your Username") String username, @NotNull(message = "Please Enter Password") String password, @NotNull(message = "Please Enter a Valid Phonenumber") int phonenumber, @NotNull(message = "Please Enter a Valid Email") String email, @NotNull(message = "Please Enter Your State of Origin") String state_of_origin, @NotNull(message = "Please Enter Local Government Of Origin") String lga) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.phonenumber = phonenumber;
        this.email = email;
        this.state_of_origin = state_of_origin;
        this.lga = lga;

    }


    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userRole.name());

        return Collections.singletonList(simpleGrantedAuthority);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

