package com.slack.chatgpt.controller;

import com.slack.api.bolt.App;
import com.slack.api.bolt.jakarta_servlet.SlackAppServlet;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/slack/question")
public class SlackAppController extends SlackAppServlet {

    public SlackAppController(App app) {
        super(app);
    }
}
