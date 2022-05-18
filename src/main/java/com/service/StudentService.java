package com.service;

import com.domain.Student.Student;

import java.util.ArrayList;

public interface StudentService {
    //查询所有学生信息
    public abstract ArrayList<Student> findAll();

    //条件查询
    public abstract Student findById(Integer id);

    //新增学生信息
    public abstract int insert(Student stu);

    //修改学生信息
    public abstract int update(Student stu);

    //删除学生信息
    public abstract int delete(Integer id);


}
