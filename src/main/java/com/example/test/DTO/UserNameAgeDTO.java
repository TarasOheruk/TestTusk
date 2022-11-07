package com.example.test.DTO;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserNameAgeDTO {

    public UserNameAgeDTO() {
    }

    public UserNameAgeDTO(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @JsonIgnore
    private Long id;

    private String name;
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
