package com.dao.cao.service;

import Utils.AESutil;
import com.dao.cao.dao.StudentDao;
import com.dao.cao.entity.Student;
import com.dao.cao.md5.MD5;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public Student selectByName(String name) {
        return studentDao.selectByName(name);
    }

    @Override
    public int insert(Student student) {
        /*String pwd = MD5.getMD5(student.getPassword());
        student.setPassword(pwd);*/
        String key = "123456";
        String pwd = AESutil.encrypt(student.getPassword(),key);
        student.setPassword(pwd);
        studentDao.insert(student);
        return student.getId();
    }

    @Override
    public Student login(String name, String password) {

//       String pwd = MD5.getMD5(password);
        String key = "123456";
        String pwd = AESutil.encrypt(password,key);
        Student student = studentDao.login(name, pwd);

        if(student == null){
            return new Student();
        }

        String pass = AESutil.decrypt(student.getPassword(),key);
        student.setPassword(pass);

        return student;
    }

    @Override
    public Student login2(String name , String password){
        String key = "123456";
        String pdd =AESutil.encrypt(password,key);
        studentDao.login2(name,pdd);

        return studentDao.login2(name,pdd);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public void delete(Integer id) {
        studentDao.delete(id);
    }


}
