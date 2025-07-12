package model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    public enum Gender {
        M('M'),
        F('F');

        private final Character code;

        Gender(Character code) {
            this.code = code;
        }

        public Character getCode() {
            return code;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Gender gender1;
    private String email;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
        this.name = "";
        this.gender1 = Gender.F;
        this.email = "";
    }

    // Getters e Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender1() {
        return gender1;
    }

    public void setGender1(Gender gender1) {
        this.gender1 = gender1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
