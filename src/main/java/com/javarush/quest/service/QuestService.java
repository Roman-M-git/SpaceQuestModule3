package com.javarush.quest.service;

import com.javarush.quest.model.QuestStep;

import java.util.HashMap;
import java.util.Map;

public class QuestService {

    private final Map<String, QuestStep> steps = new HashMap<>();

    public QuestService() {
        initSteps();
    }

    private void initSteps() {

        // 1. Старт
        steps.put("start", new QuestStep(
                "start",
                "Ты потерял память. Принять вызов НЛО?",
                "Принять вызов",
                "Отклонить вызов",
                "bridge",   // ← ИСПРАВЛЕНО (было: "accept")
                "lose1"
        ));

        // 2. Мостик
        steps.put("bridge", new QuestStep(
                "bridge",
                "Ты принял вызов. Поднимаешься на мостик к капитану?",
                "Подняться на мостик",
                "Отказаться",
                "captain",
                "lose2"
        ));

        // 3. Капитан
        steps.put("captain", new QuestStep(
                "captain",
                "Ты поднялся на мостик. Ты кто?",
                "Рассказать правду о себе",
                "Солгать о себе",
                "win",
                "lose3"
        ));

        // Победа
        steps.put("win", new QuestStep(
                "win",
                "Тебя вернули домой. Победа!",
                null,
                null,
                null,
                null
        ));

        // Поражения
        steps.put("lose1", new QuestStep(
                "lose1",
                "Ты отклонил вызов. Поражение!",
                null,
                null,
                null,
                null
        ));

        steps.put("lose2", new QuestStep(
                "lose2",
                "Ты не пошел на переговоры. Поражение!",
                null,
                null,
                null,
                null
        ));

        steps.put("lose3", new QuestStep(
                "lose3",
                "Твоя ложь разоблачена. Поражение!",
                null,
                null,
                null,
                null
        ));
    }

    public QuestStep getStep(String id) {
        return steps.get(id);
    }

    public boolean isFinalStep(String stepId) {
        QuestStep step = steps.get(stepId);
        return step != null && step.getOption1() == null;
    }
}