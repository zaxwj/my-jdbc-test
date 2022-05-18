package com.dao;

import com.domain.Student.Student;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StudentDaolmpl implements StudentDao{
    /*查询所有学生信息*/
    @Override
    public ArrayList<Student> findAll(){
        Connection con =null;
        Statement stat = null;
        ResultSet rs = null;
        ArrayList<Student> list = new ArrayList<>();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sthdentdb?characterEncoding=utf-8", "root", "Forever995996");
            stat = con.createStatement();

            String sql = "SELECT * FROM student";
            rs = stat.executeQuery(sql);

            Integer sid = null;
            String name = null;
            Integer age = null;
            Date birthday = null;
            while (rs.next()) {
                sid = rs.getInt("sid");
                name = rs.getString("name");
                age = rs.getInt("age");
                birthday = rs.getDate("birthday");

                //封装Student对象
                Student stu = new Student(sid, name, age, birthday);
                //将Student对象保存到集合中
                list.add(stu);
            }


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(con!=null){
                try{
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stat!=null){
                try{
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(rs!=null){
                try{
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }
    return list;
    }

    /*条件查询*/
    @Override
    public Student findById(Integer id) {
        Student stu = new Student();
        Connection con =null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sthdentdb?characterEncoding=utf-8", "root", "Forever995996");
            stat = con.createStatement();

            String sql = "SELECT * FROM student WHERE sid='"+id+"'";
            rs = stat.executeQuery(sql);

            Integer sid = null;
            String name = null;
            Integer age = null;
            Date birthday = null;
            while (rs.next()) {
                sid = rs.getInt("sid");
                name = rs.getString("name");
                age = rs.getInt("age");
                birthday = rs.getDate("birthday");

                stu.setSid(sid);
                stu.setName(name);
                stu.setAge(age);
                stu.setBirthday(birthday);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(con!=null){
                try{
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stat!=null){
                try{
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(rs!=null){
                try{
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return stu;

    }

    /*新增学生信息*/
    @Override
    public int insert(Student stu){
        Connection con =null;
        Statement stat = null;
        int result = 0;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sthdentdb?characterEncoding=utf-8", "root", "Forever995996");
            stat = con.createStatement();

            Date d = stu.getBirthday();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = sdf.format(d);
            String sql = "INSERT INTO student VALUES('"+stu.getSid()+"','"+stu.getName()+"','"+stu.getAge()+"','"+birthday+"')";
            result = stat.executeUpdate(sql);


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(con!=null){
                try{
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stat!=null){
                try{
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }
        return result;
    }

    /*修改学生信息*/
    @Override
    public int update(Student stu){
        Connection con =null;
        Statement stat = null;
        int result = 0;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sthdentdb?characterEncoding=utf-8", "root", "Forever995996");
            stat = con.createStatement();

            Date d = stu.getBirthday();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = sdf.format(d);
            String sql = "UPDATE student SET sid='"+stu.getSid()+"',name ='"+stu.getName()+"',age = '"+stu.getAge()+"',birthday='"+birthday+"' WHENEVER sid='"+stu.getSid()+"'";
            result = stat.executeUpdate(sql);


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(con!=null){
                try{
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stat!=null){
                try{
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }
        return result;
    }
    /*删除学生信息*/
    @Override
    public int delete(Integer id){
        Connection con =null;
        Statement stat = null;
        int result = 0;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sthdentdb?characterEncoding=utf-8", "root", "Forever995996");
            stat = con.createStatement();

            String sql = "DELETE FROM student WHENEVER sid = '"+id+"'";
            result = stat.executeUpdate(sql);


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(con!=null){
                try{
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stat!=null){
                try{
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }
        return result;
    }
}
