package com.javarush.quest.service;
import com.javarush.quest.service.QuestService;
import com.javarush.quest.model.QuestStep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuestServiceTest {

    private QuestService questService;

    @BeforeEach
    void setUp() {
        questService = new QuestService();
    }

    @Test
    void shouldReturnStartStep() {
        QuestStep start = questService.getStep("start");

        assertNotNull(start);
        assertEquals("start", start.getId());
        assertEquals("Принять вызов", start.getOption1());
        assertEquals("Отклонить вызов", start.getOption2());
        assertEquals("bridge", start.getNextStepId1());
        assertEquals("lose1", start.getNextStepId2());
    }

    @Test
    void shouldReturnBridgeStep() {
        QuestStep bridge = questService.getStep("bridge");

        assertNotNull(bridge);
        assertEquals("bridge", bridge.getId());
        assertEquals("captain", bridge.getNextStepId1());
        assertEquals("lose2", bridge.getNextStepId2());
    }

    @Test
    void shouldReturnCaptainStep() {
        QuestStep captain = questService.getStep("captain");

        assertNotNull(captain);
        assertEquals("captain", captain.getId());
        assertEquals("win", captain.getNextStepId1());
        assertEquals("lose3", captain.getNextStepId2());
    }

    @Test
    void shouldDetectFinalWinStep() {
        assertTrue(questService.isFinalStep("win"));
    }

    @Test
    void shouldDetectFinalLoseStep() {
        assertTrue(questService.isFinalStep("lose1"));
        assertTrue(questService.isFinalStep("lose2"));
        assertTrue(questService.isFinalStep("lose3"));
    }

    @Test
    void shouldReturnNullForUnknownStep() {
        QuestStep step = questService.getStep("unknown");

        assertNull(step);
    }

    @Test
    void unknownStepIsNotFinal() {
        assertFalse(questService.isFinalStep("unknown"));
    }
}