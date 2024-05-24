package com.benjsoft;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, @RequestParam String username) {
        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        response.setHeader("Session-Id", session.getId());

        return "Logged successfully with session id: " + session.getId();
    }
}
