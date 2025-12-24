package com.example.score_system.entity;

// 成绩实体类（对应数据库score表）
public class Score {
    private Integer id; // 主键（自增）
    private String studentId; // 学号（关联学生表）
    private String courseName; // 课程名
    private Integer score; // 成绩

    // 无参构造
    public Score() {}

    // 有参构造（新增成绩时不用传id，数据库自增）
    public Score(String studentId, String courseName, Integer score) {
        this.studentId = studentId;
        this.courseName = courseName;
        this.score = score;
    }

    // 所有字段的get/set方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    // 重写toString
    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", score=" + score +
                '}';
    }
}