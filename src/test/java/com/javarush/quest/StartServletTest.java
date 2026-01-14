package com.javarush.quest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;

class StartServletTest {

    private StartServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher dispatcher;

    @BeforeEach
    void setUp() {
        servlet = new StartServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        dispatcher = mock(RequestDispatcher.class);

        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("/index.jsp")).thenReturn(dispatcher);
        when(request.getContextPath()).thenReturn("");
    }

    @Test
    void doGet_shouldForwardToIndexJsp() throws Exception {
        servlet.doGet(request, response);

        verify(dispatcher).forward(request, response);
    }

    @Test
    void doPost_withPlayerName() throws Exception {
        when(request.getParameter("playerName")).thenReturn("Roman");

        servlet.doPost(request, response);

        verify(session).setAttribute("playerName", "Roman");
        verify(session).setAttribute("gamesPlayed", 0);
        verify(response).sendRedirect("/game?step=start");
    }

    @Test
    void doPost_withoutPlayerName_usesDefault() throws Exception {
        when(request.getParameter("playerName")).thenReturn("   ");

        servlet.doPost(request, response);

        verify(session).setAttribute("playerName", "Искатель приключений");
        verify(session).setAttribute("gamesPlayed", 0);
        verify(response).sendRedirect("/game?step=start");
    }
}
