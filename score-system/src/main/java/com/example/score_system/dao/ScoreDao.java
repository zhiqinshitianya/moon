package com.example.score_system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.score_system.entity.Score;
import com.example.score_system.util.DBUtil;

// 成绩数据操作类
public class ScoreDao {
    // 新增成绩
    public String addScore(Score score) {
        Connection conn = DBUtil.getConnection();
        String sql = "INSERT INTO score(student_id, course_name, score) VALUES (?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, score.getStudentId());
            pstmt.setString(2, score.getCourseName());
            pstmt.setInt(3, score.getScore());
            int result = pstmt.executeUpdate();
            if (result > 0) {
                return "新增成绩成功";
            }
        } catch (SQLException e) {
            System.out.println("新增成绩失败：" + e.getMessage());
        } finally {
            DBUtil.closeConnection(conn);
        }
        return "新增成绩失败";
    }

    // 查询所有成绩
    public List<Score> getAllScores() {
        List<Score> scoreList = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        String sql = "SELECT * FROM score";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Score score = new Score();
                score.setId(rs.getInt("id"));
                score.setStudentId(rs.getString("student_id"));
                score.setCourseName(rs.getString("course_name"));
                score.setScore(rs.getInt("score"));
                scoreList.add(score);
            }
        } catch (SQLException e) {
            System.out.println("查询所有成绩失败：" + e.getMessage());
        } finally {
            DBUtil.closeConnection(conn);
        }
        return scoreList;
    }

    // 根据学号查询成绩
    public List<Score> getScoreByNum(String studentId) {
        List<Score> scoreList = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        String sql = "SELECT * FROM score WHERE student_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Score score = new Score();
                score.setId(rs.getInt("id"));
                score.setStudentId(rs.getString("student_id"));
                score.setCourseName(rs.getString("course_name"));
                score.setScore(rs.getInt("score"));
                scoreList.add(score);
            }
        } catch (SQLException e) {
            System.out.println("根据学号查询成绩失败：" + e.getMessage());
        } finally {
            DBUtil.closeConnection(conn);
        }
        return scoreList;
    }
}