package by.it.sereda.project.java;

import javax.servlet.http.HttpServletRequest;

interface ActionCommand {
    String execute(HttpServletRequest request);
}