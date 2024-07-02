package com.api;

import javafx.application.Application;
import com.api.service.APIService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Application.launch(APIService.class, args);
    }
}