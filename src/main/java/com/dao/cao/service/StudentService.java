package com.dao.cao.service;

import com.dao.cao.entity.Student;

public interface StudentService {
    Student selectByName(String name);
    int insert(Student student);
    Student login(String name,String password);
    void update(Student student);
    void delete(Integer id);
    Student login2(String name , String password);
}
