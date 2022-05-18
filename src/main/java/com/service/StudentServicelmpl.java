package com.service;

import com.dao.StudentDao;
import com.dao.StudentDaolmpl;
import com.domain.Student.Student;

import java.util.ArrayList;

public class StudentServicelmpl implements StudentService{
    private StudentDao dao = new StudentDaolmpl();
    //查询所有学生信息
    @Override
    public ArrayList<Student> findAll(){
        return dao.findAll();
    }

    //条件查询
    @Override
    public Student findById(Integer id){
        return dao.findById(id);
    }
    //新增学生信息
    @Override
    public int insert(Student stu){
        return dao.insert(stu);
    }
    //修改学生信息
    @Override
    public int update(Student stu){
        return dao.update(stu);
    }

    //删除学生信息
    @Override
    public int delete(Integer id){
        return dao.delete(id);
    }



}
