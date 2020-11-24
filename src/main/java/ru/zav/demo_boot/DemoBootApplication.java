package ru.zav.demo_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoBootApplication {
    private final Quiz mQuiz;

    private final String QSTN_CHAPAY_TEXT = "Чапаев, и...";
    private final String FAIL_TEXT = "Ошибка";

    @Autowired
    public DemoBootApplication(Quiz quiz){
        mQuiz = quiz;
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoBootApplication.class, args);
    }


    @GetMapping("/start")
    public String startHandler(@RequestParam(value = "answer", defaultValue = "") String answer_data) {
        if(answer_data.isEmpty()) return "Нужно было ввести значение!";

        return answer_data.equalsIgnoreCase(mQuiz.getAnswer(QSTN_CHAPAY_TEXT)) ? QSTN_CHAPAY_TEXT.concat(answer_data): FAIL_TEXT;
    }
}
