package com.dao.cao.controller;

import com.dao.cao.entity.Response;
import com.dao.cao.entity.Student;
import com.dao.cao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.usagetracker.UsageTrackerClient;


import static com.dao.cao.entity.Response.failure;
import static com.dao.cao.entity.Response.success;

@Controller
public class RestController {
    @Autowired

    private StudentService studentService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    @SuppressWarnings("unchecked")
    public Response<Integer> insert(@RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "password", required = false) String password,
        @RequestParam(value = "sex", required = false) String sex,
        @RequestParam(value = "grade", required = false) String grade) {
            Student student = new Student();
            student.setName(name);
        student.setPassword(password);
        student.setSex(sex);
        student.setGrade(grade);
        Student exitstudent = studentService.selectByName(student.getName());
        if (exitstudent != null) {
            return failure(1);

        } else {

            int insert = studentService.insert(student);
            return success(insert);
        }
    }

    @RequestMapping(value = "/selectByName", method = RequestMethod.GET)
    @ResponseBody
    @SuppressWarnings("unchecked")
    public Response<Student> selectByName(@RequestParam(value = "name") String name) {
        Student student = studentService.selectByName(name);
        return success(student);

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    @SuppressWarnings("unchecked")
    public Response<Student> login(@RequestParam(value = "name",required = false) String name,
                                   @RequestParam(value = "password",required = false) String password) {
        Student userId = studentService.login(name, password);

        return success(userId);
    }

    @RequestMapping(value = "/login2",method =RequestMethod.GET)
    @ResponseBody
    @SuppressWarnings("unchecked")
    public Response<Student> login2(@RequestParam(value = "name",required = false) String name,
                                    @RequestParam(value = "password",required = false) String password){
        Student stu = studentService.login2(name,password);
        if (stu ==null){
            return failure(5);
        }else {
            return success(stu);
        }

    }


    @RequestMapping(value ="/update",method = RequestMethod.GET)
    @ResponseBody
    public Response<Void> update(@RequestParam(value = "id",required = false)Integer id,
            @RequestParam(value ="password",required = false)String password,
                               @RequestParam(value = "sex",required = false)String sex,
                               @RequestParam(value = "grade",required = false)String grade){
        Student student=new Student();
        student.setId(id);
        student.setPassword(password);
        student.setSex(sex);
        student.setGrade(grade);
        studentService.update(student);
        return success(3);
    }


    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    public Response<Void>delete(@RequestParam(value = "id",required = false)Integer id){
        studentService.delete(id);
        return success(4);
    }












}
