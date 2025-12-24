package com.example.score_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.score_system.dao.StudentDao;
import com.example.score_system.entity.Student;

// 标记为REST接口控制器，返回JSON数据给前端
@RestController
// 所有学生相关请求都以/student开头
@RequestMapping("/student")
@CrossOrigin(origins = "http://127.0.0.1:5500", maxAge = 3600)
public class StudentController {
    // 创建StudentDao对象（新手简化写法，不用依赖注入）
    private final StudentDao studentDao = new StudentDao();

    // 1. 查询所有学生：GET请求，访问地址 http://localhost:8080/student/list
    @GetMapping("/list")
    public List<Student> getAllStudents() {
        // 调用dao层方法查询所有学生
        return studentDao.getAllStudents();
    }

    // 2. 新增学生：POST请求，前端传JSON格式的学生信息
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        // 调用dao层新增方法，返回结果给前端
        return studentDao.addStudent(student);
    }

    // 3. 根据学号查询学生：GET请求，参数通过URL传递（比如?studentId=2025001）
    @GetMapping("/query")
    public Student getStudentByNum(@RequestParam String studentId) {
        // 调用dao层按学号查询方法
        return studentDao.getStudentByNum(studentId);
    }
}