package com.example.testeSol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ScoreController {

    private static final Logger logger = LoggerFactory.getLogger(ScoreController.class);

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/verify")
    public Map<String, Integer> verifyScore(@RequestBody String score) {
        logger.info("Received score: {}", score);
        score = score.replace("\"", ""); // Remover aspas extras se existirem
        int combinations = scoreService.calculateCombinations(score);
        Map<String, Integer> response = new HashMap<>();
        response.put("combinations", combinations);
        return response;
    }
}
