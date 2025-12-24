package com.example.score_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.score_system.dao.ScoreDao;
import com.example.score_system.entity.Score;

@RestController
@RequestMapping("/score") // 所有成绩相关请求以/score开头
@CrossOrigin(origins = "http://127.0.0.1:5500", maxAge = 3600)
public class ScoreController {
    // 创建ScoreDao对象
    private final ScoreDao scoreDao = new ScoreDao();

    // 1. 查询所有成绩：GET请求，访问地址 http://localhost:8080/score/list
    @GetMapping("/list")
    public List<Score> getAllScores() {
        return scoreDao.getAllScores();
    }

    // 2. 新增成绩：POST请求，接收前端JSON数据
    @PostMapping("/add")
    public String addScore(@RequestBody Score score) {
        return scoreDao.addScore(score);
    }

    // 3. 根据学号查询成绩：GET请求，URL传参
    @GetMapping("/query")
    public List<Score> getScoreByNum(@RequestParam String studentId) {
        return scoreDao.getScoreByNum(studentId);
    }
}