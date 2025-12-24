package com.example.score_system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.score_system.entity.Student;
import com.example.score_system.util.DBUtil;

// 学生数据操作类（实现增、查功能）
public class StudentDao {
    // 新增学生
    public String addStudent(Student student) {
        Connection conn = DBUtil.getConnection();
        String sql = "INSERT INTO student(student_id, student_name, gender, clazz) VALUES (?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 给SQL的?赋值
            pstmt.setString(1, student.getStudentId());
            pstmt.setString(2, student.getStudentName());
            pstmt.setString(3, student.getGender());
            pstmt.setString(4, student.getClazz());
            // 执行新增
            int result = pstmt.executeUpdate();
            if (result > 0) {
                return "新增学生成功";
            }
        } catch (SQLException e) {
            System.out.println("新增学生失败：" + e.getMessage());
        } finally {
            DBUtil.closeConnection(conn);
        }
        return "新增学生失败";
    }

    // 查询所有学生
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        String sql = "SELECT * FROM student";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            // 遍历结果集，封装成Student对象
            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getString("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setGender(rs.getString("gender"));
                student.setClazz(rs.getString("clazz"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            System.out.println("查询所有学生失败：" + e.getMessage());
        } finally {
            DBUtil.closeConnection(conn);
        }
        return studentList;
    }

    // 根据学号查询学生
    public Student getStudentByNum(String studentId) {
        Student student = null;
        Connection conn = DBUtil.getConnection();
        String sql = "SELECT * FROM student WHERE student_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setStudentId(rs.getString("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setGender(rs.getString("gender"));
                student.setClazz(rs.getString("clazz"));
            }
        } catch (SQLException e) {
            System.out.println("根据学号查询学生失败：" + e.getMessage());
        } finally {
            DBUtil.closeConnection(conn);
        }
        return student;
    }
}