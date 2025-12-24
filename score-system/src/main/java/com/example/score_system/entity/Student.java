package com.example.score_system.entity;

// 学生实体类（对应数据库student表）
public class Student {
    // 字段和数据库表一一对应
    private String studentId; // 学号
    private String studentName; // 姓名
    private String gender; // 性别
    private String clazz; // 班级

    // 无参构造（必须有）
    public Student() {}

    // 有参构造（方便新增数据）
    public Student(String studentId, String studentName, String gender, String clazz) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.clazz = clazz;
    }

    // 所有字段的get/set方法（必须有，前端传值要用）
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    // 重写toString，方便调试
    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                ", clazz='" + clazz + '\'' +
                '}';
    }
}