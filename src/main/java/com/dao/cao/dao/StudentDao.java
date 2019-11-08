package com.dao.cao.dao;

import com.dao.cao.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StudentDao {

    @Select("select name,password from student where name=#{name}")
    Student selectByName(@Param("name")String name );

    @Insert("insert into student (name,password,sex,grade) values(#{name},#{password},#{sex},#{grade})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void insert(Student student);

    @Select("select id,name,password from student where name=#{name} and password=#{password}")
    Student login(@Param("name")String name,@Param("password")String password );

    @Select("select id,name,password from student where name=#{name} and password=#{password}")
    Student login2(@Param("name") String name ,@Param("password") String password);

    @Update("update student set password=#{password},sex=#{sex},grade=#{grade} where id=#{id}")
    void update(Student student);

    @Delete("delete from student where id=#{id}")
    void delete(Integer id);




}
