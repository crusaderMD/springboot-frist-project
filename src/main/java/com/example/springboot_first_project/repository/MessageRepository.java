package com.example.springboot_first_project.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {

    public String getMessage(){
        return "Hello from repository!";
    }
}
