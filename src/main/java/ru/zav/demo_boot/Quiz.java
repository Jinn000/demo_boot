package ru.zav.demo_boot;

public interface Quiz {
    String getAnswer(String key);
    String getRandomQuestion();
    boolean answerValidate(String question, String answer);
}
