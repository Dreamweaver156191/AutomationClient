package com.example.automationclient.controller;

public @interface ApiOperation {
    String value();

    Class<String> response();
}
