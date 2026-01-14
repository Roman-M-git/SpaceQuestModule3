package com.javarush.quest;

import com.javarush.quest.model.QuestStep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;

class GameServletTest {

    private GameServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher dispatcher;

    @BeforeEach
    void setUp() {
        servlet = new GameServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        dispatcher = mock(RequestDispatcher.class);

        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("");
        when(request.getRequestDispatcher("/game.jsp")).thenReturn(dispatcher);
    }

    // ---------- doGet ----------

    @Test
    void doGet_withoutStep_shouldShowStart() throws Exception {
        when(request.getParameter("step")).thenReturn(null);

        servlet.doGet(request, response);

        verify(request).setAttribute(eq("step"), any(QuestStep.class));
        verify(dispatcher).forward(request, response);
    }

    @Test
    void doGet_unknownStep_shouldReturn404() throws Exception {
        when(request.getParameter("step")).thenReturn("unknown");

        servlet.doGet(request, response);

        verify(response).sendError(eq(HttpServletResponse.SC_NOT_FOUND), anyString());
    }

    // ---------- doPost ----------

    @Test
    void doPost_invalidParams_redirectsToStart() throws Exception {
        when(request.getParameter("answer")).thenReturn(null);
        when(request.getParameter("currentStep")).thenReturn(null);

        servlet.doPost(request, response);

        verify(response).sendRedirect("/game?step=start");
    }

    @Test
    void doPost_answer1_finalStep_incrementsGamesPlayed() throws Exception {
        when(request.getParameter("answer")).thenReturn("1");
        when(request.getParameter("currentStep")).thenReturn("captain");
        when(session.getAttribute("gamesPlayed")).thenReturn(0);

        servlet.doPost(request, response);

        verify(session).setAttribute("gamesPlayed", 1);
        verify(response).sendRedirect("/game?step=win");
    }

    @Test
    void doPost_answer2_finalStep() throws Exception {
        when(request.getParameter("answer")).thenReturn("2");
        when(request.getParameter("currentStep")).thenReturn("start");
        when(session.getAttribute("gamesPlayed")).thenReturn(null);

        servlet.doPost(request, response);

        verify(session).setAttribute("gamesPlayed", 1);
        verify(response).sendRedirect("/game?step=lose1");
    }
}
