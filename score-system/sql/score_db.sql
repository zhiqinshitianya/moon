-- score_db.sql 内容
CREATE DATABASE IF NOT EXISTS score_db;
USE score_db;

-- 学生表
CREATE TABLE student (
    student_id VARCHAR(20) PRIMARY KEY COMMENT '学号（主键）',
    student_name VARCHAR(50) NOT NULL COMMENT '姓名',
    gender VARCHAR(10) COMMENT '性别',
    clazz VARCHAR(20) COMMENT '班级'
);

-- 成绩表
CREATE TABLE score (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    student_id VARCHAR(20) COMMENT '学号',
    course_name VARCHAR(50) COMMENT '课程名',
    score INT COMMENT '成绩'
);