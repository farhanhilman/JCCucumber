package com.juaracoding.utils;

public enum ScenarioTests {

    T1("Successful login with valid credentials"),
    T2("Failed login with invalid credentials"),
    T3("Add a product to the cart successfully"),
    T4("Successfully checkout a product"),
    T5("Failed checkout Product not input firstname"),
    T6("Failed checkout Product not input lastname"),
    T7("Failed checkout Product not input postal code");
    // T1 ... T100

    private String scenarioTestName;

    ScenarioTests(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName() {
        return scenarioTestName;
    }

}