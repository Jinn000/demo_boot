package ru.zav.demo_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class QuestionController {
    private final Quiz mQuiz;

    private final String QSTN_CHAPAY_TEXT = "Чапаев, и...";
    private final String FAIL_TEXT = "Ошибка";

    @Autowired
    public QuestionController(Quiz quiz){
        mQuiz = quiz;
    }

    @GetMapping("/start")
    public String startHandler(@RequestParam(value = "answer", defaultValue = "") String answer_data) {
        if(answer_data.isEmpty()) return "Нужно было ввести значение!";

        return answer_data.equalsIgnoreCase("Пустота") ? QSTN_CHAPAY_TEXT.concat(answer_data): FAIL_TEXT;
    }
}
