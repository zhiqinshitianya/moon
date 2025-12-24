package com.example.score_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 默认扫描当前包及子包（controller、dao等都在该包下，能正常扫描）
@SpringBootApplication
public class ScoreSystemApplication {
    public static void main(String[] args) {
        // 只保留核心启动逻辑
        SpringApplication.run(ScoreSystemApplication.class, args);
    }
}