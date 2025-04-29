package edu.masanz.da;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinFreemarker;

import edu.masanz.da.controller.ExamController;

public class Main {

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public");
            config.fileRenderer(new JavalinFreemarker());
        }).start(4444);

        app.get("/", ExamController::ejercicio);

    }

}