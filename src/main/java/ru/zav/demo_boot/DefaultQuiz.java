package ru.zav.demo_boot;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Component
public class DefaultQuiz implements Quiz{
    private final String EMPTY = "Нет вопросов";
    private final String NONE = "Нет ответа";

    private final Map<String,String> questions = new HashMap();

    DefaultQuiz(){
        questions.put("Чапаев, и...", "Пустота");
        questions.put("Ответ на все вопросы", "42");
    }

    @Override
    public String getAnswer(String key){
        if(key == null || key.isEmpty()) return NONE;

        String value = questions.get(key);

        String answer = value == null ? NONE : value;

        return answer;
    }

    @Override
    public String getRandomQuestion(){
        if(questions.isEmpty()) return EMPTY;

        //точно не пустая
        Random rand = new Random(questions.keySet().size() - 1);
        return new ArrayList<>(questions.keySet()).get(rand.nextInt());
    }

    @Override
    public boolean answerValidate(String question, String answer){
        if(question == null || answer == null
            || question.isEmpty() || answer.isEmpty()) return false;

        return answer.equalsIgnoreCase(getAnswer(question));
    }
}
